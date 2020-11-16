package com.qa.ims.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {
	private static Logger LOGGER = LogManager.getLogger();

	private final Scanner scanner;

	public Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public Utils() {
		scanner = new Scanner(System.in);
	}

	public Long getLong() {
		String input = getString();
		Long longInput = null;
		try {
			longInput = Long.parseLong(input);
		} catch (NumberFormatException nfe) {
			LOGGER.info("Error - Please enter an integer number");
			longInput = getLong();
		}
		return longInput;
	}

	public String getString() {
		return scanner.nextLine();
	}

	public Double getDouble() {
		String input = getString();
		Double doubleInput = null;
		try {
			doubleInput = Double.parseDouble(input);
		} catch (NumberFormatException nfe) {
			LOGGER.info("Error - Please enter a number");
			doubleInput = getDouble();
		}
		return doubleInput;
	}
	
	public List<Long> getLongList() {
		String input = getString();
		List<Long> longListInput = null;
		try {
			longListInput = new ArrayList<>();
			String[] inputSplit = input.split(" ");
			for (String longString : inputSplit) {
				longListInput.add(Long.parseLong(longString));
			}
		} catch (NumberFormatException nfe) {
			LOGGER.info("Error - Please enter a list of integer numbers, separated by spaces");
			longListInput = getLongList();
		}
		return longListInput;
	}

}
