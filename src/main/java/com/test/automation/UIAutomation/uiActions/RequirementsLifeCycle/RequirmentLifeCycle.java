package com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class RequirmentLifeCycle extends TestBase {
	public static Logger log = Logger.getLogger(RequirmentLifeCycle.class.getName());

	public static WebElement selectCandidate(String candidate) {
		WebElement can = waitElement("//a[contains(text(),'"+candidate+"')]");
		if (candidate.equalsIgnoreCase(can.getText())) {
			return can;
		} else {
			log.info("Candidate not in propective cycle");
		}
		return can;
	}

	public static WebElement selectLifeCycle(String lifecycle) {
		return waitElement("//a[contains(text(),'" + lifecycle + "')]");
	}

	public static WebElement SelectCheckbox(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::td/preceding-sibling::td/div/span/input[@id='chkselect']");
	}

	public static WebElement assessmentCall(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::td/following-sibling::td[9]/a[@id='lnkCall']");
	}

	public static WebElement assessmentAction(String name) {
		return waitElement("//a[contains(text(),'" + name + "')]/parent::div/parent::td/following-sibling::td/select");
	}

	public static WebElement prospectiveSMS(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::div/following-sibling::div[8]/a[@id='lnkSMS']");
	}

	public static WebElement prospectiveCall(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkCall']");
	}

	public static WebElement prospectiveEditView(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::div/following-sibling::div/a[contains(text(),'Edit/View')]");
	}

	public static WebElement prospectiveAction(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/select");
	}

	public static WebElement submissionSMS(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkSMS']");
	}

	public static WebElement submissionCall(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkCall']");
	}

	public static WebElement submissionEditView(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkEditSubmission']");
	}

	public static WebElement submissionDetails(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::div/following-sibling::div/a[@id='lnksubmissionDetails']");
	}

	public static WebElement submissionAction(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/select");
	}

	public static WebElement shortlistedSMS(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkSMS']");
	}

	public static WebElement shortlistedCall(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkCall']");
	}

	public static WebElement shortlistedEditView(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkEditShortlisted']");
	}

	public static WebElement shortlistedDetails(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::div/following-sibling::div/a[@id='lnksubmissionDetails']");
	}

	public static WebElement shortlistedAction(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/select");
	}

	public static WebElement interviewSMS(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkSMS']");
	}

	public static WebElement interviewCall(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkCall']");
	}

	public static WebElement interviewEditView(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkEditInterview']");
	}

	public static WebElement interviewDetails(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::div/following-sibling::div/a[@id='lnksubmissionDetails']");
	}

	public static WebElement interviewAction(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/select");
	}

	public static WebElement offerReceivedCall(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkCall']");
	}

	public static WebElement offerReceivedView(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::div/following-sibling::div/a[@id='lnkEditOfferReceived']");

	}

	public static WebElement offerReceivedDetails(String name) {
		return waitElement("//a[contains(text(),'" + name
				+ "')]/parent::div/parent::div/following-sibling::div/a[@id='lnksubmissionDetails']");
	}

	public static WebElement offerReceivedAction(String name) {
		return waitElement(
				"//a[contains(text(),'" + name + "')]/parent::div/parent::div/following-sibling::div/select");
	}

}
