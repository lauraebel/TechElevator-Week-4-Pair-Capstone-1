package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;

import org.junit.*;

import com.techelevator.inventory.Fridge;
import com.techelevator.reader.TextFileReader;

public class TextFileReaderTest {

	private TextFileReader target;
	
	@Before
	public void setup() {
		target = new TextFileReader();
	}
	
	@Test
	public void first_map_value() throws FileNotFoundException {
		Map<String, Fridge> map = target.restock("cateringsystem.csv");
		Assert.assertTrue(map.containsKey("A1"));
		
		BigDecimal test = (map.get("A1").getItem().getPrice());
		Assert.assertEquals(new BigDecimal(3.50), test);
		
	}
	
}
