package com.techelevator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.techelevator.inventory.Fridge;

public class ShoppingCart {
	
	private Map<String, Fridge> shoppingCart = new LinkedHashMap<String, Fridge>();

	public Map<String, Fridge> getShoppingCart() {
		return shoppingCart;
	}
	
	public void addToCart(Entry<String, Fridge> entry) {
		shoppingCart.put(entry.getKey(), entry.getValue());
	}
}
