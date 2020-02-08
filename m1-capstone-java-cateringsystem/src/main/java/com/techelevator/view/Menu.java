package com.techelevator.view;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.inventory.Fridge;

public class Menu {

	private Scanner in = new Scanner(System.in);
	
	public void displayMessage(String message) {
		System.out.println(message);
	}

	public int mainMenu(Map<String, Fridge> inventory) {
		boolean loop;
		int choice = 0;
		do {
		System.out.println("(1) Display Catering Items\n(2) Order\n(3) Quit");
		try {
			loop = false;
			choice = in.nextInt();
			
		} catch (InputMismatchException e) {
			System.out.println("Error: Invalid option. Please choose again.");
			loop = true;
		} in.nextLine();

		} while (loop);
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
		boolean loop;
		int choiceTwo = 0;
		do {
		System.out.println("(1) Add Money\n(2) Select Products\n(3) Complete Transaction\nCurrent Account Balance: "
				+ "$" + balance);
		try {
			loop = false;
			choiceTwo = in.nextInt();
			
		} catch (InputMismatchException e) {
			System.out.println("Error: Invalid option. Please choose again.");
			loop = true;
		} in.nextLine();

		} while (loop);
			return choiceTwo;
	}

	public int addMoneyMenu() {
		boolean loop;
		int money = 0;
		do {
		System.out.println("How much money do you want to add? (whole dollar amounts only) ");
		try {
			loop = false;
			money = in.nextInt();
			
		} catch (InputMismatchException e) {
			System.out.println("Error: Please enter a number value.");
			loop = true;
		} in.nextLine();

		} while (loop);
			return money;
	}

	public String shoppingCartMenuCode() {
		System.out.println("Enter the product code for the item you want to order: ");

		String code = in.nextLine();
		return code;
	}
	
	public int amountOfProductDesired() {
		boolean loop;
		int amount = 0;
		do {
			System.out.println("How many of this item do you want to order? ");				
		try {
			loop = false;
			amount = in.nextInt();
			
		} catch (InputMismatchException e) {
			System.out.println("Error: Please enter a number value.");
			loop = true;
		} in.nextLine();

		} while (loop);
			return amount;
	}

	public void transactionReport(Map.Entry<String, Fridge> entry) {
		System.out.printf("%-5d %-15s %-30s $%-10.2f $%-10.2f\n", entry.getValue().getItemCount(), entry.getValue().getItem().getType(), 
				entry.getValue().getItem().getName(), entry.getValue().getItem().getPrice(), (entry.getValue().getItem().getPrice()
						.multiply(new BigDecimal(entry.getValue().getItemCount()))));
	}
	
	public void printTransactionTotal(BigDecimal total) {
		System.out.println();
		System.out.println("Total: $" + total);
		System.out.println();
	}
	
	public void displayChange(int twenties, int tens, int fives, int ones, int quarters, int dimes, int nickels) {
		System.out.printf("Twenties: %d \nTens: %d \nFives: %d \nOnes: %d \nQuarters: %d \nDimes: %d \nNickels: %d \n", 
				twenties, tens, fives, ones, quarters, dimes, nickels);
		System.out.println();
	}
}
