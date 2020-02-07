package com.techelevator;

import java.math.BigDecimal;

import com.techelevator.view.Menu;

public class CashRegister {

	private BigDecimal balance = new BigDecimal(0);
	private Menu menu = new Menu();

	public BigDecimal getBalance() {
		return balance;
	}
	
	public void addMoney(int money) {
			balance = balance.add(new BigDecimal(money));
	}
}
