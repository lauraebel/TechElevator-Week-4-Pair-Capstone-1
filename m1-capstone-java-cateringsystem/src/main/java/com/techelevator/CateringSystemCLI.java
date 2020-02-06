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
				while(true) {
					int choiceTwo = menu.displayOrderMenu();

					if (choiceTwo == 1) {
						menu.addMoneyMenu();
						cashRegister.addMoney();
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
