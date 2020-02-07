package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;

import com.techelevator.inventory.Fridge;
import com.techelevator.reader.TextFileReader;
import com.techelevator.view.Menu;

public class CateringSystemCLI {

	private Menu menu;
	private Map<String, Fridge> inventory;
	private TextFileReader reader = new TextFileReader();
	private CashRegister cashRegister = new CashRegister();
	private ShoppingCart shoppingCart = new ShoppingCart();

	private static final String OVER_FIVE_THOUSAND = "Your total balance cannot exceed $5,000. Please re-enter your desired deposit ";
	private static final String BELOW_ZERO = "You cannot deposit a negative number. Please re-enter your desired deposit ";
	private static final String CODE_DOES_NOT_EXIST = "That is not a valid product code.";
	private static final String PRODUCT_SOLD_OUT = "Sorry, this product is sold out.";
	private static final String DESIRED_MORE_THAN_AVAILABLE = "Sorry, there is not enough of that item to fulfill your order.";
	private static final String ADDED_TO_CART = "Selected item(s) successfully added to your shopping cart.";
	private static final String NOT_ENOUGH_MONEY = "Sorry, you do not have enough money in your account to make this purchase.";
	private static final String NOT_VALID_OPTION = "That is not a valid option.";
	
	
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
					int choiceTwo = menu.displayOrderMenu(cashRegister.getBalance());

					if (choiceTwo == 1) {
						int money = menu.addMoneyMenu();
						if ((cashRegister.getBalance().add(new BigDecimal(money))
								.compareTo(new BigDecimal(5000)) == 1)) {
							menu.displayMessage(OVER_FIVE_THOUSAND);
						} else if (money < 0) {
							menu.displayMessage(BELOW_ZERO);
						} else {
							cashRegister.addMoney(money);
						}
					}
					if (choiceTwo == 2) {

						while (true) {
							String code = menu.shoppingCartMenuCode().toUpperCase();

							if (!inventory.containsKey(code)) {
								menu.displayMessage(CODE_DOES_NOT_EXIST);
							}
							if (inventory.get(code).getItemCount() == 0) {
								menu.displayMessage(PRODUCT_SOLD_OUT);
							}
							int amount = menu.amountOfProductDesired();

							if (inventory.get(code).getItemCount() < amount) {
								menu.displayMessage(DESIRED_MORE_THAN_AVAILABLE);
							}
							for (Map.Entry<String, Fridge> cart : inventory.entrySet()) {
								if (cart.getKey().equalsIgnoreCase(code)) {
									Fridge amountAdder = new Fridge(cart.getValue().getItem());
									shoppingCart.updateAmountInFridge(amountAdder, amount);
									if(shoppingCart.shoppingTotal().add(amountAdder.getItem().getPrice()).multiply
											(new BigDecimal(amountAdder.getItemCount())).compareTo(cashRegister.getBalance()) == 1) {
										menu.displayMessage(NOT_ENOUGH_MONEY);
									} else {
										shoppingCart.addToCart(cart.getKey(), amountAdder);
										cart.getValue().setItemCount((cart.getValue().getItemCount()) - amount);
										menu.displayMessage(ADDED_TO_CART);
									}
							
								}
							}
							break;
						}
					}
					if (choiceTwo == 3) {
						cashRegister.completeTransaction(shoppingCart.shoppingTotal());
						for(Map.Entry<String, Fridge> entry : shoppingCart.getShoppingCart().entrySet()) {
							menu.transactionReport(entry);
						}
						menu.printTransactionTotal(shoppingCart.shoppingTotal());
						cashRegister.giveChange();
						menu.displayChange(cashRegister.getTwentyDollarBill(), cashRegister.getTenDollarBill(), cashRegister.getFiveDollarBill(),
								cashRegister.getOneDollarBill(), cashRegister.getQuarter(), cashRegister.getDime(), cashRegister.getNickel());
						break;
					}
					else if (choiceTwo != 1 && choiceTwo != 2 && choiceTwo != 3) {
						menu.displayMessage(NOT_VALID_OPTION);
						continue;
					}
				}
			}
			if (choice == 3) {
				break;
			}
			else if (choice != 1 && choice != 2 && choice != 3) {
				menu.displayMessage(NOT_VALID_OPTION);
				continue;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
