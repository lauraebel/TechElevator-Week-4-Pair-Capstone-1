package com.techelevator.inventory;

public class Fridge {
	
	private int itemCount = 50;
	private Item item;

	public Fridge(Item item) {
		this.item = item;
	}
	
	public int getItemCount() {
		return itemCount;
	}
	
	public Item getItem() {
		return item;
	}

}
