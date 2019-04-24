package com.test.automation.UIAutomation.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.test.automation.UIAutomation.utility.ResourceHelper;

@SuppressWarnings("rawtypes")
public class LoggerHelper {

	private static boolean root = false;

	public static Logger getLogger(Class clas)
	{
		if (root) {
			return Logger.getLogger(clas);
		}
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("/resources/logs/log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}
}
