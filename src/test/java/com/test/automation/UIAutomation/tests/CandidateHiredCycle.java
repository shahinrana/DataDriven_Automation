package com.test.automation.UIAutomation.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.LandingPage.HomePage;
import com.test.automation.UIAutomation.LandingPage.Pages;
import com.test.automation.UIAutomation.LoginPage.LoginPage;
import com.test.automation.UIAutomation.config.RequirementConfig;
import com.test.automation.UIAutomation.helper.JavaScriptHelper;
import com.test.automation.UIAutomation.testBase.TestBase;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Conversation;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Email;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Interview;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.OfferAccepted;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.OfferReceived;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Prospective;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.RequirmentLifeCycle;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.SMSSendToCandidate;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Shortlisted;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Submission;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.SubmissionDetailsPage;

public class CandidateHiredCycle extends TestBase {

	public static Logger log = Logger.getLogger(CandidateHiredCycle.class.getName());
	public static String requirementList=null;
	public static String candidateName=null;
	/*public static String requirementList = Requirementconfig.Requirement;
	public static String candidateName = Requirementconfig.CandidateName;*/

	@BeforeClass
	public void beforeTest()
	{		
		//log.info("CandidateName:"+System.getProperty("candidateName"));
		if(System.getProperty("candidatname")!=null && !System.getProperty("candidatname").isEmpty())		
		{
			candidateName=System.getProperty("candidatname");
		}
		else
		{
			candidateName=RequirementConfig.CandidateName;
		}
	}
	
	@BeforeClass
	public void beforeTest2()
	{	
		//log.info("Requirement Name:"+System.getProperty("requirement"));
		if(System.getProperty("requirement")!=null && !System.getProperty("requirement").isEmpty())		
		{
			requirementList=System.getProperty("requirement");
		}
		else
		{
			requirementList = Requirementconfig.Requirement;
		}
	}
	@DataProvider(name = "SingleLoginTestData")
	public String[][] getTestData() {
		
		String[][] testRecords = getData(Config.getProperty("exelsheetname"),
				Config.getProperty("SingleLoginTestData"));
		return testRecords;
	}


	@Test(dataProvider = "SingleLoginTestData")
	public static void login(String emailAddress, String password, String runMode) throws InterruptedException {

		if (runMode.equalsIgnoreCase("n")) {
			log.info("verifiy Login With Different Records method skipped");
			// test = extent.startTest("verifiy Login With Different Records");
			test.log(LogStatus.INFO, "verifiy Login With Different Records method skipped");
			test.log(LogStatus.SKIP, "Login and logout skipped");
			throw new SkipException("Skipping this exception");

		} else {

			log.info("starting login test");
			test = extent.startTest("Candidate Life Cycle SourceProc US User Login");
			try {
				Pages.loginpage();
				LoginPage.loginToApplication(emailAddress, password);

				test.log(LogStatus.INFO,
						"Login successfully: username:" + emailAddress + "\t" + " password" + password + "\t");
				log.info("Enter username and password");
				test.log(LogStatus.INFO, "Login method successfully:");

			} catch (Exception e) {

				log.info(e.getMessage());
			}
		}
	}

	@Test(dependsOnMethods = { "login" },alwaysRun=true)
	public static void searchRequirement()
	{
		log.info("Requirement="+requirementList);
		log.info("candidateName="+candidateName);
		sendKeys(HomePage.searchTextbox(), requirementList);
		click(HomePage.searchBtn());
		//javascripthelper.javaScriptSendText(, requirementList);
	}
	
