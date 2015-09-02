package com.eitax.recall.yahoo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.eitax.recall.yahoo.api.model.Result;
import com.eitax.recall.yahoo.facade.YahooServiceFacade;

@RestController
@RequestMapping("api/mark")
public class MarkRestController {
	private static final Logger log = LoggerFactory.getLogger(MarkRestController.class);

	@Autowired
	private YahooServiceFacade yahooServiceFacade;
	
	@RequestMapping(value="{yahooAuctionItemId}",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<Result> putMark(@PathVariable Integer yahooAuctionItemId, @RequestParam Integer markId,UriComponentsBuilder uriComponentsBuilder) {
		System.out.println(yahooAuctionItemId);
		log.info(yahooAuctionItemId.toString());
		Result r = new Result();
		int ret = this.yahooServiceFacade.updateAuctionItem(yahooAuctionItemId, markId);
		r.setCode(ret);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Access-Control-Allow-Headers", "x-requested-with");
//		headers..setLocation(uriComponentsBuilder.path("/hoges/{id}").buildAndExpand(store.size()).toUri());
		return new ResponseEntity<Result>(r, headers, HttpStatus.CREATED);
	}
}
