package com.test.automation.UIAutomation.ruffwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontDesk {

	private static final int List = 0;

	public static void main(String[] args) throws InterruptedException {
	
		/* ArrayList<Object> al = new ArrayList<>();
		al.add(1);
		al.add(1.5);  
		al.add('c');  
		al.add("Ravi");  
		al.add("Ajay");  
		for(Object obj:al)
		{  
				System.out.println(obj);  
		}  */
		/*for(int i=0;i<10;i++)
		{
			System.out.println("befor the equal loop :i:"+i);
			if(i==5)
			{
				System.out.println("i:"+i);
				break;
			}
		}*/
		
	/*	for(int j=11;j<20;j++)
		{
			System.out.println("befor the equal loop :j:"+j);
			if(j==15)
			{
				System.out.println("j:"+j);
				return;
			}
		}*/
	/*	for(int k=21;k<30;k++)
		{
			System.out.println("befor the equal loop :k:"+k);
			if(k==27)
			{
				System.out.println("k:"+k);
				continue;
			}
		}*/
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\geckodriver.exe");
		//"webdriver.chrome.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\chromedriver.exe"
		driver=new ChromeDriver();
		//driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.co.in/flights/?f=0&gl=in");
		driver.manage().window().maximize();
		
		Actions action=new Actions(driver);
		
		
		List<WebElement> frmElement = driver.findElements(By.xpath("//div[@class='EIGTDNC-Jb-b']"));
		System.out.println(frmElement.size());
		for(int k=0;k<frmElement.size();k++)
		{
			System.out.println(frmElement.get(k).getText());
			if(frmElement.get(k).getText().equals("BDQ Vadodara"))
			{
				
			  WebElement txtcity = driver.findElement(By.xpath(".//*[@id='root']/div[3]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div/div[1]/div[5]/table/tbody/tr[1]/td[1]/div/input"));
			  action.moveToElement(txtcity);
			  action.sendKeys("Dubai").build().perform();		
			}
			
		}
		
		driver.findElement(By.xpath(".//*[@id='calendar-view']/em")).click();
		driver.findElement(By.xpath(".//*[@id='search-link']")).click();
		
		
		
		//for the calender to select using action class
		Actions actions = new Actions(driver);
		
		WebElement selectFromCalender = driver.findElement(By.xpath(".//*[@id='publicBody_siteBody_UCEventSearch_UCEventSearch_txtStartDate']"));
		System.out.println("selectFromCalender: "+selectFromCalender.getText());
		actions.moveToElement(selectFromCalender);//mouse over to element
		actions.click().build().perform();//mouse event to click
		//selectFromCalender.click();
		
		while(true)
		{
			String selectFromMonth = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();//get the month text
			String selectFromeYear = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[2]")).getText();//get the year text
			if(selectFromMonth.equals("April")&& selectFromeYear.equals("2018"))//if condition to select month and year
			{
				break;//if found then stop to find and break the loop
			}
			else
			{
				driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
				//click till to find the month and year 
			}
		}
		
		List<WebElement> rowCalendar = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr"));
		for(int row=1;row<=rowCalendar.size();row++)
		{
			List<WebElement> colCalendar = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr["+row+"]/td"));
			for(int col=0;col<colCalendar.size();col++)
			{
				System.out.print(colCalendar.get(col).getText()+"\t\t");
				if(colCalendar.get(col).getText().equals("1"))
				{
					colCalendar.get(col).click();
					break;
				}
			}
			System.out.println();
		}
		
		
		
		
	
		
		WebElement selectToCalender = driver.findElement(By.xpath(".//*[@id='publicBody_siteBody_UCEventSearch_UCEventSearch_txtEndDate']"));
		System.out.println("selectFromCalender: "+selectToCalender.getText());
		actions.moveToElement(selectToCalender);
		actions.click().build().perform();
		
		
		while(true)
		{
			String selectToMonth = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();
			String selectToYear = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[2]")).getText();
			if(selectToMonth.equals("November")&& selectToYear.equals("2018"))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
			}
		}
		
		List<WebElement> rowCalendar1 = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr"));
		for(int row=1;row<=rowCalendar1.size();row++)
		{
			List<WebElement> colCalendar = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr["+row+"]/td"));
			for(int col=0;col<colCalendar.size();col++)
			{
				System.out.print(colCalendar.get(col).getText()+"\t\t");
				if(colCalendar.get(col).getText().equals("25"))
				{
					colCalendar.get(col).click();
					break;
				}
			}
			System.out.println();
		}
		
		
		 WebElement fromcal = driver.findElement(By.xpath("//*[@id='root']/div[3]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div/div[1]/div[5]/table/tbody/tr[2]/td[1]/div/div[1]/div[2]/input"));
		 fromcal.click();
		
		
		while(true)
		{
			String yr=driver.findElement(By.xpath("html/body/div[3]/div/div/table/tbody/tr[1]/td/div/div[3]")).getText();
			String months=driver.findElement(By.xpath("html/body/div[3]/div/div/table/tbody/tr[1]/td/div/div[4]")).getText();
			System.out.println("year: "+ yr+"\t\tmonth:"+months);
			if(yr.equals("December") && months.equals("January 2018"))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("html/body/div[3]/div/div/table/tbody/tr[1]/td/div/div[2]")).click();
			}
		}
		
		 List<WebElement> rowCalender = driver.findElements(By.xpath("html/body/div[3]/div/div/table/tbody/tr[2]/td/div/table[1]/tbody/tr"));
		 
		for(int row=1;row<=rowCalender.size();row++)
		{
			List<WebElement> fromCalender = driver.findElements(By.xpath("html/body/div[3]/div/div/table/tbody/tr[2]/td/div/table[1]/tbody/tr["+row+"]/td"));
			//html/body/div[3]/div/div/table/tbody/tr[2]/td/div/table[1]/tbody/tr[5]/td
			//System.out.println("**************************************");
			for(int col=0;col<fromCalender.size();col++)
			{				
				System.out.print(fromCalender.get(col).getText()+"\t\t");
				if(fromCalender.get(col).getText().equals("3"))
				{
					fromCalender.get(col).click();
					break;
					//break;
				}
			}
			System.out.println();
		}
		
		for(int row=1;row<=rowCalender.size();row++)
		{
			List<WebElement> toCalender = driver.findElements(By.xpath("html/body/div[3]/div/div/table/tbody/tr[2]/td/div/table[2]/tbody/tr["+row+"]/td"));
		
			for(int col=0;col<toCalender.size();col++)
			{				
				System.out.print(toCalender.get(col).getText()+"\t\t");
				if(toCalender.get(col).getText().equals("25"))
				{
					toCalender.get(col).click();
					break;
				}
			}
			System.out.println();
		}
		
     List<WebElement> listofDetails = driver.findElements(By.xpath(".//*[@id='root']/div[3]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/a"));
     System.out.println("listofDetails:"+listofDetails.size());
 
		for(int i=1;i<=listofDetails.size();i++)
		{
			List<WebElement> subcolumn = driver.findElements(By.xpath(".//*[@id='root']/div[3]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/a["+i+"]/div"));
			//List<WebElement> subcolumn = driver.findElements(By.xpath(".//*[@id='root']/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/div/div/div/div/div/div["+i+"]/a/div"));
		     System.out.println("subcolumn:"+subcolumn.size());
			for(int j=1;j<=subcolumn.size();j++)
			{	
				List<WebElement> subcolumn2 = driver.findElements(By.xpath(".//*[@id='root']/div[3]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/a["+i+"]/div["+j+"]"));
				System.out.print(subcolumn.get(j).getText()+"\t\t\t");
			}
			System.out.println();
			
		}
		
		/*MyClass yogesh=new MyClass();
		yogesh.setAge(25);
		yogesh.setId(12);
		yogesh.setName("Yohgesh");
		yogesh.setBio("I am a tester");
		System.out.println(yogesh.getId()+"\t"+yogesh.getName()+"\t\t"+yogesh.getAge()+"\t"+yogesh.getBio());
		MyClass raghav=new MyClass();
		raghav.setAge(24);
		raghav.setId(12);
		raghav.setName("Raghav");
		raghav.setBio("He is programmer");
		System.out.println(raghav.getId()+"\t"+raghav.getName()+"\t\t"+raghav.getAge()+"\t"+raghav.getBio());*/
		
	}

}
