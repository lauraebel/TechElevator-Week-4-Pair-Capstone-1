package com.techelevator.reader;

import java.io.FileNotFoundException;
import java.util.Map;

import com.techelevator.inventory.Fridge;

public interface FileReader {
	
	Map<String, Fridge> restock(String fileName) throws FileNotFoundException;

}
