package com.test.automation.UIAutomation.uiActions.Requirements;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.UIAutomation.LandingPage.Pages;
import com.test.automation.UIAutomation.helper.CalenderSelect;
import com.test.automation.UIAutomation.helper.JavaScriptHelper;
import com.test.automation.UIAutomation.testBase.TestBase;

import freemarker.cache.URLTemplateLoader;

public class NewRequirement extends TestBase {
	public static Logger log = Logger.getLogger(NewRequirement.class.getName());

	private static List<String> urlTitle = null;
	public static String reqDetailsHandle = Pages.homapage().requirmentDetailsPage;
	public static WebElement subheader;
	// public static = null;

	/*
	 * private static List<WebElement> selectHeaderTab() throws Exception {
	 * ElementLoad(); return
	 * com.test.automation.UIAutomation.config.ElementLoad.getWebElements
	 * ("SubHeaderTab", NewRequirementsDetailsPropertyFile); }
	 */

	public static void selectHeader(String subHeader) {

		try {
			List<WebElement> selectHeaderTab = ElementLoad().getWebElements("SubHeaderTab",
					NewRequirementsDetailsPropertyFile);
			log.info("subHeader:" + subHeader);
			for (int i = 0; i < selectHeaderTab.size(); i++) {
				log.info("tabTitle:" + selectHeaderTab.get(i).getText());
				if (subHeader.equals(selectHeaderTab.get(i).getText())) {
					log.info("Web url: " + driver.getCurrentUrl());
					// log.info("SelectTab: " + getTitleTab());
					javascripthelper.scrollToElemet(selectHeaderTab.get(i));
					selectHeaderTab.get(i).click();
					break;
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

	public static void fillAllRequirementInformation(String RequirementJobCode, String ClientJobCode, String JobTitle,
			String JobType, String VisaType, String flsa,String ReqStatus, String Duration, String ASAP, String OpenDate,
			String CloseDate, String DueDate, String Position, String ActualSlots, String Addressline1, String Pincode,
			String ShiftTimeFrom, String ShiftTimeTo, String WeeklyHours, String InterviewStartDate,
			String InterviewEndDate, String RecruiterRequirementManager, String RecruiterTeamLeader,
			String RecruiterAccountManager, String ConfirmationTeamLeader, String ClientInformationCategory,
			String ClientInformationClient, String BillRateFromclient, String ClientInformationPayRate,
			String ClientInformationRateType, String VMSManager, String JobDescription, String skill1, String skill2,
			String skill3, String skill4, String subject) {

		try {
			fillRequirementInformation(RequirementJobCode, ClientJobCode, JobTitle, JobType,flsa, VisaType, ReqStatus,
					Duration, Boolean.parseBoolean(ASAP), OpenDate, CloseDate, DueDate, Position, ActualSlots);
			fillLocationShiftTimingInformation(Addressline1, Pincode, ShiftTimeFrom, ShiftTimeTo, WeeklyHours,
					InterviewStartDate, InterviewEndDate);
			fillRecruiterTeam(RecruiterRequirementManager, RecruiterTeamLeader, RecruiterAccountManager);
			fillConfirmation(Boolean.parseBoolean(ConfirmationTeamLeader));
			fillClientInformation(ClientInformationCategory, ClientInformationClient, "", BillRateFromclient,
					ClientInformationPayRate, ClientInformationRateType, "", VMSManager);
			fillJobDescription(JobDescription);
			fillSkillInformation(skill1, skill2, skill3, skill4, subject);
			/// click(driver.findElement(By.xpath(".//*[@id='btnSave']")));
			// click(ElementLoad().getWebElement("RequirementSave",
			/// NewRequirementsDetailsPropertyFile));

		} catch (Exception e) {
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void fillRequirementInformation(String RequirementJobCode, String jobCode, String jobTitle,
			String JobType, String RequirementVisaType,String ReqFlsa, String ReqStatus, String Duration, boolean asap,
			String OpenDate, String CloseDate, String DueDate, String Position, String Slots) {
		try {
			System.out.println("RequirementJobCode:" + RequirementJobCode);
			System.out.println("jobCode:" + jobCode);
			javascripthelper.javaScriptSendText(
					ElementLoad().getWebElement("RequirementJobCode", NewRequirementsDetailsPropertyFile),
					RequirementJobCode);
			log.info("Requirement Code entered in textbox");
			javascripthelper.javaScriptSendText(ElementLoad().getWebElement("ClientJobCode", NewRequirementsDetailsPropertyFile), jobCode);
			log.info("job code entered in textbox");
			javascripthelper.javaScriptSendText(ElementLoad().getWebElement("JobTitle",
					NewRequirementsDetailsPropertyFile), jobTitle);
			log.info("Entered JobTitle in textbox");
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("JobType",
					NewRequirementsDetailsPropertyFile), JobType);
			log.info("Select JobType");
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RequirementVisaType",
					NewRequirementsDetailsPropertyFile), ReqFlsa);
			log.info("Select RequirementVisaType");
			WebElement flsa=driver.findElement(By.id("drpFLSAClassification"));
			Select(flsa,"Exempt");
			log.info("Select FLSA Classification Type");
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("ReqStatus",
					NewRequirementsDetailsPropertyFile), ReqStatus);
			log.info("Select ReqStatus");

			clear(ElementLoad().getWebElement("Duration", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			javascripthelper.javaScriptSendText(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Duration",
					NewRequirementsDetailsPropertyFile), Duration);
			log.info("Duration entered in textbox");

			selectASAP(asap, OpenDate, CloseDate);

			ElementLoad();
			javascripthelper.javaScriptSendText(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("DueDate",
					NewRequirementsDetailsPropertyFile), DueDate);
			log.info("DueDate entered in textbox");
			ElementLoad();
			javascripthelper.javaScriptSendText(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Position",
					NewRequirementsDetailsPropertyFile), Position);
			log.info("Position entered in textbox");
			// click(ElementLoad().getWebElement("Addbtn",
			// NewRequirementsDetailsPropertyFile));
			/*
			 * Alert alert = driver.switchTo().alert(); alert.accept();
			 * 
			 * clear(ElementLoad().getWebElement("JobTitle",
			 * NewRequirementsDetailsPropertyFile)); ElementLoad();
			 * 
			 * click(driver.findElement(By.xpath(
			 * "//div[@id="tabReqDetails"]/div/div/div/div/div/a[contains(text(),'Add')]"
			 * ))); addJobTilte(jobTitle);
			 * 
			 * sendKeys(com.test.automation.UIAutomation.config.ElementLoad.
			 * getWebElement("JobTitle", NewRequirementsDetailsPropertyFile),
			 * jobTitle); log.info("Entered JobTitle in textbox");
			 * ElementLoad();
			 * Select(com.test.automation.UIAutomation.config.ElementLoad.
			 * getWebElement("JobType", NewRequirementsDetailsPropertyFile),
			 * JobType); log.info("Select JobType"); ElementLoad();
			 * Select(com.test.automation.UIAutomation.config.ElementLoad.
			 * getWebElement("RequirementVisaType",
			 * NewRequirementsDetailsPropertyFile), RequirementVisaType);
			 * log.info("Select RequirementVisaType"); ElementLoad();
			 * Select(com.test.automation.UIAutomation.config.ElementLoad.
			 * getWebElement("RequirementNoticePeriod",
			 * NewRequirementsDetailsPropertyFile), RequirementNoticePeriod);
			 * log.info("Select RequirementNoticePeriod"); ElementLoad();
			 * Select(com.test.automation.UIAutomation.config.ElementLoad.
			 * getWebElement("LOB", NewRequirementsDetailsPropertyFile), LOB);
			 * log.info("Select LOB"); ElementLoad();
			 * Select(com.test.automation.UIAutomation.config.ElementLoad.
			 * getWebElement("SkillType", NewRequirementsDetailsPropertyFile),
			 * SkillType); log.info("Select SkillType"); ElementLoad();
			 * Select(com.test.automation.UIAutomation.config.ElementLoad.
			 * getWebElement("ReqStatus", NewRequirementsDetailsPropertyFile),
			 * ReqStatus); log.info("Select ReqStatus");
			 * 
			 * 
			 * clear(ElementLoad().getWebElement("Duration",
			 * NewRequirementsDetailsPropertyFile)); ElementLoad();
			 * sendKeys(com.test.automation.UIAutomation.config.ElementLoad.
			 * getWebElement("Duration", NewRequirementsDetailsPropertyFile),
			 * Duration); log.info("Duration entered in textbox");
			 * 
			 * selectASAP(asap,OpenDate, CloseDate);
			 * 
			 * ElementLoad();
			 * sendKeys(com.test.automation.UIAutomation.config.ElementLoad.
			 * getWebElement("DueDate", NewRequirementsDetailsPropertyFile),
			 * DueDate); log.info("DueDate entered in textbox"); ElementLoad();
			 * sendKeys(com.test.automation.UIAutomation.config.ElementLoad.
			 * getWebElement("Position", NewRequirementsDetailsPropertyFile),
			 * Position); log.info("Position entered in textbox");
			 */
		} catch (Exception e) {
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addJobTilte(String jbtitle) {
		try {
			Set<String> handle = driver.getWindowHandles();
			for (String hand : handle) {
				driver.switchTo().window(hand);
				log.info("handles :" + driver.getTitle());
				log.info("handles :" + hand);
				/*
				 * System.out.println("handles :"+driver.getTitle());
				 * System.out.println("handles :"+hand);
				 */
			}
			driver.findElement(By.xpath(".//*[@id='JobTitleText']")).sendKeys(jbtitle);
			driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/form/div[2]/div/a")).click();// change
																										// this
																										// button
																										// xpath
																										// to
																										// Save
																										// button
			driver.findElement(By.xpath(".//*[@id='SearchText']")).sendKeys(jbtitle);
			driver.findElement(By.xpath(".//*[@id='btnSearch']")).click();
			log.info("currnet:" + driver.getTitle());
			// System.out.println("currnet:"+driver.getTitle());
			// driver.close();
			// String handle2 = driver.getWindowHandle();
			// System.out.println("handle2:"+handle2);
			Set<String> handle2 = driver.getWindowHandles();
			for (String hand : handle2) {
				driver.switchTo().window(hand);
				log.info("handles :" + driver.getTitle());
				System.out.println("handles :" + driver.getTitle());
				if (driver.getTitle().equalsIgnoreCase("Requirement Details")) {
					log.info("handles :" + hand);
					System.out.println("handles :" + hand);
					driver.findElement(By.xpath(".//*[@id='JobTitleText']")).sendKeys(jbtitle);
					break;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void selectASAP(boolean asap, String openDate, String closeDate) {
		boolean bValue;
		try {
			ElementLoad();
			bValue = driver.findElement(By.xpath(".//*[@id='IsRequirementOpenDateASAP']")).isSelected();
			log.info("bValue: " + bValue);
			log.info("asap: " + asap);
			if (asap != bValue) {

				driver.findElement(By.xpath(".//*[@id='IsRequirementOpenDateASAP']")).click();
				log.info("Checked ASAP checkbox:" + closeDate);
				Thread.sleep(1000);

			} else {
				Thread.sleep(1000);
				ElementLoad();
				sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("OpenDate",
						NewRequirementsDetailsPropertyFile), openDate);
				log.info("OpenDate entered in openDate" + openDate);
				ElementLoad();
				sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("CloseDate",
						NewRequirementsDetailsPropertyFile), closeDate);
				log.info("CloseDate entered in closeDate" + closeDate);
				
				
			} // click(ElementLoad().getWebElement("ASAP",
				// RequirementDetailsPropertyFile));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	private static void fillLocationShiftTimingInformation(String Addressline1, String Pincode, String ShiftTimeFrom,
			String ShiftTimeTo, String WeeklyHours, String InterviewInformationStartDate,
			String InterviewInformationEndDate) {
		try {

			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Addressline1",
					NewRequirementsDetailsPropertyFile), Addressline1);
			log.info("Entered Addressline1 in textbox");

			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Pincode",
					NewRequirementsDetailsPropertyFile), Pincode);
			log.info("Entered Pincode in textbox");

			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("ShiftTimeFrom",
					NewRequirementsDetailsPropertyFile), ShiftTimeFrom);
			log.info("Entered ShiftTimeFrom in textbox");
			click(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]")));
			click(driver.findElement(By.xpath(".//*[@id='ShiftStartTime']")));
			click(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]")));

			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("ShiftTimeTo",
					NewRequirementsDetailsPropertyFile), ShiftTimeTo);
			log.info("Entered ShiftTimeTo in textbox");
			click(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]")));
			click(driver.findElement(By.xpath(".//*[@id='ShiftEndTime']")));
			click(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]")));

			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("WeeklyHours",
					NewRequirementsDetailsPropertyFile), WeeklyHours);
			log.info("Entered WeeklyHours in textbox");

			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("InterviewInformationStartDate",
					NewRequirementsDetailsPropertyFile), InterviewInformationStartDate);
			log.info("Entered InterviewInformationStartDate in textbox");

			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("InterviewInformationEndDate",
					NewRequirementsDetailsPropertyFile), InterviewInformationEndDate);
			ElementLoad();
			com.test.automation.UIAutomation.config.ElementLoad
					.getWebElement("InterviewInformationEndDate", NewRequirementsDetailsPropertyFile)
					.sendKeys(Keys.ENTER);
			log.info("Entered InterviewInformationEndDate in textbox");
		} catch (Exception e) {
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void fillRecruiterTeam(String RequirementManager, String RecruiterTeamLeader,
			String RecruiterAccountManager) {
		try {
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RequirementManager",
					NewRequirementsDetailsPropertyFile), RequirementManager);
			log.info("Entered RecruiterJobType in textbox");
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RecruiterTeamLeader",
					NewRequirementsDetailsPropertyFile), RecruiterTeamLeader);
			log.info("Entered RecruiterVisaType in textbox");
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RecruiterAccountManager",
					NewRequirementsDetailsPropertyFile), RecruiterAccountManager);
			log.info("Entered RecruiterVisaType in textbox");

		} catch (Exception e) {
			log.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void fillConfirmation(boolean TeamLeaderConfirmation) {

		try {
			if (TeamLeaderConfirmation == true) {

				click(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("TeamLeaderConfirmation",
						NewRequirementsDetailsPropertyFile));
				log.info("TeamLeader = true");

			} else if (TeamLeaderConfirmation == false) {
				ElementLoad();
				click(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("TeamLeaderConfirmation",
						NewRequirementsDetailsPropertyFile));
				log.info("TeamLeader = false");

			}

			else {

				log.info("Entered ResourceCoordinator and TeamLeader =false");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}

	private static void fillClientInformation(String Category, String Client, String SubClient, String ClientBillRate,
			String PayRate, String RateType, String HiringManager, String VMSManager) {
		try {

			javascripthelper
					.scrollToElemet(ElementLoad().getWebElement("Clientdropdown", NewRequirementsDetailsPropertyFile));
			click(ElementLoad().getWebElement("Clientdropdown", NewRequirementsDetailsPropertyFile));
			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Client",
					NewRequirementsDetailsPropertyFile), Client);

			ElementLoad();
			com.test.automation.UIAutomation.config.ElementLoad
					.getWebElement("Client", NewRequirementsDetailsPropertyFile).sendKeys(Keys.DOWN);
			ElementLoad();
			com.test.automation.UIAutomation.config.ElementLoad
					.getWebElement("Client", NewRequirementsDetailsPropertyFile).sendKeys(Keys.ENTER);
			log.info("select Client in textbox:");
			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("Category",
					NewRequirementsDetailsPropertyFile), Category);
			log.info("select Category status:" + Category);

			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("ClientBillRate",
					NewRequirementsDetailsPropertyFile), ClientBillRate);
			log.info("Entered ClientBillRate in textbox:" + ClientBillRate);

			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("PayRate",
					NewRequirementsDetailsPropertyFile), PayRate);
			log.info("Entered CandidatePayRate in textbox:" + PayRate);

			ElementLoad();
			Select(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("RateType",
					NewRequirementsDetailsPropertyFile), RateType);
			log.info("Entered RateType in textbox:" + RateType);

			Thread.sleep(1000);
			click(ElementLoad().getWebElement("VMSManager", NewRequirementsDetailsPropertyFile));
			log.info("VMSManager click on it");

			driver.findElement(By.xpath(".//*[@id='drpVMSmanager_chosen']/div/div/input"))
					.sendKeys(VMSManager + Keys.TAB);

		} catch (Exception e) {
			log.info(e.getMessage());

			e.printStackTrace();
		}
	}

	private static void fillSkillInformation(String MandatorySkill1, String MandatorySkill2, String MandatorySkill3,
			String MandatorySkill4, String SubjectLine) {
		try {
			// clear(ElementLoad().getWebElement("MandatorySkill1",
			// NewRequirementsDetailsPropertyFile));

			ElementLoad();
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("MandatorySkill1",
					NewRequirementsDetailsPropertyFile), MandatorySkill1);
			log.info("Entered MandatorySkill1 in textbox");
			ElementLoad();
			// clear(ElementLoad().getWebElement("MandatorySkill2",
			// NewRequirementsDetailsPropertyFile));
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("MandatorySkill2",
					NewRequirementsDetailsPropertyFile), MandatorySkill2);
			log.info("Entered MandatorySkill2 in textbox");
			ElementLoad();
			// clear(ElementLoad().getWebElement("MandatorySkill3",
			// NewRequirementsDetailsPropertyFile));
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("MandatorySkill3",
					NewRequirementsDetailsPropertyFile), MandatorySkill3);
			log.info("Entered MandatorySkill3 in textbox");
			ElementLoad();
			// clear(ElementLoad().getWebElement("MandatorySkill4",
			// NewRequirementsDetailsPropertyFile));
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("MandatorySkill4",
					NewRequirementsDetailsPropertyFile), MandatorySkill4);
			log.info("Entered MandatorySkill4 in textbox");
			ElementLoad();
			// clear(ElementLoad().getWebElement("SubjectLine",
			// NewRequirementsDetailsPropertyFile));
			sendKeys(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("SubjectLine",
					NewRequirementsDetailsPropertyFile), SubjectLine);
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
			driver.switchTo().frame(com.test.automation.UIAutomation.config.ElementLoad.getWebElement("JobDescription",
					NewRequirementsDetailsPropertyFile));
			ElementLoad();
			WebElement paragraph = com.test.automation.UIAutomation.config.ElementLoad.getWebElement("paragraph",
					NewRequirementsDetailsPropertyFile);

			// clear(paragraph);

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

	public static void fillOtheLocation() {
		log.info("fillOtheLocation");
	}

}
