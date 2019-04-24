package com.test.automation.UIAutomation.ruffwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyRead {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fis= new FileInputStream("C:\\Users\\shahinrana\\workspace\\SourceProsUSA_New\\resources\\properties\\Config.properties");
		Properties config= new Properties();
		config.load(fis);
		System.out.println(config.getProperty("testsiteurl"));
	}

}
