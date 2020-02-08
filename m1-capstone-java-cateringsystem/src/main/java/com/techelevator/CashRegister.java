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
	
	public void completeTransaction(BigDecimal total) {
		balance = balance.subtract(total);
	}
	
	public void giveChange() {
		while(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(0)) == 1) {
			if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(20)) >= 0) {
				twentyDollarBill++;
				balance = balance.setScale(2, RoundingMode.CEILING).subtract(new BigDecimal(20));
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(10)) >= 0) {
				tenDollarBill++;
				balance = balance.setScale(2, RoundingMode.CEILING).subtract(new BigDecimal(10));
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(5)) >= 0) {
				fiveDollarBill++;
				balance = balance.setScale(2, RoundingMode.CEILING).subtract(new BigDecimal(5));
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(1)) >= 0) {
				oneDollarBill++;
				balance = balance.setScale(2, RoundingMode.CEILING).subtract(new BigDecimal(1));
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(.25)) >= 0) {
				quarter++;
				balance = balance.setScale(2, RoundingMode.CEILING).subtract(new BigDecimal(.25));
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(.10)) >= 0) {
				dime++;
				balance = balance.setScale(2, RoundingMode.CEILING).subtract(new BigDecimal(.10));
			} else if(balance.setScale(2, RoundingMode.CEILING).compareTo(new BigDecimal(.05).setScale(2, RoundingMode.FLOOR)) >= 0) {
				nickel++;
				balance = balance.subtract(new BigDecimal(.05));
			} else {
				balance = new BigDecimal(0);
			}
			System.out.println(balance);
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
