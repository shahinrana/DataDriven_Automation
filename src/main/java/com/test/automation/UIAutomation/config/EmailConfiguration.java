package com.test.automation.UIAutomation.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.test.automation.UIAutomation.mailMoniter.MonitoringMail;
import com.test.automation.UIAutomation.testBase.TestBase;

public class EmailConfiguration extends TestBase 
{
	
	Properties or;
	File file;
	FileInputStream input;
	
	
	public static  String server;
	public static   String port;
	public static  String from;
	public static   String Emailpassword;
	public static  String to;
	public static  String Emailusername;
	public static  String cc;
	//qateam@rangam.com  kedarhukeri@rangam.com
//	public static String[] bcc = {"yogeshsolanki@rangam.com"};
	public static  String subject;	
	public static  String messageBody;
	//public static final  String attachmentPath=RootDirectory+"\\extentconfig\\AutomationReport.html";
	public static final  String attachmentPath=System.getProperty("user.dir")+"//Reports.zip";;
	public static String attachmentName;
	
	
	
	
	public static Logger log = Logger.getLogger(EmailConfiguration.class.getName());
	
	public EmailConfiguration()
	{
		try {
			 or=new Properties();
			 file= new File(System.getProperty("user.dir") + "//resources//properties//EmailConfig.properties");
			input=new FileInputStream(file);
			or.load(input);	
			EmailConfiguration.server=or.getProperty("server");
			EmailConfiguration.port=or.getProperty("port");
			EmailConfiguration.from=or.getProperty("from");
			EmailConfiguration.Emailpassword=or.getProperty("Emailpassword");
			EmailConfiguration.to=or.getProperty("to");
			EmailConfiguration.Emailusername=or.getProperty("Emailusername");
			EmailConfiguration.cc=or.getProperty("cc");
			EmailConfiguration.subject=or.getProperty("subject");
			EmailConfiguration.messageBody=or.getProperty("messageBody");
			EmailConfiguration.attachmentName=or.getProperty("attachmentName1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	
	
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
