package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Map;

import com.techelevator.inventory.Fridge;
import com.techelevator.reader.TextFileReader;
import com.techelevator.view.Menu;

public class CateringSystemCLI {

	private Menu menu;
	private Map<String, Fridge> inventory;
	private TextFileReader reader = new TextFileReader();
	private CashRegister cashRegister = new CashRegister();

	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		inventory = reader.restock("cateringsystem.csv");
		while (true) {
			int choice = menu.mainMenu(inventory);

			if (choice == 1) {

				for (Map.Entry<String, Fridge> entry : inventory.entrySet()) {

					if (entry.getValue().getItemCount() == 0) {
						menu.displayItemMenuSoldOut(entry);
					} else {
						menu.displayItemMenu(entry);
					}
				}
			}
			if (choice == 2) {
				while (true) {
					int choiceTwo = menu.displayOrderMenu();

					if (choiceTwo == 1) {
						int money = menu.addMoneyMenu();
						cashRegister.addMoney(money);
					}
					if (choiceTwo == 2) {

						while (true) {
							String code = menu.shoppingCartMenuCode();
							
							if (!inventory.containsKey(code)) {
								menu.codeDoesNotExist();
							} if (inventory.get(code).getItemCount() == 0) {
								menu.productSoldOut();
							}
							int amount = menu.amountOfProductDesired();
							
							if (inventory.get(code).getItemCount() < amount) {
								menu.desiredIsMoreThanAvailable();
							}
						}
					}
				}
			}
			// TODO quit
		
		
		
		
		
		
		
		
		
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
