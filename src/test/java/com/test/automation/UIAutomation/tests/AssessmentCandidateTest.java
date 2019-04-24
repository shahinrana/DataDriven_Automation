package com.test.automation.UIAutomation.tests;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.LandingPage.Pages;
import com.test.automation.UIAutomation.LoginPage.LoginPage;
import com.test.automation.UIAutomation.helper.BrowserHelper;
import com.test.automation.UIAutomation.testBase.TestBase;

public class AssessmentCandidateTest extends TestBase {
	public static Logger log = Logger.getLogger(AssessmentCandidateTest.class.getName());
	SoftAssert s_assert = new SoftAssert();

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

	@Test(dependsOnMethods = "Logins", priority = 1)
	public void selctCandidateListPage() throws InterruptedException {
		Pages.homapage().subHeaderMethod("Candidates", "Candidate List");	
	}

	@DataProvider(name = "checkbox")
	public String[][] selectCheckbox() {
		String[][] testRecords = getData(Config.getProperty("exelsheetname"), Config.getProperty("AssignCandidate"));
		return testRecords;
	}

	@Test(dependsOnMethods = "Logins", dataProvider = "checkbox", priority = 2)
	public void selectCandidate(String name, String checked) {
		if (checked.equalsIgnoreCase("no")) {
			log.info("SelectCandidate method skipped");
			test = extent.startTest("Select Candidate");
			test.log(LogStatus.INFO, "Select Candidate method skipped");
			test.log(LogStatus.SKIP, "Select Candidate skipped");
			throw new SkipException("Skipping this exception");
		} else {
			click(Pages.candidatelist().getCandidateWithCheckbox(name));
		}
	}
	@Test(priority=3,enabled=true)
	public void clickAssignbtn() throws InterruptedException
	{
		click(Pages.candidatelist().assignBtnClick());
		BrowserHelper browserHelper= new BrowserHelper(driver);
		browserHelper.SwitchToWindow(1);
		Pages.AssignCandidatePage().dropdownClient("AbbVie Inc.");
		Thread.sleep(2000);
		Pages.AssignCandidatePage().selectListRequirement("Pipelined");
		Thread.sleep(2000);
		click(Pages.AssignCandidatePage().chekboxRequirement("RCI-ABV-12616-Pipeline"));
		Pages.AssignCandidatePage().clickAssessment("Assessment");
		
	}

	
	
}
