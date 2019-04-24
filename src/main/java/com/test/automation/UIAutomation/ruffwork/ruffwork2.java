package com.test.automation.UIAutomation.ruffwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ruffwork2
{
	public static Logger log= Logger.getLogger(ruffwork2.class.getName());
	public static WebDriver driver;

	public static void main(String[] args) throws Exception 
	{	
		browserLoad();		
	}
	@SuppressWarnings("deprecation")
	public static void browserLoad() throws InterruptedException, Exception
	{
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		*/
		//options.addArguments("–lang= sl");
		//ChromeDriver driver = new ChromeDriver(options);
		/*EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);*/
		
		/*FileReader fr = new FileReader("C:/Users/yogeshsolanki/Desktop/java practice/readword.txt");
		BufferedReader br = new BufferedReader(fr);*/
	/*	String line = "", str = "";
		String s="";
		int a = 0;
		int b = 0;
		while ((line = br.readLine()) != null) 
		{
			str += line + " ";
			b++;
		}
		System.out.println("Totally " + b + " lines");

		System.out.println(str);

		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) 
		{
			 s = st.nextToken();
			a++;
		}
		
	
		
		System.out.println("File has " + a + " words are in the file");*/
		
		
   /*
	       String line = br.readLine();
	       System.out.println(line);
   		   int count = 0;
	       while (line != null) {
	          String []parts = line.split(" ");
	          for( String w : parts)
	          {
	            count++;        
	          }
	          line = br.readLine();
	       }         
	       System.out.println("count="+count);

		String str2 = "Just keep a boolean";
		System.out.println("str2:"+str2);   
		
		String initials = WordUtils.initials(str2);

	    System.out.println(initials);
	    //so number of words in your file will be
	    System.out.println(initials.length());*/    
		
		/*String url="http://192.168.1.160:5555/wd/hub";
		DesiredCapabilities capabilitis=new DesiredCapabilities().chrome();
		capabilitis.setBrowserName("chrome");
		capabilitis.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		driver=new RemoteWebDriver(new URL(url), capabilitis);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		String url1="http://intranet.rangam.com/";
		String weburl="window.location=\'"+url+"\'";
		((JavascriptExecutor)driver).executeScript(weburl);
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/");*/
		
		
	/*	driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("yogeshsolanki@rangam.com");
		driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("Hariohm@123");
		driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	
		

		File f = new File("C:\\Users\\yogeshsolanki\\Desktop\\IAGSC\\browser.data");
		try
		{
			f.delete();
			f.createNewFile();
			FileWriter fos = new FileWriter(f);
			BufferedWriter bos = new BufferedWriter(fos);
			for(Cookie ck : driver.manage().getCookies()) 
			{
				bos.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
				bos.newLine();
			}
			bos.flush();
			bos.close();
			fos.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}*/
		
		
		
		
		/*try{	
			File f2 = new File("C:\\Users\\yogeshsolanki\\Desktop\\IAGSC\\browser.data");
			FileReader fr = new FileReader(f2);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null){
			StringTokenizer str = new StringTokenizer(line,";");
			while(str.hasMoreTokens()){
			String name = str.nextToken();
			String value = str.nextToken();
			String domain = str.nextToken();
			String path = str.nextToken();
			Date expiry = null;
			String dt;
			if(!(dt=str.nextToken()).equals("null")){
			expiry = new Date(dt);
			}
			boolean isSecure = new Boolean(str.nextToken()).
			booleanValue();
			Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
			driver.manage().addCookie(ck);
			}
			}
			}catch(Exception ex){
			ex.printStackTrace();
			}
		driver.get("http://intranet.rangam.com/");*/
		//System.out.println(driver.manage().window().getSize());
		
		//driver.switchTo().frame(0);
		/*WebElement one= driver.findElement(By.xpath(".//*[@id='sidebar']/aside[1]/ul/li[5]/a"));
		
		Robot object=new Robot();

		// Press Enter<br>
		object.keyPress(KeyEvent.VK_PRINTSCREEN);*/

		// Release Enter<br>
		//object.keyRelease(KeyEvent.VK_ENTER);
		
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", one);
		/*Actions building = new Actions(driver);
		building.moveToElement(one);
		building.contextClick();
		building.build().perform();*/
		/*WebElement two= driver.findElement(By.xpath("html/body/ul/li[3]"));
		WebElement three= driver.findElement(By.xpath("html/body/ul/li[5]"));*/
		/*System.out.println(one.getText()+"\t"+three.getText());
		System.out.println("one.getLocation().getX()="+one.getLocation().getX()+"\t one.getLocation().getY()="+one.getLocation().getY());
		System.out.println("three.getLocation().getX()="+three.getLocation().getX()+"\t three.getLocation().getY()="+three.getLocation().getY());
		Actions builder=new Actions(driver);
		
		//builder.moveByOffset(one.getLocation().getX(), one.getLocation().getY())
		builder.clickAndHold(one);
		builder.moveToElement(three);
		//.moveByOffset(three.getLocation().getX(), three.getLocation().getY())
		builder.release();
		builder.perform();
		System.out.println("one.getLocation().getX()="+one.getLocation().getX()+"\t one.getLocation().getY()="+one.getLocation().getY());
		System.out.println("three.getLocation().getX()="+three.getLocation().getX()+"\t three.getLocation().getY()="+three.getLocation().getY());*/
		//.build().perform();
		
	/*	int border = 1;
		int tileWidth = 100;
		int tileHeight = 80;
		Actions builder = new Actions(driver);*/
		//Click on One
		/*builder.moveByOffset(one.getLocation().getX()+border, one.
		getLocation().getY()+border).click();
		builder.build().perform();*/
		// Click on Eleven
		/*builder.moveByOffset(2*tileWidth+4*border, 2*tileHeight+4*border).
		click();
		builder.build().perform();
		//Click on Five
		builder.moveByOffset(-2*tileWidth-4*border,-tileHeight-2*border).
		click();
		builder.build().perform();*/
		
		/*Actions builder = new Actions(driver);
		builder.moveByOffset(three.getLocation().getX()+1, three.getLocation().getY()+1).click();
		builder.perform();
		System.out.println("three.getLocation().getX()+1:"+three.getLocation().getX()+1);
		System.out.println("three.getLocation().getX()+1:"+three.getLocation().getY()+1);*/
	/*	Actions act=new Actions(driver);
		//act.keyDown(Keys.CONTROL);
		act.click(one);
		//act.build().perform();
		act.click(two);
		//act.build().perform();
		act.click(three);
		//act.build().perform();
		//act.keyUp(Keys.CONTROL);
		act.build().perform();*/
		
		//eDriver.get("https://www.google.com");
		 //System.out.println("destFile:"+destFile.toString());
		//FileUtils.copyFile(scrFile, destFile);
		/*WebElement searchTxtbox= eDriver.findElement(By.xpath(".//*[@id='lst-ib']"));
		String software="software testing";
		((JavascriptExecutor)eDriver).executeAsyncScript("arguments[0].value='"+software+"'", searchTxtbox);*/
		 
		//setAttribute(searchTxtbox, attributeName, "testing");
	/*	String cssValue= driver.findElement(By.xpath(".//*[@id='_eEe']/a[1]")).getCssValue("text-decoration"); 
		System.out.println("value: "+cssValue); 
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='_eEe']/a[1]"))).perform();
		String cssValue1= driver.findElement(By.xpath(".//*[@id='_eEe']/a[1]")).getCssValue("text-decoration");
		System.out.println("value over: "+cssValue1); */
		//driver.close();
		
		/* File srcFile = eDriver.getScreenshotAs(OutputType.FILE); 
		 org.apache.commons.io.FileUtils.copyFile(srcFile, new File("C:\\Users\\yogeshsolanki\\Desktop\\IAGSC\\test.jpg"));*/
		 
		 //driver.quit();
		
	}
/*	public static void setAttribute(WebElement element, String attributeName, String value) 
	{ 
		WrapsDriver wrappedElement = (WrapsDriver) element;
		JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
		driver.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, attributeName, value);
	}	*/
	/*public static void load()
	{
		File file=new File("Z:\\Java_Project\\Workspace\\UIAutomation-master\\UIAutomation-master\\extentconfig\\");
		File[] listOfFiles = file.listFiles();
		for(File f: listOfFiles)
		{
			System.out.println("file name:"+f.getName());
			String ext1 = FilenameUtils.getExtension(f.getName());
			System.out.println("file extension:"+ext1);
			
		}
		
		
		String[] str = {"www.java2novice.com", "http://java2novice.com"};
        for(int i=0;i < str.length;i++){
            if(str[i].matches("^www\\.(.+)")){
                System.out.println(str[i]+" Starts with 'www'");
            } else {
                System.out.println(str[i]+" is not starts with 'www'");
            }}
	}
	*/	

	
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 EventFiringWebDriver driver = new EventFiringWebDriver(dr);
		 WebEventListener eventListener= new WebEventListener();
		 driver.register(eventListener);
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://demo.ripl.sourcepros.com");
		 /*driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='UserName']")).sendKeys("yogeshsolanki@rangam.com");
		driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("Rangam@123");
		driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(".//*[@id='lnkRequirements']"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath(".//*[@id='lnkRequirementView']"))).click().build().perform();
		
		
		driver.findElement(By.xpath(".//*[@id='tabReqDetails']/div/div[1]/div[2]/div[2]/div/a")).click();
		addJobTilte(".Net Developer - Drive 3-4yrs");*/
		//driver.switchTo().window("Requirement Details");
		//System.out.println("currnet:"+driver.getTitle());
		
		//driver.switchTo().window("CDwindow-e4df18ec-55c2-41c9-bf8a-4a790a2bf42e");
	
	/*public static void addJobTilte(String jbtitle)
	{
		Set<String> handle = driver.getWindowHandles();
		for(String hand: handle)
		{
			driver.switchTo().window(hand);
			System.out.println("handles :"+driver.getTitle());
			System.out.println("handles :"+hand);
		}
		driver.findElement(By.xpath(".//*[@id='JobTitleText']")).sendKeys(jbtitle);
		driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/form/div[2]/div/a")).click();//change this button xpath to Save button
		driver.findElement(By.xpath(".//*[@id='SearchText']")).sendKeys(jbtitle);
		driver.findElement(By.xpath(".//*[@id='btnSearch']")).click();
		System.out.println("currnet:"+driver.getTitle());
		driver.close();
		//String handle2 = driver.getWindowHandle();
		//System.out.println("handle2:"+handle2);
		Set<String> handle2 = driver.getWindowHandles();
		for(String hand: handle2)
		{			
			driver.switchTo().window(hand);
			System.out.println("handles :"+driver.getTitle());
			if(driver.getTitle().equalsIgnoreCase("Requirement Details"))
			{
				System.out.println("handles :"+hand);
				driver.findElement(By.xpath(".//*[@id='JobTitleText']")).sendKeys(jbtitle);
				//break;
				return;
			}
			
		}
	}
	*/
}
/*	public static void calenderSelect (String month, String year)
		{
			
			driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[1]/select")).click();
			
			Select month1 = new Select(driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[1]/select")));
			month1.selectByVisibleText(month);
			System.out.println(driver.getTitle());
			while(true)
			{
				String year1=	driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/font/b")).getText();
				
				//Select month = ;
				if(year.equals(year))
				{
					break;
				}
				else
				{
					driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a[2]/b/font")).click();
				}
			}
			
			
			List<WebElement> row = driver.findElements(By.xpath("html/body/form/table/tbody/tr"));
			System.out.println("row size:"+row.size()); 
			for(int i=1;i<=row.size();i++)
			{
				List<WebElement> col = driver.findElements(By.xpath("html/body/form/table/tbody/tr["+i+"]/td"));
				//System.out.println("col size:"+col.size()); 
				try {
					for(int j=0;j<col.size();j++)
					{
						System.out.print(col.get(j).getText()+"\t\t\t");
							if(col.get(j).getText().equals("25"))
							{
								col.get(j).click();						
								return;
							}
					
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
			}
			
		}
	*/
		/*	System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\chromedriver.exe");
		 dr = new ChromeDriver();
		 EventFiringWebDriver driver = new EventFiringWebDriver(dr);
		 WebEventListener eventListener= new WebEventListener();
			//ErrorHandler handler = new EventHandler();
		 driver.register(eventListener);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://toolsqa.wpengine.com/automation-practice-table");
		driver.manage().window().maximize();*/
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;  
		
		//((JavaScriptExecutor)driver).executeScript("document.body.style.zoom='100%'");
		//js.executeAsyncScript("window.scrollTo(0,document.body.scrollHeight)");
		
		//Thread.sleep(5000);
		//js.executeAsyncScript("window.scrollTo(0,-document.body.scrollHeight)");
		/*js.executeScript("document.body.style.zoom='20%'");*/
		
		//js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id='text-18']/div[2]/b[1]/a")));
		/*String sRow = "1";
		String sCol = "2";
		
		//Here we are locating the xpath by passing variables in the xpath
		String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
		System.out.println("sCellValue: "+sCellValue);
		String sRowValue = "Clock Tower Hotel";
		
		//First loop will find the 'ClOCK TWER HOTEL' in the first column
		for (int i=1;i<=5;i++){
			String sValue = null;
			sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
			System.out.println("sValue: "+sValue);
				if(sValue.equalsIgnoreCase(sRowValue)){
					// If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row 
					for (int j=1;j<=5;j++){
						String sColumnValue= driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText();
						System.out.println("sColumnValue: "+sColumnValue);
					}
				break;
				}
			}*/
		//driver.close();
		
	

