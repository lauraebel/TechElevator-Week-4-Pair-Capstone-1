package com.techelevator;

import java.math.BigDecimal;

public class CashRegister {

	private BigDecimal balance = new BigDecimal(0);

	public BigDecimal getBalance() {
		return balance;
	}
	
	public void addMoney(int money) {
			balance = balance.add(new BigDecimal(money));
	}
	
	public void completeTransaction(BigDecimal total) {
		balance = balance.subtract(total);
	}
}
