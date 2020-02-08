package com.techelevator;

import java.math.BigDecimal;

import org.junit.*;

import com.techelevator.inventory.*;

public class FridgeItemTest {
	
	private Fridge target;
	private Item item;
	
	@Before
	public void setup() {
		target = new Fridge(item);
	}
	
	@Test
	public void adding_dessert_to_fridge_produces_correct_item_name_price_and_quantity() {
		Fridge fridge = new Fridge(new Desserts("candy", new BigDecimal(8)));
		Assert.assertEquals("Desserts", fridge.getItem().getType());
		Assert.assertEquals("candy", fridge.getItem().getName());
		Assert.assertEquals(50, fridge.getItemCount());
		Assert.assertEquals(new BigDecimal(8), fridge.getItem().getPrice());
	}
	
	@Test
	public void adding_beverage_to_fridge_produces_correct_item_name_price_and_quantity() {
		Fridge fridge = new Fridge(new Beverages("soda", new BigDecimal(6)));
		Assert.assertEquals("Beverages", fridge.getItem().getType());
		Assert.assertEquals("soda", fridge.getItem().getName());
		Assert.assertEquals(50, fridge.getItemCount());
		Assert.assertEquals(new BigDecimal(6), fridge.getItem().getPrice());
	}
	
	@Test
	public void adding_appetizer_to_fridge_produces_correct_item_name_price_and_quantity() {
		Fridge fridge = new Fridge(new Appetizers("shrimps", new BigDecimal(16)));
		Assert.assertEquals("Appetizers", fridge.getItem().getType());
		Assert.assertEquals("shrimps", fridge.getItem().getName());
		Assert.assertEquals(50, fridge.getItemCount());
		Assert.assertEquals(new BigDecimal(16), fridge.getItem().getPrice());
	}
	
	@Test
	public void adding_entree_to_fridge_produces_correct_item_name_price_and_quantity() {
		Fridge fridge = new Fridge(new Entrees("filet mignon", new BigDecimal(600)));
		Assert.assertEquals("Entrees", fridge.getItem().getType());
		Assert.assertEquals("filet mignon", fridge.getItem().getName());
		Assert.assertEquals(50, fridge.getItemCount());
		Assert.assertEquals(new BigDecimal(600), fridge.getItem().getPrice());
	}
	
	
	
	
}
