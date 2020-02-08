package com.techelevator.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextLogWriter implements LogWriter {

	private static final String FILE_NAME = "Log.txt";
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss a");
	
	@Override
	public void log(String action, BigDecimal money, BigDecimal balance) throws IOException {
		LocalDateTime now = LocalDateTime.now();
		try (BufferedWriter logger = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
			logger.write(dtf.format(now) + " " + action + " $" + money.setScale(2, RoundingMode.CEILING) + " $" + 
			balance.setScale(2, RoundingMode.CEILING) + System.lineSeparator());
		}

	}
}
