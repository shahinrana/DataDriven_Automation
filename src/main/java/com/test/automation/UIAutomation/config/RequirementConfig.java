package com.test.automation.UIAutomation.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.test.automation.UIAutomation.testBase.TestBase;

public class RequirementConfig extends TestBase {
	Properties or;
	File file;
	FileInputStream input;

	public static String Requirement;
	public static String CandidateName;
	public static Logger log = Logger.getLogger(RequirementConfig.class.getName());

	public RequirementConfig() {
		try {
			or = new Properties();
			file = new File(System.getProperty("user.dir") + "//resources//properties//RequirementsConfig.properties");
			input = new FileInputStream(file);
			or.load(input);
			RequirementConfig.Requirement = or.getProperty("Requirement");
			RequirementConfig.CandidateName = or.getProperty("CandidateName");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
