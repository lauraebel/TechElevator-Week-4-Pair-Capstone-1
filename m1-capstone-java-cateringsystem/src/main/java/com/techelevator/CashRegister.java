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
		if((balance.add(new BigDecimal(money)).compareTo(new BigDecimal(5000)) == 1)) {
			menu.overFiveThousand();
		} if(money < 0) {
			menu.belowZero();
		} else {
			balance = balance.add(new BigDecimal(money));
		}
	}
}
