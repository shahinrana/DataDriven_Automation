package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.LandingPage.Pages;
import com.test.automation.UIAutomation.testBase.TestBase;

import freemarker.cache.URLTemplateLoader;

public class RequirementDetailsPage extends TestBase {
	
	
	@DataProvider(name = "RegisterDetailsTestData")
	public String[][] getTestData2() {
		//String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
		String[][] testRecords = getData(Config.getProperty("exelsheetname"), Config.getProperty("RegisterDetailsTestData"));
		//return getData("TestData.xlsx","RegisterDetailsTestData");
		return testRecords;
	}	
	
	/*static String ClientJobCode, JobTitle,JobType, VisaType, NoticePeriod, LOB, SkillType, ReqStatus, Duration, ASAP, OpenDate, CloseDate, DueDate, Position, ActualSlots,
	Addressline1, State, City, Pincode, ShiftTimeFrom,ShiftTimeTo, WeeklyHours, InterviewStartDate, InterviewEndDate, RecruiterRequirementManager, RecruiterTeamLeader, ConfirmationRequirementManager,
	 ConfirmationTeamLeader, ClientInformationCategory, ClientInformationClient, BillRateFromclient, ClientInformationPayRate,
	 ClientInformationRateType, VMSManager, JobDescription, skill1, skill2, skill3, skill4, subject,runMode;
	
	@Test(dataProvider="RegisterDetailsTestData")
	public RequirementDetailsPage(String ClientJobCode,String JobTitle,String JobType,String VisaType,String NoticePeriod,String LOB,String SkillType,String ReqStatus,String Duration,
			String ASAP,String OpenDate,String CloseDate,String DueDate,String Position,String ActualSlots,String Addressline1,String State,String City,String Pincode,String ShiftTimeFrom ,String ShiftTimeTo,
			String WeeklyHours,String InterviewStartDate,String InterviewEndDate,String RecruiterRequirementManager,String RecruiterTeamLeader,String ConfirmationRequirementManager,
			String ConfirmationTeamLeader,String ClientInformationCategory,String ClientInformationClient,String BillRateFromclient,String ClientInformationPayRate,
			String ClientInformationRateType,String VMSManager,String JobDescription,String skill1,String skill2,String skill3,String skill4,String subject,String runMode)
	{
		this.ClientJobCode=ClientJobCode;this.JobTitle=JobTitle;this.JobType=JobType;this.VisaType=VisaType;this.NoticePeriod=NoticePeriod;this.LOB=LOB;this.SkillType=SkillType;
		this.ReqStatus=ReqStatus;this.Duration=Duration;this.ASAP=ASAP;this.OpenDate=OpenDate;this.CloseDate=CloseDate;this.DueDate=DueDate;this.Position=Position;
		this.ActualSlots=ActualSlots;this.Addressline1=Addressline1;this.State=State;this.City=City;this.Pincode=Pincode;
		this.ShiftTimeFrom=ShiftTimeFrom;this.ShiftTimeTo=ShiftTimeTo;this.WeeklyHours=WeeklyHours;this.InterviewStartDate=InterviewStartDate;this.InterviewEndDate=InterviewEndDate;
		this.RecruiterRequirementManager=RecruiterRequirementManager;this.RecruiterTeamLeader=RecruiterTeamLeader;this.ConfirmationRequirementManager=ConfirmationRequirementManager;
		this.ConfirmationTeamLeader=ConfirmationTeamLeader;this.ClientInformationCategory=ClientInformationCategory;this.ClientInformationClient=ClientInformationClient;
		this.BillRateFromclient=BillRateFromclient;this.ClientInformationPayRate=ClientInformationPayRate;this.ClientInformationRateType=ClientInformationRateType;this.VMSManager=VMSManager;
		this.JobDescription=JobDescription;this.skill1=skill1;this.skill2=skill2;this.skill3=skill3;this.skill4=skill4;this.subject=subject;this.runMode=runMode;
		
	}*/
	
	public static Logger log = Logger.getLogger(RequirementDetailsPage.class.getName());	
	private static List<String> urlTitle = null;
	public static String reqDetailsHandle = Pages.homapage().requirmentDetailsPage;
	public static WebElement subheader;

	private static List<WebElement> selectHeaderTab() throws Exception {
		return ElementLoad().getWebElements("SubHeaderTab", RequirementDetailsPropertyFile);
	}

