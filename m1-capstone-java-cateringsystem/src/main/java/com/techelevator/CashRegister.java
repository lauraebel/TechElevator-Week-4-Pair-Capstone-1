package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashRegister {

	private BigDecimal balance = new BigDecimal(0);
	private int twentyDollarBill = 0;
	private int tenDollarBill = 0;
	private int fiveDollarBill = 0;
	private int oneDollarBill = 0;
	private int quarter = 0;
	private int dime = 0;
	private int nickel = 0;
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void addMoney(int money) {
			balance = balance.add(new BigDecimal(money));
	}
	
	public void purchaseItem(BigDecimal total) {
		balance = balance.subtract(total);
	}
	
	public void giveChange() {
		while(balance.setScale(2, RoundingMode.FLOOR).compareTo(new BigDecimal(0).setScale(2, RoundingMode.FLOOR)) == 1) {
			
			if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(20).setScale(2, RoundingMode.FLOOR)) >= 0) {
				twentyDollarBill++;
				balance = balance.subtract(new BigDecimal(20));
				
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(10).setScale(2, RoundingMode.FLOOR)) >= 0) {
				tenDollarBill++;
				balance = balance.subtract(new BigDecimal(10));
				
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(5).setScale(2, RoundingMode.FLOOR)) >= 0) {
				fiveDollarBill++;
				balance = balance.subtract(new BigDecimal(5));
				
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(1).setScale(2, RoundingMode.FLOOR)) >= 0) {
				oneDollarBill++;
				balance = balance.subtract(new BigDecimal(1));
				
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(.25).setScale(2, RoundingMode.FLOOR)) >= 0) {
				quarter++;
				balance = balance.subtract(new BigDecimal(.25));
				
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(.10).setScale(2, RoundingMode.FLOOR)) >= 0) {
				dime++;
				balance = balance.subtract(new BigDecimal(.10));
				
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(.05).setScale(2, RoundingMode.FLOOR)) >= 0) {
				nickel++;
				balance = balance.subtract(new BigDecimal(.05));
			}
		}
	}

	public int getTwentyDollarBill() {
		return twentyDollarBill;
	}

	public int getTenDollarBill() {
		return tenDollarBill;
	}

	public int getFiveDollarBill() {
		return fiveDollarBill;
	}

	public int getOneDollarBill() {
		return oneDollarBill;
	}

	public int getQuarter() {
		return quarter;
	}

	public int getDime() {
		return dime;
	}

	public int getNickel() {
		return nickel;
	}
}
