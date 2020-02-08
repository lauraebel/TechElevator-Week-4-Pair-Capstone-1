package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.*;

import com.techelevator.inventory.*;

public class ShoppingCartTest {

	private ShoppingCart target;
	
	@Before
	public void setup() {
		target = new ShoppingCart();
	}
	
	@Test
	public void adding_items_to_fridge_increases_amount_of_items_in_fridge() {
		Fridge fridge = new Fridge(new Desserts("candy", new BigDecimal(8)));
		int amount = 7;
		target.updateAmountInFridge(fridge, amount);
		Assert.assertEquals(7, fridge.getItemCount());
	}
	
	@Test
	public void adding_items_to_shopping_cart_works() {
		String key = "Z3";
		Fridge fridge = new Fridge(new Desserts("candy", new BigDecimal(8)));
		target.addToCart(key, fridge);
		Assert.assertEquals("candy", target.getShoppingCart().get(key).getItem().getName());
		Assert.assertEquals(50, target.getShoppingCart().get(key).getItemCount());
		Assert.assertEquals(new BigDecimal(8), target.getShoppingCart().get(key).getItem().getPrice());
	}
	
	@Test
	public void total_price_of_items_in_shopping_cart_is_accurate() {
		Fridge fridge = new Fridge(new Desserts("candy", new BigDecimal(8.50)));
		Fridge fridgeTwo = new Fridge(new Desserts("candy", new BigDecimal(19)));
		Fridge fridgeTres = new Fridge(new Desserts("candy", new BigDecimal(3)));
		target.addToCart("string", fridge);
		target.addToCart("stringTwo", fridgeTwo);
		target.addToCart("stringTres", fridgeTres);
		Assert.assertEquals(new BigDecimal(1525).setScale(2, RoundingMode.FLOOR), target.shoppingTotal().setScale(2, RoundingMode.FLOOR));
	}
}
