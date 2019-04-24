package com.test.automation.UIAutomation.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.LoginPage.LoginPage;
import com.test.automation.UIAutomation.config.ConfigConfiguration;
import com.test.automation.UIAutomation.config.ElementLoad;
import com.test.automation.UIAutomation.config.EmailConfiguration;
import com.test.automation.UIAutomation.config.RequirementConfig;
import com.test.automation.UIAutomation.customListener.Listener;
import com.test.automation.UIAutomation.customListener.WebEventListener;
import com.test.automation.UIAutomation.errorScreenShot.ErrorScreenShot;
import com.test.automation.UIAutomation.excelReader.Excel_Reader;
import com.test.automation.UIAutomation.extendReport.ExtentReportDemo;
import com.test.automation.UIAutomation.helper.AlertHelper;
import com.test.automation.UIAutomation.helper.BrowserHelper;
import com.test.automation.UIAutomation.helper.CalenderSelect;
import com.test.automation.UIAutomation.helper.DropDownHelper;
import com.test.automation.UIAutomation.helper.JavaScriptHelper;
import com.test.automation.UIAutomation.helper.WaitHelper;
import com.test.automation.UIAutomation.utility.ResourceHelper;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

//import TestNgPkg.ExtentReportDemo;

public class TestBase {
	public static WebDriver driver = null;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListner;
	public static ElementLoad ElementLoaderObj;
	// public static excelReader reader;
	public static Excel_Reader excel;
	// public static String path;
	public static String OS = System.getProperty("os.name").toLowerCase();
	public static Properties Config = new Properties();
	// public static Properties OR = new Properties();
	public static Properties loginPropertyFile = new Properties();
	public static Properties hompagePropertyFile = new Properties();
	public static Properties CandidateDetailsPropertyFile = new Properties();
	public static Properties CandidateListPropertyFile = new Properties();
	public static Properties RequirementDetailsPropertyFile = new Properties();
	public static Properties NewRequirementsDetailsPropertyFile = new Properties();
	public static Properties DashboardFile = new Properties();
	public static FileInputStream fConfig, fhomepage, floginpage, fCandidateDetails, fCandidateList,
			fRequirementDetailsFIS, fNewRequirementsDetails, fDashboard;// FOR
	public static Properties ORr;
	public static FileInputStream file;
	public static ArrayList<String> handles = new ArrayList<String>();

	public static Logger log = Logger.getLogger(TestBase.class.getName());
	public static WebDriverWait wait;

	public static ExtentReports extent = ExtentReportDemo.ExtentDemo("AutomationReport");
	public static ExtentTest test;
	public static Listener lis = new Listener();
	public static EmailConfiguration Emailconfig2 = new EmailConfiguration();
	public static RequirementConfig Requirementconfig = new RequirementConfig();
	public static LoginPage jsp;
	// public static PropertiesfilesLoad pfload;
	// public static ElementLoad elmentload = new ElementLoad();
	public static ErrorScreenShot errorscrenshot = new ErrorScreenShot();

	// Utility class
	public static AlertHelper alerhelper;
	public static BrowserHelper browserhelper;
	public static DropDownHelper dropdownhelper;
	public static JavaScriptHelper javascripthelper;
	public static WaitHelper waithelper;
	public static CalenderSelect calenderhelper;
	static {

		if (driver == null) {

			if (OS.contains("mac os x")) {
				try {
					fConfig = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//Config.properties");
					Config.load(fConfig);
					fhomepage = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//Requirements.properties");
					hompagePropertyFile.load(fhomepage);
					floginpage = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//LoginPage.properties");
					loginPropertyFile.load(floginpage);
					fCandidateDetails = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//CandidateDetails.properties");
					CandidateDetailsPropertyFile.load(fCandidateDetails);
					fCandidateList = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//CandidateList.properties");
					CandidateListPropertyFile.load(fCandidateList);
					fRequirementDetailsFIS = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//RequirementsDetails.properties");
					RequirementDetailsPropertyFile.load(fRequirementDetailsFIS);

					fNewRequirementsDetails = new FileInputStream(System.getProperty("user.dir")
							+ "//resources/properties//NewRequirementsDetails.properties");
					NewRequirementsDetailsPropertyFile.load(fNewRequirementsDetails);

					// log.debug("login property File Loaded sucessfully");
				} catch (Exception e) {

					e.printStackTrace();
				}

			} else {

				try {

					fConfig = new FileInputStream(
							ResourceHelper.getResourcePath("/resources/properties/Config.properties"));
					Config.load(fConfig);
					log.debug("Config File Loaded sucessfully");

					log.debug("OR File Loaded sucessfully");
					fhomepage = new FileInputStream(
							ResourceHelper.getResourcePath("/resources/properties/Requirements.properties"));

					hompagePropertyFile.load(fhomepage);
					log.debug("homepage File Loaded sucessfully");
					floginpage = new FileInputStream(
							ResourceHelper.getResourcePath("/resources/properties/LoginPage.properties"));

					loginPropertyFile.load(floginpage);
					log.debug("login property File Loaded sucessfully");
					fCandidateDetails = new FileInputStream(
							ResourceHelper.getResourcePath("/resources/properties/CandidateDetails.properties"));

					CandidateDetailsPropertyFile.load(fCandidateDetails);
					fCandidateList = new FileInputStream(
							ResourceHelper.getResourcePath("/resources/properties/CandidateList.properties"));

					CandidateListPropertyFile.load(fCandidateList);

					fRequirementDetailsFIS = new FileInputStream(
							ResourceHelper.getResourcePath("/resources/properties/RequirementsDetails.properties"));

					RequirementDetailsPropertyFile.load(fRequirementDetailsFIS);

					fNewRequirementsDetails = new FileInputStream(
							ResourceHelper.getResourcePath("/resources/properties/NewRequirementsDetails.properties"));

					NewRequirementsDetailsPropertyFile.load(fNewRequirementsDetails);

					fDashboard = new FileInputStream(
							ResourceHelper.getResourcePath("/resources/properties/Dashboard.properties"));

					DashboardFile.load(fDashboard);

				} catch (Exception e) {

					e.printStackTrace();
				}

			}

		}

	}

