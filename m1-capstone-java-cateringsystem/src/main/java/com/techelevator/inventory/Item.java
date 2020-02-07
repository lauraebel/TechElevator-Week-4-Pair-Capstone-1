package com.techelevator.inventory;

import java.math.BigDecimal;

public class Item {
	
	private String name;
	private BigDecimal price;
	private String type;
	
	public Item(String name, BigDecimal price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}

}
