package com.eitax.recall.yahoo.facade.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.eitax.recall.model.Recall;
import com.eitax.recall.service.SharedService;
import com.eitax.recall.yahoo.facade.YahooServiceFacade;
import com.eitax.recall.yahoo.model.YahooApi;
import com.eitax.recall.yahoo.model.YahooApiCall;
import com.eitax.recall.yahoo.model.YahooAuctionItem;
import com.eitax.recall.yahoo.rest.YahooRestService;
import com.eitax.recall.yahoo.rest.search.xsd.ItemType;
import com.eitax.recall.yahoo.rest.search.xsd.ResultSet;
import com.eitax.recall.yahoo.service.YahooService;

@Component
public class YahooServiceFacadeImpl implements YahooServiceFacade {

	@Autowired
	private SharedService sharedService;
	@Autowired
	private YahooRestService yahooRestService;
	@Autowired
	private YahooService yahooService;
	@Autowired
	private JavaMailSender javaMailSender;

	private static final Logger log = LoggerFactory.getLogger(YahooServiceFacadeImpl.class);

	@Override
	public int updateAuctionItem(Integer yahooAuctionItemId, Integer markId) {
		// TODO Auto-generated method stub
		return this.yahooService.updateAuctionItemMarkId(yahooAuctionItemId, markId);
	}

	private void send(String subject, String message) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo("nonamennm03@gmail.com");
		smm.setReplyTo("pf437283@yj9.so-net.ne.jp");
		smm.setFrom("pf437283@yj9.so-net.ne.jp");
		smm.setSubject(subject);
		smm.setText(message);
		javaMailSender.send(smm);

	}
	public void ack() throws Exception{
		log.warn("READY");
		List<YahooAuctionItem> list = yahooService.findByBidOrBuy(10);
		for (YahooAuctionItem yai : list){
			send(yai.getTitle(),yai.getAuctionItemUrl());
			this.yahooService.updateAuctionItemByPK(1, yai.getYahooAuctionItemId());
		}
		log.warn("DONE:"+list.size());
	}

	@Override
	public void registerAuctionItems2() throws IOException {
		// TODO Auto-generated method stub
		int call = 0;
		String json = null;
		YahooApiCall yac = null;
		YahooApi aa = null;
		try {
			yac = yahooService.registerYahooApiCallAndFindYahooApi();
			aa = yac.getYahooApi();
			List<Recall> recalls = sharedService.findRecallByDelFlag(0);
			for (Recall recall : recalls) {
				log.info(recall.getRecallName());
				final int INITIAL_ITEM_PAGE = 1;
				int available = yahooRestService.retrieveAuctionSearchCount2(aa.getAppid(), recall.getRecallName(),
						INITIAL_ITEM_PAGE, aa.getDelay(), aa.getUserAgent(), aa.getTimeout());
				int pageCount = (int) Long.divideUnsigned(available, 20) + 1;
				sharedService.updateYahooPageCntByRecallId(recall.getRecallId(), available, pageCount);
				++call;
				for (int i = INITIAL_ITEM_PAGE; i < pageCount; i++) {
					if (recall.getYahooPageLimit() <= i) {
						break;
					}

					ResultSet rs = yahooRestService.invokeAuctionSearch2(aa.getAppid(), recall.getRecallName(), i, aa.getDelay(),
							aa.getUserAgent(), aa.getTimeout());
					if (rs == null){
						continue;
					}
					if (rs.getResult() == null){
						continue;
					}
					++call;
					for (ItemType it : rs.getResult().getItem()) {
						String auctionId = it.getAuctionID();
						YahooAuctionItem yci = this.yahooService.findByAuctionId(auctionId);
						if (yci == null){
							log.warn("yci is unavailable : "+recall.getRecallName()+":"+auctionId);
//							com.eitax.recall.yahoo.rest.auctionItem.xsd.ResultSet itemDetail = yahooRestService.invokeAuctionItemSearch2(aa.getAppid(), auctionId,
//								aa.getDelay(), aa.getUserAgent(), aa.getTimeout());
//							++call;
							yahooService.registerItems2(it, recall.getRecallId(), null);
						}
						else{
							log.warn("yci is available : "+recall.getRecallName()+":"+auctionId);
						}
						
					}
				}
			}
		} catch(RuntimeException e){
			e.printStackTrace();
			log.error("error : ", e);
			send(aa.getAppid() + ":" + e.getMessage(), json != null ? json : "test");
			throw e;
		}
		catch (IOException e) {
			e.printStackTrace();
			log.error("error : ", e);
			send(aa.getAppid() + ":" + e.getMessage(), json != null ? json : "test");
			throw e;
		} finally {
			yahooService.updateApiCallCount(yac.getYahooApiCallId(), call);
		}

	}

}
