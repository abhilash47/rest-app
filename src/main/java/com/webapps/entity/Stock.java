package com.webapps.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Stock {

	@JsonProperty("1. symbol")
	String symbol;
	
	@JsonProperty("2. name")
	String name;
	
	@JsonProperty("3. type")
	String type;

	@JsonProperty("4. region")
	String region;
	
	@JsonProperty("5. marketOpen")
	String marketOpen;

	@JsonProperty("6. marketClose")
	String marketClose;
	
	@JsonProperty("7. timezone")
	String timezone;
	
	@JsonProperty("8. currency")
	String currency;
	
	@JsonProperty("9. matchScore")
	Double matchScore;
		
}
