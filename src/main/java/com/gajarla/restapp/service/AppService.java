package com.gajarla.restapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gajarla.restapp.entity.BestMatches;
import com.gajarla.restapp.entity.Stock;
import com.gajarla.restapp.gateway.AppGateway;

@Component
public class AppService {

	@Autowired
	AppGateway gateway;
	
	public BestMatches getMatchingStocks(String name) {		
		return gateway.searchForCompany(name);		
	}
	
	public Optional<Stock> getBestMatch(String name) {
		
		return getMatchingStocks(name)
				.getBestMatches()
				.stream()
				.reduce((x,y) -> x.getMatchScore() > y.getMatchScore() ? x : y);
//				.get();

	}
	
}
