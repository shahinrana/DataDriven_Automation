package com.test.automation.UIAutomation.helper;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class CalenderSelect extends TestBase
{
	WebDriver driver;
	public CalenderSelect(WebDriver driver) {
		this.driver=driver;
	}

	public static void calender(String Day) {

		String year = null;
		int month = 0;
		String expectedDay = null;
		String array1[] = Day.split("/");
		for (int i = 0; i < array1.length; i++) {
			month = Integer.parseInt(array1[0]);
			expectedDay = array1[1];
			year = array1[2];
		}

		year(year);

		month(month);

		days(expectedDay);
	}

	public static void year(String year) {
		WebElement years = waitElement(".//*[@id='ui-datepicker-div']/div/div/select[@class='ui-datepicker-year']");
		while (true) {
			Select(years, year);
			break;
		}
	}

	public static void month(int month) {
		WebElement months = waitElement(".//*[@id='ui-datepicker-div']/div/div/select[@class='ui-datepicker-month']");
		String getMonth = setMonthName(month);
		while (true) {
			Select(months, getMonth);
			break;
		}
	}

	private static String setMonthName(int month) {
		String monthString;
		switch (month) {
		case 1:
			monthString = "January";
			break;
		case 2:
			monthString = "February";
			break;
		case 3:
			monthString = "March";
			break;
		case 4:
			monthString = "April";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "June";
			break;
		case 7:
			monthString = "July";
			break;
		case 8:
			monthString = "August";
			break;
		case 9:
			monthString = "September";
			break;
		case 10:
			monthString = "October";
			break;
		case 11:
			monthString = "November";
			break;
		case 12:
			monthString = "December";
			break;
		default:
			monthString = "Invalid month";
			break;
		}
		return monthString;
	}

	public static void days(String expectedDay) {
		List<WebElement> days = waitElements(".//*[@id='ui-datepicker-div']/table/tbody/tr/td/a");
		for (WebElement day : days) {
			if (day.getText().equalsIgnoreCase(expectedDay)) {
				day.click();
				break;
			}
		}

	}

}