	public static void selectHeader(String subHeader) {

		test = extent.startTest("selectHeader");
		try {
			// String getTitle=getTitleTab();
			for (int i = 0; i < selectHeaderTab().size(); i++) {

				log.info("tabTitle:" + selectHeaderTab().get(i).getText());
				if (subHeader.equals(selectHeaderTab().get(i).getText())) {
					test.log(LogStatus.INFO, "subHeader:" + subHeader);
					log.info("Web url: " + driver.getCurrentUrl());
					// log.info("SelectTab: " + getTitleTab());
					selectHeaderTab().get(i).click();
					fillAllRequirementInformation();
					log.info("fillAllRequirementInformation() ");
				}
			}
			// String s=SelectTab();
		} catch (Exception e) {
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// urlTitle.add(driver.getCurrentUrl());
		// log.info("SelectTab: "+SelectTab());

	}
	
	public static void fillAllRequirementInformation() {
		test = extent.startTest("fillAllRequirementInformation");
		try {
			System.out.println("fillAllRequirementInformation");
			/*fillRequirementInformation(ClientJobCode,JobTitle,JobType,VisaType, NoticePeriod, LOB, SkillType, ReqStatus, Duration,
					 Boolean.parseBoolean(ASAP), OpenDate, CloseDate, DueDate,Position,ActualSlots);*/
			
			fillRequirementInformation("RIPL-India_QA1", "QA1", "Full Time", "Authorized to work in India", "Immediate", "BANA", "Moderate", "Open",
					"10", false, "1/3/2017", "1/3/2017", "1/3/2017","1","1");
			test.log(LogStatus.INFO, "RIPL-India_QA1, QA1, Full Time, Authorized to work in India, Immediate, BANA, Moderate, Open,	10, false, 1/3/2017, 1/3/2017, 1/3/2017,1,1");
			fillLocationShiftTimingInformation("Rangam1", "Andhra Pradesh", "Kakinada","390007","08:00 PM", "09:00 AM", "15", "06/03/2017", "06/05/2017");
			test.log(LogStatus.INFO, "Rangam1, Andhra Pradesh, Kakinada,390007,08:00 PM, 09:00 AM, 15, 06/03/2017, 06/05/2017");
			fillRecruiterTeam("Kedar B.", "Yogesh Solanki");
			test.log(LogStatus.INFO, "fill fillRecruiterTeam method passed.");
			fillConfirmation(true, false);
			test.log(LogStatus.INFO, "false, false");
			fillClientInformation("Admin", "Rangam Infotech Pvt Ltd.","", "10.54", "10.54", "Monthly", "", "VMSManager");
			test.log(LogStatus.INFO, "fill fillClientInformation method passed.");
			fillJobDescription("Software Tester,QA Engineer, QA Automation, Testing Performance");
			test.log(LogStatus.INFO, "Software Tester,QA Engineer, QA Automation, Testing Performance");
			fillSkillInformation("Software Tester", "QA Engineer", "QA", "Automation Testing", "Performance Testing");
			test.log(LogStatus.INFO, "Software Tester,QA Engineer, QA Automation, Testing Performance");
			
		} catch (Exception e) {
			test.log(LogStatus.INFO, e.getMessage());
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void fillRequirementInformation(String jobCode, String jobTitle,String JobType,String RequirementVisaType,
			String RequirementNoticePeriod,String LOB,String SkillType,String ReqStatus,String Duration,
			boolean asap,String OpenDate,String  CloseDate,
			String DueDate,String Position,String Slots) {
		try {
			clear(ElementLoad().getWebElement("ClientJobCode", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("ClientJobCode", NewRequirementsDetailsPropertyFile), jobCode);
			log.info("job code entered in textbox");
			/*Alert alert = driver.switchTo().alert();
			alert.accept();*/
			
			clear(ElementLoad().getWebElement("JobTitle", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			
			click(driver.findElement(By.xpath("//*[@id='tabReqDetails']/div/div[1]/div[2]/div[3]/div/a")));
			addJobTilte(jobTitle);
			
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("JobTitle", NewRequirementsDetailsPropertyFile), jobTitle);
			log.info("Entered JobTitle in textbox");
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("JobType", NewRequirementsDetailsPropertyFile), JobType);
			log.info("Select JobType");
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RequirementVisaType", NewRequirementsDetailsPropertyFile), RequirementVisaType);
			log.info("Select RequirementVisaType");
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RequirementNoticePeriod", NewRequirementsDetailsPropertyFile), RequirementNoticePeriod);
			log.info("Select RequirementNoticePeriod");
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("LOB", NewRequirementsDetailsPropertyFile), LOB);
			log.info("Select LOB");
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("SkillType", NewRequirementsDetailsPropertyFile), SkillType);
			log.info("Select SkillType");
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("ReqStatus", NewRequirementsDetailsPropertyFile), ReqStatus);
			log.info("Select ReqStatus");
			
			
			clear(ElementLoad().getWebElement("Duration", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Duration", NewRequirementsDetailsPropertyFile), Duration);
			log.info("Duration entered in textbox");
			
			selectASAP1(asap,OpenDate, CloseDate);
	
			clear(ElementLoad().getWebElement("DueDate", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("DueDate", NewRequirementsDetailsPropertyFile), DueDate);
			log.info("DueDate entered in textbox");
			clear(ElementLoad().getWebElement("Position", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Position", NewRequirementsDetailsPropertyFile), Position);
			log.info("Position entered in textbox");
			
			}
		 catch (Exception e) {
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void addJobTilte(String jbtitle)
	{
		try {
			 Set<String> handle = driver.getWindowHandles();
			 Actions a=new Actions(driver);
			for(String hand: handle)
			{
				driver.switchTo().window(hand);
				log.info("handles :"+driver.getTitle());
				log.info("handles :"+hand);
				/*System.out.println("handles :"+driver.getTitle());
				System.out.println("handles :"+hand);*/
			}
			driver.findElement(By.xpath(".//*[@id='JobTitleText']")).sendKeys(jbtitle);
			driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/form/div[2]/div/a")).click();//change this button xpath to Save button
			driver.findElement(By.xpath(".//*[@id='SearchText']")).sendKeys(jbtitle);
			driver.findElement(By.xpath(".//*[@id='btnSearch']")).click();
			log.info("currnet:"+driver.getTitle());
			//System.out.println("currnet:"+driver.getTitle());
			//driver.close();
			//String handle2 = driver.getWindowHandle();
			//System.out.println("handle2:"+handle2);
			Set<String> handle2 = driver.getWindowHandles();
			for(String hand: handle2)
			{			
				driver.switchTo().window(hand);
				log.info("handles :"+driver.getTitle());
				System.out.println("handles :"+driver.getTitle());
				if(driver.getTitle().equalsIgnoreCase("Requirement Details"))
				{
					log.info("handles :"+hand);
					System.out.println("handles :"+hand);
					driver.findElement(By.xpath(".//*[@id='JobTitleText']")).sendKeys(jbtitle);
					break;
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void selectASAP1(boolean asap,String openDate, String closeDate)
	{
		boolean bValue;
		try {
			ElementLoad();
			bValue =driver.findElement(By.xpath(".//*[@id='IsRequirementOpenDateASAP']")).isSelected();
			log.info("bValue: "+bValue);
			log.info("asap: "+asap);		
			if (asap!=bValue)
			{
				
				driver.findElement(By.xpath(".//*[@id='IsRequirementOpenDateASAP']")).click();	
				log.info("Checked ASAP checkbox:"+closeDate);
				Thread.sleep(1000);
						    
			}			
			else 
			{				
				Thread.sleep(1000);
				clear(ElementLoad().getWebElement("OpenDate", NewRequirementsDetailsPropertyFile));
				ElementLoad();
				sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("OpenDate", NewRequirementsDetailsPropertyFile), openDate);
				log.info("OpenDate entered in openDate"+openDate);
				clear(ElementLoad().getWebElement("CloseDate", NewRequirementsDetailsPropertyFile));
				ElementLoad();
				sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("CloseDate", NewRequirementsDetailsPropertyFile), closeDate);
				log.info("CloseDate entered in closeDate"+closeDate);	
				
			}		//click(ElementLoad().getWebElement("ASAP", RequirementDetailsPropertyFile));
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		}
		
	}
	private static void fillLocationShiftTimingInformation(String Addressline1,String State,String City, String Pincode, String ShiftTimeFrom,
			String ShiftTimeTo, String WeeklyHours, String InterviewInformationStartDate, String InterviewInformationEndDate) {
		try {
			
			clear(ElementLoad().getWebElement("Addressline1", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Addressline1", NewRequirementsDetailsPropertyFile), Addressline1);
			log.info("Entered Addressline1 in textbox");
			
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("State", NewRequirementsDetailsPropertyFile), State);
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("City", NewRequirementsDetailsPropertyFile), City);
		
			clear(ElementLoad().getWebElement("Pincode", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Pincode", NewRequirementsDetailsPropertyFile), Pincode);
			log.info("Entered Pincode in textbox");
			
			clear(ElementLoad().getWebElement("ShiftTimeFrom", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("ShiftTimeFrom", NewRequirementsDetailsPropertyFile), ShiftTimeFrom);
			log.info("Entered ShiftTimeFrom in textbox");
			click(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]")));
			click(driver.findElement(By.xpath(".//*[@id='ShiftStartTime']")));
			click(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]")));
			
			
			clear(ElementLoad().getWebElement("ShiftTimeTo", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("ShiftTimeTo", NewRequirementsDetailsPropertyFile), ShiftTimeTo);
			log.info("Entered ShiftTimeTo in textbox");
			click(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]")));
			click(driver.findElement(By.xpath(".//*[@id='ShiftEndTime']")));
			click(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]")));
			
			clear(ElementLoad().getWebElement("WeeklyHours", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("WeeklyHours", NewRequirementsDetailsPropertyFile), WeeklyHours);
			log.info("Entered WeeklyHours in textbox");
		
			clear(ElementLoad().getWebElement("InterviewInformationStartDate", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("InterviewInformationStartDate", NewRequirementsDetailsPropertyFile),
					InterviewInformationStartDate);
			log.info("Entered InterviewInformationStartDate in textbox");
			
			clear(ElementLoad().getWebElement("InterviewInformationEndDate", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("InterviewInformationEndDate", NewRequirementsDetailsPropertyFile),
					InterviewInformationEndDate);
			ElementLoad();
			com.test.automation.UIAutomation.config.ElementLoad.getWebElement("InterviewInformationEndDate", NewRequirementsDetailsPropertyFile)
					.sendKeys(Keys.ENTER);
			log.info("Entered InterviewInformationEndDate in textbox");
		} catch (Exception e) {
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void fillRecruiterTeam(String RequirementManager, String RecruiterTeamLeader) {
		try {
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RequirementManager", NewRequirementsDetailsPropertyFile), RequirementManager);
			log.info("Entered RecruiterJobType in textbox");
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RecruiterTeamLeader", NewRequirementsDetailsPropertyFile), RecruiterTeamLeader);
			log.info("Entered RecruiterVisaType in textbox");
			
		} catch (Exception e) {
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	private static void fillConfirmation(boolean RequirementManagerConfirmation, boolean TeamLeaderConfirmation) {

		try {
			if (RequirementManagerConfirmation == true && TeamLeaderConfirmation == true) {
				
				ElementLoad();
				click(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RequirementManagerConfirmation", NewRequirementsDetailsPropertyFile));
				log.info("Entered ResourceCoordinator in textbox and ResourceCoordinator == true && TeamLeader == true");
				ElementLoad();
				click(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("TeamLeaderConfirmation", NewRequirementsDetailsPropertyFile));
				log.info("Entered TeamLeader in textbox");
				
			} else if ((RequirementManagerConfirmation == true && TeamLeaderConfirmation == false)) {
				ElementLoad();
				click(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RequirementManagerConfirmation", NewRequirementsDetailsPropertyFile));
				log.info("Entered TeamLeader = true && TeamLeader = false");
				
			} else if ((RequirementManagerConfirmation == false && TeamLeaderConfirmation == true)) {				
			
				ElementLoad();
				click(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("TeamLeaderConfirmation", NewRequirementsDetailsPropertyFile));
				log.info("Entered ResourceCoordinator = false && TeamLeader = true");
				
			} else {
			
				log.info("Entered ResourceCoordinator and TeamLeader =false");
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	private static void fillClientInformation(String Category,String Client,
			String SubClient ,String ClientBillRate,
			String PayRate,String RateType,String HiringManager,String VMSManager)
	{
		try {
			
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Category", NewRequirementsDetailsPropertyFile), Category);
			log.info("select Category status:"+Category);
			/*JavaExecute(driver.findElement(By.xpath(".//*[@id='drpclient_chosen']/a")));
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath(".//*[@id='drpclient_chosen']/a"))).build().perform();*/
			//
			//JavaExecute(driver.findElement(By.xpath(".//*[@id='drpclient_chosen']/a")));
			javascripthelper.clickElementByJS(driver.findElement(By.xpath(".//*[@id='drpclient_chosen']/a")));
			//click(driver.findElement(By.xpath(".//*[@id='drpclient_chosen']/a")));
			//Thread.sleep(1000);
			/*ElementLoad();
			click(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Clientdropdown", NewRequirementsDetailsPropertyFile));*/
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Client", NewRequirementsDetailsPropertyFile), Client);
			ElementLoad();
			com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Client", NewRequirementsDetailsPropertyFile).sendKeys(Keys.DOWN);
			ElementLoad();
			com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Client", NewRequirementsDetailsPropertyFile).sendKeys(Keys.ENTER);
			log.info("select Client in textbox:");
	
			
			clear(ElementLoad().getWebElement("ClientBillRate", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("ClientBillRate", NewRequirementsDetailsPropertyFile), ClientBillRate);
			log.info("Entered ClientBillRate in textbox:"+ClientBillRate);
			
			clear(ElementLoad().getWebElement("PayRate", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("PayRate", NewRequirementsDetailsPropertyFile), PayRate);
			log.info("Entered CandidatePayRate in textbox:"+PayRate);

			
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RateType", NewRequirementsDetailsPropertyFile), RateType);
			log.info("Entered RateType in textbox:"+RateType);

		
			
			ElementLoad();
			click(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("VMSManager", NewRequirementsDetailsPropertyFile));
			log.info("VMSManager click on it");

			//String alltext = driver.findElement(By.xpath(".//*[@id='drpVMSmanager_chosen']")).getText();
			// log.info("VMSManager 1id text"+alltext);
			List<WebElement> listof = driver.findElements(By.xpath(".//*[@id='drpVMSmanager_chosen']/div/ul/li"));

			for (WebElement vms : listof) {
				log.info("vms:" + vms.getText());
				// Assert.assertEquals(vms.getText(), VMSManager);
				// vms.click();
				if (vms.getText().equals(VMSManager)) {
					vms.click();
					break;
				}
			}
		
			}
		 catch (Exception e) {
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void fillSkillInformation(String MandatorySkill1, String MandatorySkill2, String MandatorySkill3,
			String MandatorySkill4,String SubjectLine) {
		try {
			//clear(ElementLoad().getWebElement("MandatorySkill1", NewRequirementsDetailsPropertyFile));
			clear(ElementLoad().getWebElement("MandatorySkill1", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("MandatorySkill1", NewRequirementsDetailsPropertyFile), MandatorySkill1);
			log.info("Entered MandatorySkill1 in textbox");
			ElementLoad();
			
			clear(ElementLoad().getWebElement("MandatorySkill2", NewRequirementsDetailsPropertyFile));
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("MandatorySkill2", NewRequirementsDetailsPropertyFile), MandatorySkill2);
			log.info("Entered MandatorySkill2 in textbox");
			ElementLoad();
			clear(ElementLoad().getWebElement("MandatorySkill3", NewRequirementsDetailsPropertyFile));
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("MandatorySkill3", NewRequirementsDetailsPropertyFile), MandatorySkill3);
			log.info("Entered MandatorySkill3 in textbox");
			ElementLoad();
			clear(ElementLoad().getWebElement("MandatorySkill4", NewRequirementsDetailsPropertyFile));
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("MandatorySkill4", NewRequirementsDetailsPropertyFile), MandatorySkill4);
			log.info("Entered MandatorySkill4 in textbox");
			ElementLoad();
			clear(ElementLoad().getWebElement("SubjectLine", NewRequirementsDetailsPropertyFile));
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("SubjectLine", NewRequirementsDetailsPropertyFile), SubjectLine);
			log.info("Entered SubjectLine in textbox");

		} catch (Exception e) {
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void fillJobDescription(String JobDescription) {
		try {
			ElementLoad();
			driver.switchTo().frame(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("JobDescription", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			WebElement paragraph=com.test.automation.UIAutomation.config.ElementLoad.getWebElement("paragraph", NewRequirementsDetailsPropertyFile);
			
			//clear(paragraph);
			
			log.info("cleared in textbox");
			Actions actions = new Actions(driver);
			actions.moveToElement(paragraph);
			actions.click(paragraph);
			actions.sendKeys(JobDescription);
			actions.build().perform();
			log.info("Entered JobDescription in textbox");
			
			driver.switchTo().defaultContent();
			log.info("Return to main frame");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}


}
