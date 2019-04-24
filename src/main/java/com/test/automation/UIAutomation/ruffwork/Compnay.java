package com.test.automation.UIAutomation.ruffwork;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.Iterator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;



public class Compnay 
{
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
	
		System.out.println("---------------------");
		ArrayList al= new ArrayList();
		al.add("yogesh");
		al.add(123456);
		al.add('B');
		al.add(25.11);
		al.add(null);
		al.add(null);
		System.out.println("ArrayList :");
		for(Object l: al)
		{
			System.out.print(l+"\t");
		}
		System.out.println();
		System.out.println("---------------------");
		
		LinkedList ll= new LinkedList();
		ll.add("yogesh");
		ll.add(123456);
		ll.add('B');
		ll.add(25.11);
		ll.add(null);
		ll.add(null);
		System.out.println("LinkedList  :");
		for(Object l: ll)
		{
			System.out.print(l+"\t");
		}
		System.out.println();
		System.out.println("---------------------");
		
		List vl= new Vector();
		vl.add("1");
		vl.add(2);
		vl.add('3');
		vl.add(4);
		vl.add("5");
		vl.add(6);
		System.out.println("Vector List :");
		for(Object l: vl)
		{
			System.out.print(l+"\t");
		}
		System.out.println();
		System.out.println("---------------------");
		
		/*Iterator it=vl.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}*/
		
		//System.out.println();
		
	/*	ListIterator li= vl.listIterator();
		while (li.hasNext()) 
		{
			System.out.println(li.next());
		}*/
		//System.out.println();
		ListIterator li1= vl.listIterator();
	/*	System.out.println("Reverse order:");
		ListIterator li1= vl.listIterator();
		for(int i=0;i<vl.size();i++)
		{
			li1.next();
		}*/
		System.out.println("Reverse order2:");
		while (li1.hasPrevious()) 
		{
			System.out.println(li1.previous());
		}
		//WebDriver driver;
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\geckodriver.exe");
		//"webdriver.chrome.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\chromedriver.exe"
		//driver=new ChromeDriver();
		/*RemoteWebDriver driver;
		String appURL = "http://www.google.com";
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		driver.manage().window().maximize();
		
		
		System.out.println("*** Navigation to Application ***");
		driver.navigate().to(appURL);
		String strPageTitle = driver.getTitle();
		System.out.println("*** Verifying page title ***");
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title match");
		driver.quit();*/
		/*String URL = "http://www.DemoQA.com";
 		String Node = "http://192.168.1.164:4444/wd/hub";
 		DesiredCapabilities cap = DesiredCapabilities.chrome();
 
 		RemoteWebDriver driver = new RemoteWebDriver(new URL(Node), cap);
 
 		driver.navigate().to(URL);
 		Thread.sleep(5000);
 		driver.quit();*/
	/*Employee e1=new Employee();
	e1.setDetails("xyz", 1, "QA");
	e1.getDetais();*/
	}
	/*public <X> X getScreenshotAs(OutputType<X> target) {
		// Get the screenshot as base64.
		String base64 = execute(DriverCommand.SCREENSHOT).
		getValue().toString();
		// ... and convert it.
		return target.convertFromBase64Png(base64);
		}*/

}
