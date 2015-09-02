package com.eitax.recall.yahoo.job;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.eitax.recall.yahoo.facade.YahooServiceFacade;


@Component
public class CronJob {
	  @Autowired
	  private YahooServiceFacade yahooServiceFacade;
	  
	  private static final Logger log = LoggerFactory.getLogger(CronJob.class);
	  
	  @Scheduled(fixedDelay = 60000) 
	  public void invoke() throws IOException{
		  try {
			log.info("READY");
			yahooServiceFacade.registerAuctionItems();
			log.info("DONE");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	  }

	
	
//	@Autowired
//	private RecallDAOImpl recallService;
//	@Autowired
//	private YahooAuctionItemDAOImpl yahooAuctionItemService;
//	@Autowired
//	private YahooShoppingItemDAOImpl yahooShoppingItemService;
//	@Autowired
//	private YahooApiCallDAOImpl yahooApiCallService;
//	@Autowired
//	private YahooApiServiceDAOImpl yahooApiService;
//	private static final Logger log = LoggerFactory.getLogger(CronJob.class);
//
//	@Scheduled(fixedRate = 900000)
//	public void invoke() {
//		try {
//			DateTime now = DateTime.now().withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("JST")))
//					.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
//			String yyyyMMdd = now.toString("yyyyMMdd");
//			log.info(yyyyMMdd);
//			List<YahooApiCall> list = yahooApiCallService.findByCallYyyymmdd(now.toString("yyyyMMdd"));
//			if (0 == list.size()) {
//				List<YahooApi> yahooApiList = yahooApiService.findAll();
//				for (YahooApi ya : yahooApiList) {
//					YahooApiCall yap = new YahooApiCall();
//					yap.setCnt(0);
//					yap.setYyyymmdd(yyyyMMdd);
//					yap.setDelFlag(0);
//					yap.setYahooApi(ya);
//					yahooApiCallService.save(yap);
//				}
//				list = yahooApiCallService.findByCallYyyymmdd(now.toString("yyyyMMdd"));
//			}
//			YahooApiCall apc = list.get(0);
//			String appid = apc.getYahooApi().getAppid();
//			log.info(appid);
//			// if (true)return;
//
//			int call = 0;
//			Page<Recall> recalls = recallService.findByDelFlag(0, new PageRequest(0, 100));
//			for (Recall recall : recalls) {
//				Thread.sleep(500);
//				log.info("########" + recall.getRecallName());
//				String shopping = ItemSearchApiClient.invoke(appid, recall.getRecallName());
//				++call;
//				JSONObject shoppingRoot = JSONObject.fromObject(shopping);
//				JSONObject shoppingResultSet = shoppingRoot.getJSONObject("ResultSet");
//				Long totalResultsAvailable = shoppingResultSet.getLong("totalResultsAvailable");
//				if (0 < totalResultsAvailable) {
//					JSONObject result = shoppingRoot.getJSONObject("ResultSet").getJSONObject("0")
//							.getJSONObject("Result");
//					JSONObject hit = result.getJSONObject("0");
//					YahooShoppingItem ysi = new YahooShoppingItem();
//					ysi.setItemName(hit.getString("Name"));
//					ysi.setDescription(hit.getString("Description"));
//					ysi.setUrl(hit.getString("Url"));
//					JSONObject price = hit.getJSONObject("Price");
//					ysi.setPrice(price.getInt("_value"));
//					ysi.setJan(hit.getString("JanCode"));
//					ysi.setModel(hit.getString("Model"));
//					ysi.setIsbn(hit.getString("IsbnCode"));
//					JSONObject store = hit.getJSONObject("Store");
//
//					ysi.setStoreId(store.getString("Id"));
//					ysi.setStoreName(store.getString("Name"));
//					ysi.setRecallId(recall.getRecallId());
//
//					yahooShoppingItemService.save(ysi);
//				}
//				String json = YahooApiSearchClient.invoke(appid, recall.getRecallName(), 1);
//				JSONObject root = JSONObject.fromObject(json);
//				JSONObject resultSet = root.getJSONObject("ResultSet");
//				JSONObject attributes = resultSet.getJSONObject("@attributes");
//				Long available = attributes.getLong("totalResultsAvailable");
//				int page = (int) Long.divideUnsigned(available, 20);
//
//				for (int i = 0; i < page; i++) {
//					if (6 <= i) {
//						break;
//					}
//					json = YahooApiSearchClient.invoke(appid, recall.getRecallName(), i + 1);
//					++call;
//					root = JSONObject.fromObject(json);
//					resultSet = root.getJSONObject("ResultSet");
//					attributes = resultSet.getJSONObject("@attributes");
//					available = attributes.getLong("totalResultsAvailable");
//
//					if (available <= 0) {
//						continue;
//					} else if (available <= 1) {
//						JSONObject item = resultSet.getJSONObject("Result").getJSONObject("Item");
//						String auctionId = item.getString("AuctionID");
//						YahooAuctionItem tmp = yahooAuctionItemService.findByAuctionId(auctionId);
//						yahooAuctionItemService.removeByAuctionId(auctionId);
//						String itemJson = YahooApiItemSearchClient.invoke(appid, auctionId);
//						++call;
//						log.info(itemJson);
//						JSONObject itemRoot = JSONObject.fromObject(itemJson);
//						int storeFlag = itemRoot.getJSONObject("ResultSet").getJSONObject("Result")
//								.getJSONObject("Option").has("StoreIcon") ? 1 : 0;
//
//						YahooAuctionItem yai = new YahooAuctionItem();
//						yai.setTitle(item.getString("Title"));
//						yai.setEndTime(item.getString("EndTime"));
//						yai.setCurrentPrice(item.getInt("CurrentPrice"));
//						yai.setAuctionId(item.getString("AuctionID"));
//						yai.setCategoryId(item.getString("CategoryId"));
//						yai.setBidOrBuy(item.has("BidOrBuy") ? item.getInt("BidOrBuy") : 0);
//						yai.setSellerId(item.getJSONObject("Seller").getString("Id"));
//						yai.setAuctionItemUrl(item.getString("AuctionItemUrl"));
//						yai.setRecallId(recall.getRecallId());
//						yai.setStoreFlag(storeFlag);
//						yai.setBids(item.getInt("Bids"));
//						yai.setMarkId(tmp != null ? tmp.getMarkId() : 2);
//						yahooAuctionItemService.save(yai);
//						continue;
//					} else {
//						System.out.println(json);
//						JSONArray itemArray = resultSet.getJSONObject("Result").getJSONArray("Item");
//
//						for (int j = 0; j < itemArray.size(); j++) {
//							Thread.sleep(1000);
//							JSONObject item = itemArray.getJSONObject(j);
//							String auctionId = item.getString("AuctionID");
//							YahooAuctionItem tmp = yahooAuctionItemService.findByAuctionId(auctionId);
//							yahooAuctionItemService.removeByAuctionId(auctionId);
//							String itemJson = YahooApiItemSearchClient.invoke(appid, auctionId);
//							++call;
//							JSONObject itemRoot = JSONObject.fromObject(itemJson);
//							int storeFlag = itemRoot.getJSONObject("ResultSet").getJSONObject("Result")
//									.getJSONObject("Option").has("StoreIcon") ? 1 : 0;
//							YahooAuctionItem yai = new YahooAuctionItem();
//							yai.setTitle(item.getString("Title"));
//							yai.setEndTime(item.getString("EndTime"));
//							yai.setStartTime(
//									itemRoot.getJSONObject("ResultSet").getJSONObject("Result").getString("StartTime"));
//							yai.setCurrentPrice(item.getInt("CurrentPrice"));
//							yai.setAuctionId(item.getString("AuctionID"));
//							yai.setCategoryId(item.getString("CategoryId"));
//							yai.setBidOrBuy(item.has("BidOrBuy") ? item.getInt("BidOrBuy") : 0);
//							yai.setSellerId(item.getJSONObject("Seller").getString("Id"));
//							yai.setAuctionItemUrl(item.getString("AuctionItemUrl"));
//							yai.setRecallId(recall.getRecallId());
//							yai.setStoreFlag(storeFlag);
//							yai.setBids(item.getInt("Bids"));
//							yai.setMarkId(tmp != null ? tmp.getMarkId() : 2);
//							yahooAuctionItemService.save(yai);
//						}
//					}
//				}
//			}
//			log.info(String.valueOf(call));
//			yahooApiCallService.update(apc.getYahooApiCallId(), call);
//
//		} catch (Exception e) {
//			log.error("Exception occurred : "+e);
//		}
//	}
}
