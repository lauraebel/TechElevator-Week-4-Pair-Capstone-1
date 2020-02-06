package com.techelevator;

import com.techelevator.view.Menu;

public class CateringSystemCLI {

	private Menu menu;

	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			/*
			Display the Starting Menu and get the users choice
			
			IF the User Choice is Display Vending Machine Items, 
				THEN display vending machine items
			ELSE IF the User's Choice is Purchase,
				THEN go to the purchase menu
			*/
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