	@Test(dependsOnMethods = { "searchRequirement" })
	public static void selectMatches() {
		test = extent.startTest("Select Matches");
		try {
			Pages.homapage();
			JavaScriptHelper.clickElementByJS(HomePage.selectOption(requirementList, "Matches"));
			test.log(LogStatus.INFO, "Select Matches");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test(dependsOnMethods = { "selectMatches" })
	public static void AddCandidateReferences() {
		test = extent.startTest("Add Candidate References");
		try {
			switchWindow("Candidate Matches");
			Thread.sleep(3000);
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.selectCandidate(candidateName));
			test.log(LogStatus.INFO, "Selected Candidate");
			switchWindow("Candidate Detail");
			test.log(LogStatus.INFO, "Switch to Candidate Detail");
			JavaScriptHelper.clickElementByJS(Pages.CandidateDetailPage().SelenctTabInfo("Additional Info"));
			test.log(LogStatus.INFO, "Selected Additional info");
			for (int i = 1; i <= 2; i++) {
				Thread.sleep(3000);
				System.out.println("loop:" + i);
				JavaScriptHelper.clickElementByJS(Pages.CandidateDetailPage().addReference());
				test.log(LogStatus.INFO, "Selected Add reference");
				JavaScriptHelper.javaScriptSendText(Pages.CandidateDetailPage().refContactName(), "Testing");
				test.log(LogStatus.INFO, "Contact name Entered");
				JavaScriptHelper.javaScriptSendText(Pages.CandidateDetailPage().refContactNo(), "123-456-7890");
				test.log(LogStatus.INFO, "Contact number Entered");
				JavaScriptHelper.javaScriptSendText(Pages.CandidateDetailPage().refEmail(), "test@test.com");
				test.log(LogStatus.INFO, "Email entered");
				JavaScriptHelper.clickElementByJS(Pages.CandidateDetailPage().refSave());
				test.log(LogStatus.INFO, "Reference Save button clicked");
			}
			JavaScriptHelper.clickElementByJS(Pages.CandidateDetailPage().bottomSavebtn());
			test.log(LogStatus.INFO, "Save button clicked");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = { "AddCandidateReferences" })
	public static void assessment() {
		test = extent.startTest("Assessment To Prospective");
		try {
			Thread.sleep(3000);
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");		
			Thread.sleep(3000);
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.assessmentCall(candidateName));
			test.log(LogStatus.INFO, "Select Call");
			switchWindow("Conversation");
			test.log(LogStatus.INFO, "Switch to conversation window"); //
			Pages.Conversation();
			JavaScriptHelper.clickElementByJS(Conversation.phoneNumber());
			Pages.Conversation();
			Conversation.phoneNumber().sendKeys("7698950001");
			test.log(LogStatus.INFO, "Enter phone number");
			Pages.Conversation();
			JavaScriptHelper.clickElementByJS(Conversation.conversion("Confirmed for this requirement"));
			test.log(LogStatus.INFO, "Select click on confirmation");
			Pages.Conversation();
			sendKeys(Conversation.summary(), "summary");
			test.log(LogStatus.INFO, "Entered summary");
			Pages.Conversation();
			sendKeys(Conversation.timeToJoin(), "yes...........");
			test.log(LogStatus.INFO, "Enterd time to join");
			Pages.Conversation();
			Conversation.isConfirmationReceived("yes");
			test.log(LogStatus.INFO, "confiremation Received");
			Pages.Conversation();
			Conversation.save();
			test.log(LogStatus.INFO, "click on save button");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3 seconds...");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matches window");
			Pages.RequirmentLifeCycle();
			Select(RequirmentLifeCycle.assessmentAction(candidateName), "Prospective");
			test.log(LogStatus.INFO, "Select propspective");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "waiting for 3seconds...");
			Pages.Prospective();
			sendKeys(Prospective.payRateAmount(), "1000");
			test.log(LogStatus.INFO, "Entered pay Rate amount");
			Pages.Prospective();
			Select(Prospective.contractType(), "W2-ExhibitA");
			test.log(LogStatus.INFO, "Select contrect type");
			Pages.Prospective();
			sendKeys(Prospective.distance(), "100");
			test.log(LogStatus.INFO, "Entered distance");
			Pages.Prospective();
			sendKeys(Prospective.uploadBackgroundCheck(),
					"C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
			test.log(LogStatus.INFO, "provide path to upload file");
			Pages.Prospective();
			click(Prospective.termAndCondition());
			test.log(LogStatus.INFO, "Click on term and condition");
			Pages.Prospective();
			Prospective.save();
			test.log(LogStatus.INFO, "Click on save");

		} catch (Exception e) {
			e.printStackTrace();
		}
		extent.endTest(test);
	}

