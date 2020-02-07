package com.techelevator;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.techelevator.inventory.Fridge;

public class ShoppingCart {
	
	private Map<String, Fridge> shoppingCart = new LinkedHashMap<String, Fridge>();

	public Map<String, Fridge> getShoppingCart() {
		return shoppingCart;
	}
	
	public void addToCart(String key, Fridge fridge, int amount) {
		fridge.setItemCount(amount);
		shoppingCart.put(key, fridge);
	}
	
	public BigDecimal shoppingTotal() {
		BigDecimal total = new BigDecimal(0);
		for(Map.Entry<String, Fridge> entry : shoppingCart.entrySet()) {
			total = total.add(entry.getValue().getItem().getPrice().multiply(new BigDecimal(entry.getValue().getItemCount())));
		}
		return total;
	}
}
