package com.test.automation.UIAutomation.customListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.extendReport.ExtentUtil;
import com.test.automation.UIAutomation.ruffwork.BaseTest;
import com.test.automation.UIAutomation.ruffwork.Extent_ReportTest;

public class TestListenerAdapter2 extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		ExtentUtil.createTest(result.getMethod().getMethodName());
		String[] categories = result.getMethod().getGroups();
		for (String category : categories) {
			ExtentUtil.fetchTest().assignCategory(category);
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		/*int actual=result.getStatus();
		int expected=ITestResult.SUCCESS;
		if (actual==expected) {
			try {
				File file = Extent_ReportTest.getScreenShot();
				String path = "file://" + file.getAbsolutePath().toString();
				String encodstring = encodeFileToBase64Binary(file);
				String base = "data:image/png;base64," + encodstring;
				ExtentUtil.fetchTest().addScreenCaptureFromPath(path);
				Reporter.log("<a href='" + base + "'> <img src='" + base + "' height='100' width='100'/> </a>");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				File file = Extent_ReportTest.getScreenShot();
				String path = "file://" + file.getAbsolutePath().toString();
				/*String encodstring = encodeFileToBase64Binary(file);
				String base = "data:image/png;base64," + encodstring;*/
				/*ExtentUtil.fetchTest().addScreenCaptureFromPath(path);
				ExtentUtil.fetchTest().info("Error Images");*/
				test.log(Status.FAIL, result.getThrowable());
				//.log(LogStatus.FAIL, result.getThrowable());
				test.log(Status.FAIL, path);
				String encodstring = encodeFileToBase64Binary(file);
				String base = "data:image/png;base64," + encodstring;
				test.log(Status.FAIL, "Failed method screenshot below" + test.addScreenCaptureFromPath(path));
				
				Reporter.log("<a href='" + base + "'> <img src='" + base + "' height='100' width='100'/> </a>");

			} catch (IOException e) {
				test.log(Status.FAIL, e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		/*if (ExtentUtil.getExtentReports() == null) {
			ExtentUtil.createReporter("D:\\Java_Project\\SourceProsUSA\\test-output\\New folder\\extentreport.html");
		}*/
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentUtil.saveReporter();
	}

	private static String encodeFileToBase64Binary(File file) {
		String encodedfile = null;
		try {
			FileInputStream fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encodedfile;
	}
}
