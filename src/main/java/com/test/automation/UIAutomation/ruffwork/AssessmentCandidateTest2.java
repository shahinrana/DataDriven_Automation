package com.test.automation.UIAutomation.ruffwork;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.LandingPage.HomePage;
import com.test.automation.UIAutomation.LandingPage.Pages;
import com.test.automation.UIAutomation.LoginPage.LoginPage;
import com.test.automation.UIAutomation.helper.CalenderSelect;
import com.test.automation.UIAutomation.testBase.TestBase;

public class AssessmentCandidateTest2 extends TestBase {
	public static Logger log = Logger.getLogger(AssessmentCandidateTest2.class.getName());

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		// String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
		String[][] testRecords = getData(Config.getProperty("exelsheetname"),
				Config.getProperty("SingleLoginTestData"));
		return testRecords;
	}

	@Test(dataProvider = "loginData", timeOut = 15000, priority = 0)
	public void Logins(String emailAddress, String password, String runMode) throws InterruptedException {

		if (runMode.equalsIgnoreCase("n")) {
			log.info("verifiyLoginWithDifferentRecords method skipped");
			test = extent.startTest("verifiyLoginWithDifferentRecords");
			test.log(LogStatus.INFO, "verifiyLoginWithDifferentRecords method skipped");
			test.log(LogStatus.SKIP, "Login and logout skipped");
			throw new SkipException("Skipping this exception");
		}

		else {
			try {
				jsp = new LoginPage(driver);

				driver.navigate().refresh();
				log.info("**********starting test**********");

				test = extent.startTest("Logins");

				log.info("try to login with username:" + emailAddress + " and password" + password);
				test.log(LogStatus.INFO, "Email:" + emailAddress + " and password : " + password);

				boolean LoginSuccessStatus = LoginPage.loginToApplication(emailAddress, password);
				log.info("LoginSuccessStatus:" + LoginSuccessStatus);

				log.info("Login functionality working fine");
				log.info("**********finish test************");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Test()
	public static void SelectHeader() 
	{
		test = extent.startTest("SelectHeader");		
		try {
			//Pages.homapage().singleHeaderMethod("Emails");
			test.log(LogStatus.INFO, "Select Header : New Requirement");
			Pages.homapage();
			HomePage.subHeaderMethod("Requirements","New Requirement");
			test.log(LogStatus.INFO, "Select Sub Menu");
		} catch (Exception e) {
			
			log.info(e.getMessage());
		}	

	}	

	@Test
	public void selectCalender() throws InterruptedException
	{
		WebElement searchTextbox=driver.findElement(By.xpath("//*[@id='RequirementOpenDate']"));
		click(searchTextbox);
		CalenderSelect.calender("04/20/2020");
		Thread.sleep(3000);
		WebElement closeDate=driver.findElement(By.xpath("//*[@id='RequirementCloseTentativeDate']"));
		click(closeDate);
		CalenderSelect.calender("04/20/2020");
	}
	
	
}
