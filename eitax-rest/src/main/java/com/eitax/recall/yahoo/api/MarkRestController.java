package com.eitax.recall.yahoo.api;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/mark")
public class MarkRestController {
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	public String put(@ModelAttribute String auctionId, UriComponentsBuilder uriComponentsBuilder) {
//		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(uriComponentsBuilder.path("/hoges/{id}").buildAndExpand(store.size()).toUri());
		//return new ResponseEntity<String>(data, headers, HttpStatus.CREATED);
		return "test";
	}
}
