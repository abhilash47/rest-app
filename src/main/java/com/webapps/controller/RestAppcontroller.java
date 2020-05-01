package com.webapps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webapps.entity.BestMatches;
import com.webapps.entity.Stock;
import com.webapps.service.AppService;

@RestController
public class RestAppcontroller {
	
	@Autowired
	AppService service;
	
	@GetMapping("/{str}")
	public BestMatches getString(@PathVariable(value = "str") String s) {
		
		return service.getMatchingStocks(s);

	}
	
	@GetMapping("/best/{str}")
	public Stock getBestString(@PathVariable(value = "str") String s) {
		
		return service.getBestMatch(s);

	}
	
	@GetMapping("/app/{str}")
	public String getString2(@PathVariable(value = "str") String s) {
		
		if (s.equals("check500")) {
			throw new RuntimeException("This is 500 error");
		} 
		if (s.equals("check400")) {
			throw new RuntimeException("This is 400 error");
		} 
		return "Text is : " + s;
	}
	
	
	
}
