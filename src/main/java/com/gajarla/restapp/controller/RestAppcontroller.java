package com.gajarla.restapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gajarla.restapp.entity.BestMatches;
import com.gajarla.restapp.entity.Stock;
import com.gajarla.restapp.exception.ServiceRuntimeException;
import com.gajarla.restapp.service.AppService;

@RestController
public class RestAppcontroller {
	
	@Autowired
	AppService service;
	
	@GetMapping("/{str}")
	public BestMatches getString(@PathVariable(value = "str") String s) {
		
		return service.getMatchingStocks(s);

	}
	
	@GetMapping("/best/{str}")
	public Optional<Stock> getBestString(@PathVariable(value = "str") String s) {
		
		Optional<Stock> response = service.getBestMatch(s);
		
		if(response.isPresent()) {
			return response;
		} else {
			throw new ServiceRuntimeException("No Valid Match Found", "Check the name you entered");
		}

	}
	
	@GetMapping("/app/{str}")
	public String getString2(@PathVariable(value = "str") String s) {
		
		if (s.equals("check500")) {
			throw new RuntimeException("This is 500 error");
		} 
		if (s.equals("check400")) {
			throw new ServiceRuntimeException("This is 400 error", "This is a custom exception");
		} 
		
		return "Text is : " + s;
	}
	
}
