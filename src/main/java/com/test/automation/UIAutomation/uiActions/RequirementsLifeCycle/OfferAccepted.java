package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.test.automation.UIAutomation.testBase.TestBase;

public class OfferAccepted extends TestBase {
	public static Logger log = Logger.getLogger(OfferAccepted.class.getName());

	public static WebElement selectOfferStatus(String status) {
		WebElement element = null;
		if (status.equalsIgnoreCase("In progress")) {
			element = waitElement(
					"//span[contains(text(),'"+status+"')]/preceding::input[@name='HiringStatusID' and @value='1'']");
		} else if (status.equalsIgnoreCase("Hired")) {
			element = waitElement("//span[contains(text(),'"+status+"')]/preceding::input[@name='HiringStatusID' and @value='2']");
		} else if (status.equalsIgnoreCase("Not hired")) {
			element = waitElement("//span[contains(text(),'"+status+"')]/preceding::input[@name='HiringStatusID' and @value='3']");
		}
		else {
			log.info("not valid status" + status);
		}
		return element;
	}

	public static WebElement selectContractType(String status) {
		WebElement element = null;
		if (status.equalsIgnoreCase("Contract-To-Hire")) {
			element = waitElement(
					"//span[contains(text(),'"+status+"')]/preceding::input[@id='ContractTypeID'and @value='2']");
		} else if (status.equalsIgnoreCase("Corp-to-Corp")) 
		{
			element = waitElement("//span[contains(text(),'"+status+"')]/preceding::input[@id='ContractTypeID'and @value='2']");
		} else if (status.equalsIgnoreCase("Employment-Agreement")) {
			element = waitElement("//span[contains(text(),'"+status+"')]/preceding::input[@id='ContractTypeID' and @value='1']");
		}
		else if (status.equalsIgnoreCase("Other")) {
			element = waitElement("//span[contains(text(),'"+status+"')]/preceding::input[@id='ContractTypeID' and @value='5']");
		}
		else if (status.equalsIgnoreCase("W2-ExhibitA")) {
			element = waitElement("//span[contains(text(),'"+status+"')]/preceding::input[@id='ContractTypeID' and @value='4']");
		}
		else if (status.equalsIgnoreCase("W2/Corp-To-Corp")) {
			element = waitElement("//span[contains(text(),'"+status+"')]/preceding::input[@id='ContractTypeID' and @value='3']");
		}
		else {
			log.info("not valid status:" + status);
		}
		return element;
	}
	
	public static WebElement OfferedCandidatePayRate() {
		return waitElement("//input[@id='PayRateToCandidate']");
	}
	public static WebElement timely() {
		return waitElement("//select[@id='drpPayRateType']");
	}
	public static WebElement OfferedBillRate() {
		return waitElement("//input[@id='BillRateFromClient']");
	}

	public static WebElement PerDiem() {
		return waitElement("//input[@id='OfferAcceptedPerDiems']");
	}

	public static void startDate(String date) {
		click(waitElement("//input[@id='OfferAcceptedStartDate']"));
		calenderhelper.calender(date);
	}

	public static void endDate(String date) {
		click(waitElement("//input[@id='OfferAcceptedEndDate']"));
		calenderhelper.calender(date);
	}

	public static WebElement comments() {
		return waitElement("//textarea [@id='OfferAcceptedComment']");
	}

	public static WebElement BrowseFile()
	{
		return waitElement("//input[@id='Doccheckup']");
	}
	public static WebElement save() {
		return waitElement("//input[@id='btnOfferAccepted']");
	}

	public static WebElement back() {
		return waitElement("//a[contains(text(),'Back')]");
	}

}
