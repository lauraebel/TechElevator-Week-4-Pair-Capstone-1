package com.techelevator.view;

import java.util.Map;
import java.util.Scanner;

import com.techelevator.CashRegister;
import com.techelevator.inventory.Fridge;

public class Menu {

	private CashRegister cashRegister = new CashRegister();

	private Scanner in = new Scanner(System.in);

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

	public int displayOrderMenu() {
		System.out.println("(1) Add Money\n(2) Select Products\n(3) Complete Transaction\nCurrent Account Balance: "
				+ "$" + cashRegister.getBalance());

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

	public void overFiveThousand() {
		System.out.println("Your total balance cannot exceed $5,000. Please re-enter your desired deposit ");
	}

	public void belowZero() {
		System.out.println("You cannot deposit a negative number. Please re-enter your desired deposit ");
	}

	public String shoppingCartMenuCode() {
		System.out.println("Enter the product code for the item you want to order: ");

		String code = in.nextLine();
		return code;
	}

	public void codeDoesNotExist() {
		System.out.println("That is not a valid product code.");

	}
	
	public void productSoldOut() {
		System.out.println("Sorry, this product is sold out.");
	}
	
	public int amountOfProductDesired() {
		System.out.println("How many of this item do you want to order? ");
		
		int amount = in.nextInt();
		in.nextLine();
		return amount;
	}
	
	public void desiredIsMoreThanAvailable() {
		System.out.println("Sorry, there is not enough of that item to fulfill your order.");
	}
}
