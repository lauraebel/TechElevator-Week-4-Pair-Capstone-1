package com.techelevator.writer;

import java.io.IOException;
import java.math.BigDecimal;

public interface LogWriter {

	void log(String action, BigDecimal money, BigDecimal balance) throws IOException;
}
