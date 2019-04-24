package com.test.automation.UIAutomation.customListener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.test.automation.UIAutomation.config.ConfigConfiguration;

public class Retry implements IRetryAnalyzer {
	private int retryCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		int maxRetryCount = ConfigConfiguration.getRetryfailedtest();
		if (retryCount < maxRetryCount) {
			System.out.println(
					"Retrying tets" + result.getName() + " with status " + getResultStatusName(result.getStatus()));
			retryCount++;
			return true;
		}
	
		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILUR";
		if (status == 3)
			resultName = "SKIP";
		
		return resultName;
	}

}
