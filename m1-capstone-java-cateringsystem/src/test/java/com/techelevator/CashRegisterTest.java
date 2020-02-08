package com.techelevator;

import java.math.BigDecimal;

import org.junit.*;

public class CashRegisterTest {
	
	private CashRegister target;
	
	@Before
	public void setup() {
		target = new CashRegister();
	}

	@Test
	public void gives_proper_twenties() {
		target.addMoney(80);
		target.purchaseItem(new BigDecimal(60));
		target.giveChange();
		
		Assert.assertEquals(1, target.getTwentyDollarBill());
	}
	
	@Test
	public void gives_proper_tens() {
		target.addMoney(80);
		target.purchaseItem(new BigDecimal(50));
		target.giveChange();
		
		Assert.assertEquals(1, target.getTenDollarBill());
	}
	
	@Test
	public void gives_proper_fives() {
		target.addMoney(80);
		target.purchaseItem(new BigDecimal(55));
		target.giveChange();
		
		Assert.assertEquals(1, target.getFiveDollarBill());
	}
	
	@Test
	public void gives_proper_ones() {
		target.addMoney(10);
		target.purchaseItem(new BigDecimal(6));
		target.giveChange();
		
		Assert.assertEquals(4, target.getOneDollarBill());
	}
	
	@Test
	public void gives_proper_quarters() {
		target.addMoney(10);
		target.purchaseItem(new BigDecimal(6.25));
		target.giveChange();
		
		Assert.assertEquals(3, target.getQuarter());
	}
	
	@Test
	public void gives_proper_dimes() {
		target.addMoney(10);
		target.purchaseItem(new BigDecimal(6.80));
		target.giveChange();
		
		Assert.assertEquals(2, target.getDime());
	}
	
	@Test
	public void gives_proper_nickels() {
		target.addMoney(10);
		target.purchaseItem(new BigDecimal(6.85));
		target.giveChange();
		
		Assert.assertEquals(1, target.getNickel());
	}
}
