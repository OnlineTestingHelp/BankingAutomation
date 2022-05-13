package com.banking.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

public class Utilities {
	
	public static String readProperty(String property) throws IOException {
		File file = new File("src/test/java/com/banking/config/env.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(property);
	}
	
	public static String AccountNumber() {
		
		String accNum = String.valueOf(ThreadLocalRandom.current().nextInt(1000000,2000000));
		return accNum;
	}
	
	public static void main(String args[]) {
		System.out.println(AccountNumber());
	}

}
