package com.test.automation.UIAutomation.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.LandingPage.HomePage;
import com.test.automation.UIAutomation.LandingPage.Pages;
import com.test.automation.UIAutomation.LoginPage.LoginPage;
import com.test.automation.UIAutomation.testBase.TestBase;

public class DashboardAdminHeaderTest extends TestBase {
	public static Logger log = Logger.getLogger(DashboardAdminHeaderTest.class.getName());
	SoftAssert s_assert = new SoftAssert();

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData(Config.getProperty("exelsheetname"),
				Config.getProperty("SingleLoginTestData"));
		return testRecords;
	}

	@Test(dataProvider = "loginData", timeOut = 15000, priority = 0)
	public void Logins(String emailAddress, String password, String runMode) throws InterruptedException {

		if (runMode.equalsIgnoreCase("n")) {
			log.info("verifiyLoginWithDifferentRecords method skipped");
			test = extent.startTest("Login_With_DifferentRecords");
			test.log(LogStatus.INFO, "verifiyLoginWithDifferentRecords method skipped");
			test.log(LogStatus.SKIP, "Login and logout skipped");
			throw new SkipException("Skipping this exception");
		}

		else {
			try {
				jsp = new LoginPage(driver);

				driver.navigate().refresh();
				log.info("**********starting test**********");

				test = extent.startTest("Login Testcase");

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

	@Test(dependsOnMethods = "Logins", priority = 1)
	public void selctDashboardPage() throws InterruptedException 
	{
		test = extent.startTest("Select Dashboard Page TestCase");
		test.log(LogStatus.INFO, "Dashboard is selected");
		Pages.homapage();
		HomePage.singleHeaderMethod("Dashboard");	
	}
	
	@Test(dependsOnMethods = "selctDashboardPage", priority = 2)
	public void selectHeader() throws InterruptedException 
	{
		test = extent.startTest("Select Header");
		test.log(LogStatus.INFO, "Header is selected");
		click(Pages.DashboardMainPage().HeaderSelect("AM KPI"));//Dashboard
	}
	
	/*@Test(dependsOnMethods = "selectHeader", priority = 3)
	public void exportReport() throws InterruptedException 
	{
		test = extent.startTest("Export Report TestCase");
		test.log(LogStatus.INFO, "Location is selected");
		click(Pages.SubDashboardPage().selectLocation("Vadodara"));
		System.out.println(getText(Pages.SubDashboardPage().getCount("Prospective")));
		test.log(LogStatus.INFO, "Day is selected");
		click(Pages.SubDashboardPage().selectDaybtn("Day"));
		test.log(LogStatus.INFO, "Report is Exported");
		click(Pages.SubDashboardPage().selectExportbtn());
	}	*/
	@Test(dependsOnMethods = "selectHeader", priority = 3)
	public void exportReport() throws InterruptedException, FileNotFoundException, IOException 
	{
		try {
			click(Pages.AmKpiPage().dropDownKPITYPE("YoY Growth"));
			click(Pages.AmKpiPage().dropDownAccountManager("Chirayu Patel"));
			click(Pages.AmKpiPage().dropDownYear("2017"));	
			click(Pages.AmKpiPage().dropDownByMonth("January"));
			Pages.AmKpiPage().getMonthData();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
}
