package com.techelevator.view;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.inventory.Fridge;

public class Menu {

	private Scanner in = new Scanner(System.in);
	
	public void displayMessage(String message) {
		System.out.println(message);
	}

	public int mainMenu(Map<String, Fridge> inventory) {
		System.out.println("(1) Display Catering Items\n(2) Order\n(3) Quit");
		int choice = in.nextInt();
		in.nextLine();
		return choice;
	}

	public void displayItemMenuSoldOut(Map.Entry<String, Fridge> entry) {

		System.out.println(entry.getKey() + " | Item: " + entry.getValue().getItem().getName() + " | Price per Item: $"
				+ entry.getValue().getItem().getPrice() + " | Amount Left: " + "SOLD OUT\n");
	}

	public void displayItemMenu(Map.Entry<String, Fridge> entry) {
		System.out.println(entry.getKey() + " | Item: " + entry.getValue().getItem().getName() + " | Price per Item: $"
				+ entry.getValue().getItem().getPrice() + " | Amount Left: " + entry.getValue().getItemCount());
		System.out.println();
	}

	public int displayOrderMenu(BigDecimal balance) {
		System.out.println("(1) Add Money\n(2) Select Products\n(3) Complete Transaction\nCurrent Account Balance: "
				+ "$" + balance);

		int choiceTwo = in.nextInt();
		in.nextLine();
		return choiceTwo;

	}

	public int addMoneyMenu() {
		System.out.println("How much money do you want to add? (whole dollar amounts only) ");

		int money = in.nextInt();
		in.nextLine();
		return money;
	}

	public String shoppingCartMenuCode() {
		System.out.println("Enter the product code for the item you want to order: ");

		String code = in.nextLine();
		return code;
	}
	
	public int amountOfProductDesired() {
		System.out.println("How many of this item do you want to order? ");
		
		int amount = in.nextInt();
		in.nextLine();
		return amount;
	}

}
