package com.webapps.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.webapps.entity.BestMatches;

@Component
public class AppGateway {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.symbolSearch}")
	private String searchApiUrl;
	
	@Value("${api.key}")
	private String apikey;
	
	public BestMatches searchForCompany(String name) {
		
		ResponseEntity<BestMatches> response;		
		String url = searchApiUrl + "keywords=" + name + "&apikey=" + apikey;		
		// https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords={name}&apikey=JV6VI30GFW1QYSW8
		
		try {			
			response = restTemplate.getForEntity(url, BestMatches.class);			
			return response.getBody();
			
		} catch (RestClientException e) {
			e.printStackTrace();
			 throw new RuntimeException("Exception while calling SEARCH_SYMBOL");
		}
		
	}
}