	@BeforeTest
	public static void setUp1() {
		String browserName;
		if (System.getProperty("browser") != null && !System.getProperty("browser").isEmpty()) {

			browserName = System.getProperty("browser");                                                                                             //get value from pom  e.g <propertyName>${browser}</propertyName>
		} else {
			browserName = Config.getProperty("browser");                                                                                             //get from property file browser value          
		}
		Config.setProperty("browser", browserName);
		// String browserName =Config.getProperty("browser");
		System.out.println("browserName:" + browserName);
		// Config.getProperty("browser");
		TestBase.initializeTestBaseSetup(browserName, Config.getProperty("testsiteurl"));
		log.info("open url succssfully");
		System.out.println(Config.getProperty("testsiteurl"));
		log.info(Config.getProperty("testsiteurl"));
		alerhelper = new AlertHelper(driver);
		browserhelper = new BrowserHelper(driver);
		dropdownhelper = new DropDownHelper(driver);
		javascripthelper = new JavaScriptHelper(driver);
		waithelper = new WaitHelper(driver);
		calenderhelper = new CalenderSelect(driver);
	}

	public static void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			// PropertyConfigurator.configure(ResourceHelper.getResourcePath("\\resources\\logs\\log4j.properties"));
			setDriver(browserType, appURL);
			log.info("creating object of " + browserType + "and URL of: " + appURL);
		} catch (Exception e) {
			System.out.println("BrowserType Error....." + e.getStackTrace());
		}
	}

	private static WebDriver setDriver(String browserType, String appURL) {

		LocalDriverFactory.initilize(browserType);
		WebDriver driver2 = LocalDriverFactory.getDriver();
		e_driver = new EventFiringWebDriver(driver2);
		eventListner = new WebEventListener();
		e_driver.register(eventListner);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ConfigConfiguration.getImplicitwait(), TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.navigate().to(appURL);
		return driver;
	}

	public static void waitForVisitibilty(WebElement element) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 60);
		// wait.until(ExpectedConditions.visibilityOf(element));
		if (!element.isDisplayed()) {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.ignoring(NoSuchElementException.class);
		} else {
			log.info("Element not present");
		}
	}

	public static void click(WebElement element) {
		waitForVisitibilty(element);
		element.click();
	}

	public static void clear(WebElement element) {
		waitForVisitibilty(element);
		element.clear();
	}

	public static void sendKeys(WebElement element, String keyword) {
		waitForVisitibilty(element);
		element.clear();
		element.sendKeys(keyword);
	}

	public static boolean isDisplayed(WebElement element) {
		boolean present = false;
		waitForVisitibilty(element);
		try {
			present = element.isDisplayed();
			log.info(element.getText() + " is dispalyed");
			// return element.isDisplayed();
		} catch (Exception e) {
			log.error("Element not found " + e);
			// log.info(e.getMessage());
		}
		return present;
	}

	public static boolean isElementPresent(WebElement element) {

		waitForVisitibilty(element);
		log.info("element is present:" + element.toString());
		return element.isDisplayed();

	}

	public static String getText(WebElement element) {
		waitForVisitibilty(element);
		return element.getText();
	}

	public static WebElement linkText(WebElement element, String Keyword) {
		waitForVisitibilty(element);
		return element = driver.findElement(By.partialLinkText(Keyword));
	}

	public static String getAttributeValue(WebElement element, String attribute) {
		waitForVisitibilty(element);
		return element.getAttribute(attribute);
	}

	public static void SelectByText(String tagname, String text) {
		log.info("Text=" + text + "\t" + "tagname=" + tagname);
		if (tagname != null) {
			driver.findElement(By.xpath(".//'" + tagname + "'[contains(text(),'" + text + "')]"));
		} else {
			driver.findElement(By.xpath(".//*[contains(text(),'" + text + "')]"));
		}
	}

	public static ElementLoad ElementLoad() {

		try {
			ElementLoaderObj = new ElementLoad();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return ElementLoaderObj;
	}

	public static String[][] getData(String excelname, String sheetName) {
		String[][] data = null;
		try {
			String excelpath = ResourceHelper.getBaseResourcePath() + "\\resources\\excel\\" + excelname;
			log.info("excel path:" + excelpath);
			// System.out.println("excel path:" + excelpath);
			excel = new Excel_Reader(excelpath);
			data = excel.getDataFromSheet(sheetName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	/*
	 * public static String getCellData(String excelname, String sheetName,
	 * String colName, int rowNum) { String data = null;
	 * 
	 * try { String excelpath = ResourceHelper.getBaseResourcePath() +
	 * "\\resources\\excel\\" + excelname; log.info("excel path:" + excelpath);
	 * // System.out.println("excel path:" + excelpath); excel = new
	 * Excel_Reader(excelpath); data = excel.getCellData(sheetName, colName,
	 * rowNum);
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return data;
	 * 
	 * }
	 */

	public static void Select(WebElement element, String visibletext) {
		waitForVisitibilty(element);
		Select oSelect = new Select(element);
		List<WebElement> oSize = oSelect.getOptions();
		int iListSize = oSize.size();
		for (int i = 0; i < iListSize; i++) {
			// Storing the value of the option
			String sValue = oSelect.getOptions().get(i).getText();
			// Printing the stored value
			System.out.println(sValue);
			// Putting a check on each option that if any of the option is equal
			// to 'Africa" then select it
			if (sValue.equals(visibletext)) {
				oSelect.selectByIndex(i);
				break;
			}
		}
	}

	public static WebElement waitElement(String element) {
		String s = element;
		By t1 = By.xpath(s);
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(t1));
		if (ele.isDisplayed())
			return ele;
		else
			log.info("webElement not found");
		return ele;
	}

	public static List<WebElement> waitElements(String element) {
		String s = element;
		By t1 = By.xpath(s);
		List<WebElement> t = driver.findElements(t1);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		List<WebElement> foo = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(t1));
		// .presenceOfAllElementsLocatedBy(t1));
		if (foo.isEmpty())
			log.info("webElement not found");
		else
			return foo;
		System.out.println("size=" + foo.size());
		return foo;
	}

	public static void JavaExecute(WebElement element) {
		waitForVisitibilty(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static int switchFrame(WebDriver driver, By by) {
		int i;
		int framcount = driver.findElements(By.tagName("iframe")).size();
		for (i = 0; i < framcount; i++) {
			driver.switchTo().frame(i);
			int count = driver.findElements(by).size();
			if (count > 0) {
				driver.findElement(by).click();
				break;
			} else {
				System.out.println("count frame" + i);
			}

		}
		driver.switchTo().defaultContent();
		return i;

	}

	public static boolean switchWindow(String title) {
		boolean flag = false;
		String currentWindow = driver.getWindowHandle();
		Set<String> availableWindows = driver.getWindowHandles();
		System.out.println("availableWindows size:" + availableWindows.size());
		try {
			if (!availableWindows.isEmpty()) {
				System.out.println("if is not isEmpty");
				for (String windowId : availableWindows) {
					System.out.println("title of window:" + driver.switchTo().window(windowId).getTitle());
					try {
						String title2 = driver.switchTo().window(windowId).getTitle();

						if (title2.equals(null)) {
							System.out.println("title is Null...");
						}
						if (title2.equals(title)) {
							System.out.println("title matches...");
							flag = true;
							break;

						} else {
							driver.switchTo().window(currentWindow);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("window not available..");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	public static void logout() {
		log.info("**********Logout SourcePros**********");

		test = extent.startTest("Logout SourcePros");
		test.log(LogStatus.INFO, "Logout SourcePros");
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}

	@AfterTest(alwaysRun = true)
	public static void close() {
		try {
			log.info("**********AfterSuite Close Browser**********");
			test = extent.startTest("AfterSuite Close Browser");
			test.log(LogStatus.INFO, "Close close successfully:");
			test.log(LogStatus.INFO, "Driver quite successfully:");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// close the browser
				if (driver != null) {
					driver.close();
					driver.quit();
					LocalDriverFactory.setWebDriver(null);
				}
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}
}