	@Test(dependsOnMethods = { "assessment" })
	// @Test(dependsOnMethods = { "selectMatches" }, alwaysRun = true) public
	public static void prospective() {
		test = extent.startTest("Prospective To Submission");
		try {
			// click(Pages.RequirmentLifeCycle().selectLifeCycle("Prospective"));
			// test.log(LogStatus.INFO, "Select prospective");
			Thread.sleep(3000);
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			Thread.sleep(3000);
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.prospectiveSMS(candidateName));
			test.log(LogStatus.INFO, "Select SMS option in Prospective page");
			switchWindow("SMS Send To Candidate");
			test.log(LogStatus.INFO, "Switch to SMS window");
			Pages.SMSSendToCandidate();
			sendKeys(SMSSendToCandidate.textboxPhoneNo(), "7698950001");
			test.log(LogStatus.INFO, "Entered phone number");
			Pages.SMSSendToCandidate();
			JavaScriptHelper.clickElementByJS(SMSSendToCandidate.sendMessage());
			test.log(LogStatus.INFO, "Click on send");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "wait for 3seconds...");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matches window...");
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.prospectiveCall(candidateName));
			test.log(LogStatus.INFO, "click on Call option in prospective page");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "wait for 3seconds...");
			switchWindow("Conversation");
			test.log(LogStatus.INFO, "Switch to conversation window");
			Pages.Conversation();
			Conversation.phoneNumber().sendKeys("7698950001");
			test.log(LogStatus.INFO, "Enter phone number");
			Pages.Conversation();
			JavaScriptHelper.clickElementByJS(Conversation.conversion("Confirmed for this requirement"));
			test.log(LogStatus.INFO, "Click on conversion option");
			Pages.Conversation();
			sendKeys(Conversation.summary(), "summary");
			test.log(LogStatus.INFO, "Entered summary");
			Pages.Conversation();
			sendKeys(Conversation.timeToJoin(), "yes...........");
			test.log(LogStatus.INFO, "Enter time to join");
			Pages.Conversation();
			Conversation.isConfirmationReceived("yes");
			test.log(LogStatus.INFO, "Select yes for isconfirmation radiobox");
			Pages.Conversation();
			Conversation.save();
			test.log(LogStatus.INFO, "Click on Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Wait for 3seconds...");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to candidate matches window");
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.prospectiveEditView(candidateName));
			test.log(LogStatus.INFO, "Click on Edit View in prospective window");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			Pages.Prospective();
			sendKeys(Prospective.distance(), "100");
			test.log(LogStatus.INFO, "Entered distance");
			Pages.Prospective();
			Select(Prospective.contractType(), "W2-ExhibitA");
			test.log(LogStatus.INFO, "Entered contract type");
			Pages.Prospective();
			sendKeys(Prospective.uploadBackgroundCheck(),
					"C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
			test.log(LogStatus.INFO, "Upload the back ground check file");
			Pages.Prospective();
			JavaScriptHelper.clickElementByJS(Prospective.termAndCondition());
			test.log(LogStatus.INFO, "Select term and condition");
			Pages.Prospective();
			Prospective.save();
			test.log(LogStatus.INFO, "Click on Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			Pages.RequirmentLifeCycle();
			Select(RequirmentLifeCycle.prospectiveAction(candidateName), "Submission");
			test.log(LogStatus.INFO, "Entered Bill Rate");
			Pages.Submission();
			sendKeys(Submission.SubmittedBillRate(), "100");
			test.log(LogStatus.INFO, "Select Action in prospective page");
			Pages.Submission();
			Submission.uploadFile().sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
			test.log(LogStatus.INFO, "upload file");
			Pages.Submission();
			Select(Submission.submissionStatus(), "Submitted");
			test.log(LogStatus.INFO, "Select submit");
			Pages.Submission();
			JavaScriptHelper.clickElementByJS(Submission.termsCondtion());
			test.log(LogStatus.INFO, "Select term and condition");
			Pages.Submission();
			JavaScriptHelper.clickElementByJS(Submission.save());
			test.log(LogStatus.INFO, "Select Save");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = { "prospective" })
	public static void submission() {

		test = extent.startTest("Submission To Shortlisted");
		try {
			// click(Pages.RequirmentLifeCycle().selectLifeCycle("Submission"));
			Thread.sleep(3000);
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			Thread.sleep(3000);
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.submissionCall(candidateName));
			test.log(LogStatus.INFO, "Select Call");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			switchWindow("Conversation");
			test.log(LogStatus.INFO, "Swithch to Conversation window");
			Pages.Conversation();
			Conversation.phoneNumber().sendKeys("7698950001");
			test.log(LogStatus.INFO, "Entered phone number");
			Pages.Conversation();
			JavaScriptHelper.clickElementByJS(Conversation.conversion("Confirmed for this requirement"));
			test.log(LogStatus.INFO, "Select Confirm");
			Pages.Conversation();
			sendKeys(Conversation.summary(), "summary");
			test.log(LogStatus.INFO, "Entered summary");
			Pages.Conversation();
			sendKeys(Conversation.timeToJoin(), "yes...........");
			test.log(LogStatus.INFO, "Entered time to join...");
			Pages.Conversation();
			Conversation.isConfirmationReceived("yes");
			test.log(LogStatus.INFO, "selected for confiramation");
			Pages.Conversation();
			Conversation.save();
			test.log(LogStatus.INFO, "Select Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to candidate matches window");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.submissionEditView(candidateName));
			test.log(LogStatus.INFO, "Select Edit view");
			Pages.Submission();
			sendKeys(Submission.uploadFile(),
					"C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
			test.log(LogStatus.INFO, "Upload file");
			Pages.Submission();
			JavaScriptHelper.clickElementByJS(Submission.termsCondtion());
			test.log(LogStatus.INFO, "Select term and condition");
			Pages.Submission();
			JavaScriptHelper.clickElementByJS(Submission.save());
			test.log(LogStatus.INFO, "Click Save");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate matches");
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.submissionDetails(candidateName));
			test.log(LogStatus.INFO, "Click on submission Details");
			switchWindow("Submission Details");
			test.log(LogStatus.INFO, "Switch to submission window");
			Pages.SubmissionDetailsPage();
			Select(SubmissionDetailsPage.selectRCTLAM(), "Hetal");
			test.log(LogStatus.INFO, "Select TL");
			Pages.SubmissionDetailsPage();
			JavaScriptHelper.clickElementByJS(SubmissionDetailsPage.selectAccept());
			test.log(LogStatus.INFO, "Select Accept");
			Pages.SubmissionDetailsPage();
			Select(SubmissionDetailsPage.selectQualityOfResume(), "Excellent Resume, Good work done.");
			test.log(LogStatus.INFO, "Select QualityOfResume");
			Pages.SubmissionDetailsPage();
			JavaScriptHelper.clickElementByJS(SubmissionDetailsPage.save());
			test.log(LogStatus.INFO, "Select Save");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matches");
			Pages.RequirmentLifeCycle();
			Select(RequirmentLifeCycle.submissionAction(candidateName), "Shortlisted");
			test.log(LogStatus.INFO, "Select Action");
			switchWindow("Shortlisted");
			test.log(LogStatus.INFO, "Swithch to Shortlisted window");
			Pages.Shortlisted();
			JavaScriptHelper.clickElementByJS(Shortlisted.interviewReceived());
			test.log(LogStatus.INFO, "Select intervied Received");
			Pages.Shortlisted();
			sendKeys(Shortlisted.comments(), "testing");
			test.log(LogStatus.INFO, "Entered comments");
			Pages.Shortlisted();
			JavaScriptHelper.clickElementByJS(Shortlisted.save());
			test.log(LogStatus.INFO, "Select save");
			switchWindow("Email");
			test.log(LogStatus.INFO, "Switch to Email window");
			Pages.Email();
			JavaScriptHelper.clickElementByJS(Email.send());
			test.log(LogStatus.INFO, "Select send");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = { "submission" })
	public static void shortlisted() {
		test = extent.startTest("Shortlisted To Interview");
		try {
			Thread.sleep(3000);
			switchWindow("Candidate Matches");
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.selectLifeCycle("Shortlisted"));
			
			Thread.sleep(3000);
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			Thread.sleep(3000);
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.shortlistedSMS(candidateName));
			test.log(LogStatus.INFO, "Select SMS for submission");
			switchWindow("SMS Send To Candidate");
			test.log(LogStatus.INFO, "Switch to SMS");
			Pages.SMSSendToCandidate();
			sendKeys(SMSSendToCandidate.textboxPhoneNo(), "7698950001");
			test.log(LogStatus.INFO, "Entered phone number");
			Pages.SMSSendToCandidate();
			JavaScriptHelper.clickElementByJS(SMSSendToCandidate.sendMessage());
			test.log(LogStatus.INFO, "Select send message");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.shortlistedCall(candidateName));
			test.log(LogStatus.INFO, "Select shortlisted Call");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			switchWindow("Conversation");
			test.log(LogStatus.INFO, "Switch to conversation window");
			Pages.Conversation();
			Conversation.phoneNumber().sendKeys("7698950001");
			test.log(LogStatus.INFO, "Enterd phone number");
			Pages.Conversation();
			JavaScriptHelper.clickElementByJS(Conversation.conversion("Confirmed for this requirement"));
			test.log(LogStatus.INFO, "Select Conversion");
			Pages.Conversation();
			sendKeys(Conversation.summary(), "summary");
			test.log(LogStatus.INFO, "Entered Summary");
			Pages.Conversation();
			sendKeys(Conversation.timeToJoin(), "yes...........");
			test.log(LogStatus.INFO, "Entered time to join");
			Pages.Conversation();
			Conversation.isConfirmationReceived("yes");
			test.log(LogStatus.INFO, "click on confirmation revceid");
			Pages.Conversation();
			Conversation.save();
			test.log(LogStatus.INFO, "Select Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.shortlistedEditView(candidateName));
			test.log(LogStatus.INFO, "Click on Edit view");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds");
			switchWindow("Shortlisted");
			test.log(LogStatus.INFO, "Switch to shortlisted window");
			Pages.Shortlisted();
			JavaScriptHelper.clickElementByJS(Shortlisted.interviewReceived());
			test.log(LogStatus.INFO, "click on interview received");
			Pages.Shortlisted();
			sendKeys(Shortlisted.comments(), "candidate moved to next stage.");
			test.log(LogStatus.INFO, "Entered data in comments");
			Pages.Shortlisted();
			JavaScriptHelper.clickElementByJS(Shortlisted.save());
			test.log(LogStatus.INFO, "Click on Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matches window");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds");
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.shortlistedDetails(candidateName));
			test.log(LogStatus.INFO, "Click on shortlisted detaisl");
			switchWindow("Submission Details");
			test.log(LogStatus.INFO, "Swithch to submission window");
			Pages.SubmissionDetailsPage();
			Select(SubmissionDetailsPage.selectRCTLAM(), "Hetal");
			test.log(LogStatus.INFO, "Select TL");
			Pages.SubmissionDetailsPage();
			JavaScriptHelper.clickElementByJS(SubmissionDetailsPage.selectAccept());
			test.log(LogStatus.INFO, "Click on Accept");
			Pages.SubmissionDetailsPage();
			Select(SubmissionDetailsPage.selectQualityOfResume(), "Excellent Resume, Good work done.");
			test.log(LogStatus.INFO, "Select quality of resume");
			Pages.SubmissionDetailsPage();
			JavaScriptHelper.clickElementByJS(SubmissionDetailsPage.save());
			test.log(LogStatus.INFO, "Select Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds.");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds.");
			Pages.RequirmentLifeCycle();
			Select(RequirmentLifeCycle.shortlistedAction(candidateName), "Interview");
			test.log(LogStatus.INFO, "Select Shorlisted Action");
			switchWindow("Interview");
			test.log(LogStatus.INFO, "Switch to Interview window");
			Pages.Interview();
			Select(Interview.dropdownInterviewAppeal(), "Accepted");
			test.log(LogStatus.INFO, "Select interview appeal");
			Pages.Interview();
			sendKeys(Interview.interviewDateTime(), "03/22/2018 13:00" + Keys.ENTER);
			test.log(LogStatus.INFO, "Enter interview date and time");
			Pages.Interview();
			Select(Interview.dropdownInterviewType(), "In Person");
			test.log(LogStatus.INFO, "Select interview type");
			Pages.Interview();
			Select(Interview.dropdownInterviewResult(), "Completed");
			test.log(LogStatus.INFO, "Select Interview Result");
			Pages.Interview();
			sendKeys(Interview.referenceCheckDocument(),
					"C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
			test.log(LogStatus.INFO, "Enter reference check ducument");
			Pages.Interview();
			JavaScriptHelper.clickElementByJS(Interview.save());
			test.log(LogStatus.INFO, "Select Save");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = { "shortlisted" })
	public static void interview() {
		test = extent.startTest("Interview To Offer Received");
		try {
			//click(Pages.RequirmentLifeCycle().selectLifeCycle("Interview"));
			Thread.sleep(3000);
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			Thread.sleep(3000);
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.interviewSMS(candidateName));
			test.log(LogStatus.INFO, "Select SMS ");
			switchWindow("SMS Send To Candidate");
			test.log(LogStatus.INFO, "Switch to SMS");
			Pages.SMSSendToCandidate();
			sendKeys(SMSSendToCandidate.textboxPhoneNo(), "7698950001");
			test.log(LogStatus.INFO, "Entered phone number");
			Pages.SMSSendToCandidate();
			JavaScriptHelper.clickElementByJS(SMSSendToCandidate.sendMessage());
			test.log(LogStatus.INFO, "Select send message");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.interviewCall(candidateName));
			test.log(LogStatus.INFO, "Select shortlisted Call");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			switchWindow("Conversation");
			test.log(LogStatus.INFO, "Switch to conversation window");
			Pages.Conversation();
			Conversation.phoneNumber().sendKeys("7698950001");
			test.log(LogStatus.INFO, "Enterd phone number");
			Pages.Conversation();
			JavaScriptHelper.clickElementByJS(Conversation.conversion("Confirmed for this requirement"));
			test.log(LogStatus.INFO, "Select Conversion");
			Pages.Conversation();
			sendKeys(Conversation.summary(), "summary");
			test.log(LogStatus.INFO, "Entered Summary");
			Pages.Conversation();
			sendKeys(Conversation.timeToJoin(), "yes...........");
			test.log(LogStatus.INFO, "Entered time to join");
			Pages.Conversation();
			Conversation.isConfirmationReceived("yes");
			test.log(LogStatus.INFO, "click on confirmation revceid");
			Pages.Conversation();
			Conversation.save();
			test.log(LogStatus.INFO, "Select Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.interviewEditView(candidateName));
			test.log(LogStatus.INFO, "Click on Edit view");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds");
			switchWindow("Interview");
			test.log(LogStatus.INFO, "Switch to Interview window");
			Pages.Interview();
			Select(Interview.dropdownInterviewAppeal(), "Accepted");
			test.log(LogStatus.INFO, "Select interview appeal");
			Pages.Interview();
			sendKeys(Interview.interviewDateTime(), "03/22/2018 13:00" + Keys.ENTER);
			test.log(LogStatus.INFO, "Enter interview date and time");
			Pages.Interview();
			Select(Interview.dropdownInterviewType(), "In Person");
			test.log(LogStatus.INFO, "Select interview type");
			Pages.Interview();
			Select(Interview.dropdownInterviewResult(), "Completed");
			test.log(LogStatus.INFO, "Select Interview Result");
			Pages.Interview();
			sendKeys(Interview.referenceCheckDocument(),
					"C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
			test.log(LogStatus.INFO, "Enter reference check ducument");
			Pages.Interview();
			JavaScriptHelper.clickElementByJS(Interview.save());
			test.log(LogStatus.INFO, "Select Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.interviewDetails(candidateName));
			test.log(LogStatus.INFO, "Click on interview Details");
			switchWindow("Submission Details");
			test.log(LogStatus.INFO, "Swithch to submission window");
			Pages.SubmissionDetailsPage();
			Select(SubmissionDetailsPage.selectRCTLAM(), "Hetal");
			test.log(LogStatus.INFO, "Select TL");
			Pages.SubmissionDetailsPage();
			JavaScriptHelper.clickElementByJS(SubmissionDetailsPage.selectAccept());
			test.log(LogStatus.INFO, "Click on Accept");
			Pages.SubmissionDetailsPage();
			Select(SubmissionDetailsPage.selectQualityOfResume(), "Excellent Resume, Good work done.");
			test.log(LogStatus.INFO, "Select quality of resume");
			Pages.SubmissionDetailsPage();
			JavaScriptHelper.clickElementByJS(SubmissionDetailsPage.save());
			test.log(LogStatus.INFO, "Select Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds.");
			switchWindow("Candidate Matches");
			Pages.RequirmentLifeCycle();
			Select(RequirmentLifeCycle.interviewAction(candidateName), "Offer Received");
			test.log(LogStatus.INFO, "Click on Action");
			switchWindow("OfferReceived");
			test.log(LogStatus.INFO, "switch to offer received");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds.");
			Pages.OfferReceived();
			JavaScriptHelper.clickElementByJS(OfferReceived.selectOfferStatus("Offer Received"));
			test.log(LogStatus.INFO, "select offer status");
			Pages.OfferReceived();
			Select(OfferReceived.selectPayRateType(), "Monthly");
			test.log(LogStatus.INFO, "select payrate type");
			Pages.OfferReceived();
			OfferReceived.startDate("03/14/2018");
			test.log(LogStatus.INFO, "Entered start date");
			Pages.OfferReceived();
			JavaScriptHelper.clickElementByJS(OfferReceived.save());
			test.log(LogStatus.INFO, "Select save");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dependsOnMethods = { "interview" })
	public static void offerRecived() {
		test = extent.startTest("OfferRecived to OfferAccepted");
		try {
			// click(Pages.RequirmentLifeCycle().selectLifeCycle("Offer
			// Received"));
			Thread.sleep(3000);
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Match window");
			Thread.sleep(3000);
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.interviewCall(candidateName));
			test.log(LogStatus.INFO, "Select shortlisted Call");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			switchWindow("Conversation");
			test.log(LogStatus.INFO, "Switch to conversation window");
			Pages.Conversation();
			Conversation.phoneNumber().sendKeys("7698950001");
			test.log(LogStatus.INFO, "Enterd phone number");
			Pages.Conversation();
			JavaScriptHelper.clickElementByJS(Conversation.conversion("Confirmed for this requirement"));
			test.log(LogStatus.INFO, "Select Conversion");
			Pages.Conversation();
			sendKeys(Conversation.summary(), "summary");
			test.log(LogStatus.INFO, "Entered Summary");
			Pages.Conversation();
			sendKeys(Conversation.timeToJoin(), "yes...........");
			test.log(LogStatus.INFO, "Entered time to join");
			Pages.Conversation();
			Conversation.isConfirmationReceived("yes");
			test.log(LogStatus.INFO, "click on confirmation revceid");
			Pages.Conversation();
			Conversation.save();
			test.log(LogStatus.INFO, "Select Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds...");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			Thread.sleep(3000);
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.offerReceivedView(candidateName));
			test.log(LogStatus.INFO, "Click on Edit view");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds");
			switchWindow("OfferReceived");
			test.log(LogStatus.INFO, "switch to offer received");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds.");
			Pages.OfferReceived();
			JavaScriptHelper.clickElementByJS(OfferReceived.selectOfferStatus("Offer Received"));
			test.log(LogStatus.INFO, "select offer status");
			Pages.OfferReceived();
			Select(OfferReceived.selectPayRateType(), "Monthly");
			test.log(LogStatus.INFO, "select payrate type");
			Pages.OfferReceived();
			OfferReceived.startDate("03/14/2018");
			test.log(LogStatus.INFO, "Entered start date");
			Pages.OfferReceived();
			JavaScriptHelper.clickElementByJS(OfferReceived.save());
			test.log(LogStatus.INFO, "Select save");
			Thread.sleep(3000);
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matche window");
			Pages.RequirmentLifeCycle();
			JavaScriptHelper.clickElementByJS(RequirmentLifeCycle.interviewDetails(candidateName));
			test.log(LogStatus.INFO, "Click on interview Details");
			switchWindow("Submission Details");
			test.log(LogStatus.INFO, "Swithch to submission window");
			Pages.SubmissionDetailsPage();
			Select(SubmissionDetailsPage.selectRCTLAM(), "Hetal");
			test.log(LogStatus.INFO, "Select TL");
			Pages.SubmissionDetailsPage();
			JavaScriptHelper.clickElementByJS(SubmissionDetailsPage.selectAccept());
			test.log(LogStatus.INFO, "Click on Accept");
			Pages.SubmissionDetailsPage();
			Select(SubmissionDetailsPage.selectQualityOfResume(), "Excellent Resume, Good work done.");
			test.log(LogStatus.INFO, "Select quality of resume");
			Pages.SubmissionDetailsPage();
			JavaScriptHelper.clickElementByJS(SubmissionDetailsPage.save());
			test.log(LogStatus.INFO, "Select Save");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds.");
			switchWindow("Candidate Matches");
			Pages.RequirmentLifeCycle();
			Select(RequirmentLifeCycle.interviewAction(candidateName), "Offer Accepted");
			test.log(LogStatus.INFO, "Click on Action");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds.");
			switchWindow("OfferAccepted");
			test.log(LogStatus.INFO, "Switch to OfferAccepted window");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds.");
			Pages.OfferAccepted();
			JavaScriptHelper.clickElementByJS(OfferAccepted.selectOfferStatus("Hired"));
			test.log(LogStatus.INFO, "Selected Hired.");
			Pages.OfferAccepted();
			JavaScriptHelper.clickElementByJS(OfferAccepted.selectContractType("Employment-Agreement"));
			test.log(LogStatus.INFO, "Selected Employment-Agreement");
			Pages.OfferAccepted();
			sendKeys(OfferAccepted.comments(), "testing");
			test.log(LogStatus.INFO, "Entered comments");
			Pages.OfferAccepted();
			JavaScriptHelper.clickElementByJS(OfferAccepted.save());
			test.log(LogStatus.INFO, "Click on Save button");
			Pages.OfferAccepted();
			JavaScriptHelper.clickElementByJS(OfferAccepted.back());
			test.log(LogStatus.INFO, "Click on Back button");
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Waiting for 3seconds.");
			switchWindow("Candidate Matches");
			test.log(LogStatus.INFO, "Switch to Candidate Matches window");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
