package com.test.automation.UIAutomation.extendReport;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentUtil 
{
	//public static ExtentReports extent;
	 static ExtentReports extentReports=null;
	    static Map<Integer,ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

	    public static ExtentReports createReporter(String fileName){
	        //HTML Reporter
	        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(fileName);
	        extentHtmlReporter.config().setTheme(Theme.STANDARD);
	        extentHtmlReporter.config().setReportName("Sample ExtentReports with Nunit");
	        extentHtmlReporter.config().setChartVisibilityOnOpen(true);

	        extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        /*htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);*/
	        extentHtmlReporter.config().setDocumentTitle(fileName);
	        extentHtmlReporter.config().setEncoding("utf-8");
	        extentHtmlReporter.config().setReportName(fileName);
	        //System Info
	        extentReports = new ExtentReports();
	        extentReports.attachReporter(extentHtmlReporter);
	        try {
	            extentReports.setSystemInfo("HostName", InetAddress.getLocalHost().getHostName());
	            extentReports.setSystemInfo("IP Address",InetAddress.getLocalHost().getHostAddress());
	            extentReports.setSystemInfo("OS",System.getProperty("os.name"));
	            extentReports.setSystemInfo("UserName",System.getProperty("user.name"));
	            extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        }
	        
	        //ExtentX Reporter
	       /* ExtentXReporter extentXReporter = new ExtentXReporter("localhost");
	        extentXReporter.config().setServerUrl("http://localhost:1337");
	        extentXReporter.config().setReportName("Sample ExtentXReport");   
*/
	        return extentReports;
	    }

	    public static ExtentReports getExtentReports(){
	        return extentReports;
	    }

	    public static void saveReporter(){
	        if(extentReports !=null){
	            extentReports.flush();
	        }
	    }

	    public static synchronized ExtentTest createTest(String testName){
	        ExtentTest extentTest = extentReports.createTest(testName);
	        extentTestMap.put((int) (Thread.currentThread().getId()),extentTest);
	        return extentTest;
	    }

	    public static synchronized ExtentTest createTest(String testName,String testDesc){
	        ExtentTest extentTest = extentReports.createTest(testName,testDesc);
	        extentTestMap.put((int) (Thread.currentThread().getId()),extentTest);
	        return extentTest;
	    }

	    public static synchronized ExtentTest fetchTest(){
	        return extentTestMap.get((int) (Thread.currentThread().getId()));
	    }

}
