package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import com.techelevator.inventory.Fridge;
import com.techelevator.reader.TextFileReader;
import com.techelevator.view.Menu;
import com.techelevator.writer.TextLogWriter;

public class CateringSystemCLI {

	private Menu menu;
	private Map<String, Fridge> inventory;
	private TextFileReader reader = new TextFileReader();
	private CashRegister cashRegister = new CashRegister();
	private ShoppingCart shoppingCart = new ShoppingCart();
	private TextLogWriter textLogWriter = new TextLogWriter();
	
	private static final String OVER_FIVE_THOUSAND = "Your total balance cannot exceed $5,000. Please re-enter your desired deposit ";
	private static final String BELOW_ZERO = "You cannot deposit a negative number. Please re-enter your desired deposit ";
	private static final String CODE_DOES_NOT_EXIST = "That is not a valid product code.";
	private static final String PRODUCT_SOLD_OUT = "Sorry, this product is sold out.";
	private static final String DESIRED_MORE_THAN_AVAILABLE = "Sorry, there is not enough of that item to fulfill your order.";
	private static final String ADDED_TO_CART = "Selected item(s) successfully added to your shopping cart.";
	private static final String NOT_ENOUGH_MONEY = "Sorry, you do not have enough money in your account to make this purchase.";
	private static final String NOT_VALID_OPTION = "That is not a valid option.";
	private static final String ADD_MONEY = "ADD MONEY";
	private static final String GIVE_CHANGE = "GIVE CHANGE";
	
	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	public void run(){
		try { 
			inventory = reader.restock("cateringsystem.csv");
		} catch (FileNotFoundException e) {
			System.out.println("Failed to Read Inventory");
		}
		while (true) {
			
			int choice = menu.mainMenu(inventory);

			if (choice == 1) { //(1) Display Catering Items

				for (Map.Entry<String, Fridge> entry : inventory.entrySet()) {

					if (entry.getValue().getItemCount() == 0) {
						menu.displayItemMenuSoldOut(entry);
						
					} else {
						menu.displayItemMenu(entry);
					}
				}
			}
			if (choice == 2) { //(2) Order
				while (true) {
					int choiceTwo = menu.displayOrderMenu(cashRegister.getBalance());

					if (choiceTwo == 1) { //(1) Add Money
						int money = menu.addMoneyMenu();
						
						if ((cashRegister.getBalance().add(new BigDecimal(money))
								.compareTo(new BigDecimal(5000)) == 1)) {
							menu.displayMessage(OVER_FIVE_THOUSAND);
							
						} else if (money < 0) {
							menu.displayMessage(BELOW_ZERO);
							
						} else {
							cashRegister.addMoney(money);
							try { 
								textLogWriter.log(ADD_MONEY, new BigDecimal(money), cashRegister.getBalance());
							} catch (IOException e) {
								System.out.println("Unable to Write Report");
							}
						}
					}
					if (choiceTwo == 2) { //(2) Select Products

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
										cashRegister.purchaseItem(amountAdder.getItem().getPrice().multiply(new BigDecimal(amountAdder.getItemCount())));
										cart.getValue().setItemCount((cart.getValue().getItemCount()) - amount);
										menu.displayMessage(ADDED_TO_CART);
										
										try { 
											textLogWriter.log(amountAdder.getItemCount() + " " + amountAdder.getItem().getName() + " " 
													+ cart.getKey(), amountAdder.getItem().getPrice().multiply(new BigDecimal
													(amountAdder.getItemCount())), cashRegister.getBalance());									
										} catch (IOException e) {
											System.out.println("Unable to Write Report");
										}
					
									}
							
								}
							}
							break;
						}
					}
					if (choiceTwo == 3) { //(3) Complete Transaction and Give Change
						for(Map.Entry<String, Fridge> entry : shoppingCart.getShoppingCart().entrySet()) {
							menu.transactionReport(entry);
						}
						menu.printTransactionTotal(shoppingCart.shoppingTotal());
						BigDecimal holdBalance = cashRegister.getBalance();
						cashRegister.giveChange();
						
						try { 
							textLogWriter.log(GIVE_CHANGE, holdBalance, cashRegister.getBalance());
						} catch (IOException e) {
							System.out.println("Unable to Write Report");
						}
						
						menu.displayChange(cashRegister.getTwentyDollarBill(), cashRegister.getTenDollarBill(), cashRegister.getFiveDollarBill(),
								cashRegister.getOneDollarBill(), cashRegister.getQuarter(), cashRegister.getDime(), cashRegister.getNickel());
						
						shoppingCart = new ShoppingCart(); //empties shopping cart after transaction completed
						break;
					}
					else if (choiceTwo != 1 && choiceTwo != 2 && choiceTwo != 3) {
						menu.displayMessage(NOT_VALID_OPTION);
						continue;
					}
				}
			}
			if (choice == 3) { //(3) Quit
				break;
			}
			else if (choice != 1 && choice != 2 && choice != 3) {
				menu.displayMessage(NOT_VALID_OPTION);
				continue;
			}
		}
	}
	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
