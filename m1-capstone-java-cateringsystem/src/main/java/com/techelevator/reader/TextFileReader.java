package com.techelevator.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.techelevator.inventory.*;

public class TextFileReader implements FileReader {
	
	private Item item;
	
	private Map<String, Fridge> inventory = new TreeMap<String, Fridge>();

	@Override
	public Map<String, Fridge> restock(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		List<String> lines = new ArrayList<String>();
		
		try(Scanner fileScanner = new Scanner(file)) {
			while(fileScanner.hasNextLine()) {
				lines.add(fileScanner.nextLine());
			}
		}
		
		for(String line : lines) {
			String [] values = line.split("\\|");
			
			if(values[3].equals("B")) {
				item = new Beverages(values[1], new BigDecimal(values[2]));
			} if(values[3].equals("E")) {
				item = new Entrees(values[1], new BigDecimal(values[2]));
			} if(values[3].equals("A")) {
				item = new Appetizers(values[1], new BigDecimal(values[2]));
			} if(values[3].equals("D")) {
				item = new Desserts(values[1], new BigDecimal(values[2]));
			}
			Fridge fridge = new Fridge(item);
			inventory.put(values[0], fridge);
		}
		return inventory;
	}

	public Map<String, Fridge> getInventory() {
		return inventory;
	}

}
