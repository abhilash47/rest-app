package com.webapps.service;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapps.entity.BestMatches;
import com.webapps.entity.Stock;
import com.webapps.gateway.AppGateway;

@Component
public class AppService {

	@Autowired
	AppGateway gateway;
	
	public BestMatches getMatchingStocks(String name) {		
		return gateway.searchForCompany(name);		
	}
	
	public Stock getBestMatch(String name) {
		
		BestMatches matches = getMatchingStocks(name);
		
		if(matches.getBestMatches().isEmpty()) {
			throw new RuntimeException("No valid matches");
		} else {
			// get Stock with highest matchScore
			return matches
					.getBestMatches()
					.stream()
					.max(Comparator.comparing(Stock::getMatchScore))
					.get();
		}
		
	}
	
}
