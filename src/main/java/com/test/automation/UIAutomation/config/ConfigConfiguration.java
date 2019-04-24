package com.test.automation.UIAutomation.config;

import org.apache.log4j.Logger;

import com.test.automation.UIAutomation.testBase.TestBase;

public class ConfigConfiguration extends TestBase 
{
	
	public static Logger log = Logger.getLogger(ConfigConfiguration.class.getName());
	
	public static String getTestUrl()
	{
		return Config.getProperty("testsiteurl");
	}
	public static String getBrowser()
	{
		return Config.getProperty("browser");
	}
	public static int getImplicitwait()
	{
		return Integer.parseInt(Config.getProperty("implicit.wait"));
	}
	public static int getRetryfailedtest()
	{
		return Integer.parseInt(Config.getProperty("retryfailedtest"));
	}
	public static  String getExelSheetName()
	{
		return Config.getProperty("exelsheetname");
	}
	public static  String getLoginsheetName()
	{
		return Config.getProperty("LoginsheetName");
	}
	public static String getRIPLLoginTestData()
	{
		return Config.getProperty("RIPLLoginTestData");
	}
	public static String getRegisterDetailsTestData()
	{
		return Config.getProperty("RegisterDetailsTestData");
	}
	public static String getUpdateRegisterdetails()
	{
		return Config.getProperty("UpdateRegisterdetails");
	}
	public static String getRequirement()
	{
		return Config.getProperty("Requirement");
	}
	public static String getCandidate()
	{
		return Config.getProperty("CandidateName");
	}
	/*public ConfigConfiguration ()
	{
		try {
			 or=new Properties();
			 file= new File(System.getProperty("user.dir") + "//resources//properties//Config.properties");
			input=new FileInputStream(file);
			or.load(input);	
			ConfigConfiguration.testsiteurl=or.getProperty("testsiteurl");
			ConfigConfiguration.browser=or.getProperty("browser");
			ConfigConfiguration.implicitwait=or.getProperty("implicit.wait");
			ConfigConfiguration.retryfailedtest=or.getProperty("retryfailedtest");
			ConfigConfiguration.exelsheetname=or.getProperty("exelsheetname");
			ConfigConfiguration.LoginsheetName=or.getProperty("LoginsheetName");
			ConfigConfiguration.RIPLLoginTestData=or.getProperty("RIPLLoginTestData");
			ConfigConfiguration.SingleLoginTestData=or.getProperty("SingleLoginTestData");
			ConfigConfiguration.RegisterDetailsTestData=or.getProperty("RegisterDetailsTestData");
			ConfigConfiguration.UpdateRegisterdetails=or.getProperty("UpdateRegisterdetails");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}*/
	
	
	
	
	/*public static final String server="mail.rangam.com";
	public static final  String port="25";
	public static final String from = "yogeshsolanki@rangam.com";
	public static final  String Emailpassword = "june@2017";
	public static final String to ="yogeshsolanki@rangam.com";
	public static final String Emailusername="yogeshsolanki@rangam.com";
	public static final String cc = "yogeshsolanki@rangam.com";
	//qateam@rangam.com  kedarhukeri@rangam.com
//	public static String[] bcc = {"yogeshsolanki@rangam.com"};
	public static final String subject = "Automation Report";	
	public static final  String messageBody ="Please Find Attachment For the Report";
	public static final  String attachmentPath=RootDirectory+"\\extentconfig\\AutomationReport.html";
	public static final String attachmentName="AutomationReport.html";*/
	
	
	
	
	
}
