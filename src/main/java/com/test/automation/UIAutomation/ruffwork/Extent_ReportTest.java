package com.test.automation.UIAutomation.ruffwork;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Extent_ReportTest extends BaseTest {
	// static WebDriver driver;

	private EventFiringWebDriver driver = null;

	@Test
	public void foo() throws WebDriverException, IOException {
		driver.get("http://www.google.com");
		// Now lets trigger an exception by looking for a Non Existing element.
		driver.findElement(By.name("foo")).click();
	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
		RemoteWebDriver rwd = new RemoteWebDriver(new URL("http://192.168.1.72:4444/wd/hub"), dc);
		driver = new EventFiringWebDriver(rwd);
		driver.register(new MyEventListener());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public static class MyEventListener extends AbstractWebDriverEventListener {

		@Override
		public void onException(Throwable throwable, WebDriver driver) {
			System.out.println("Exception was triggered");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Calendar cal = Calendar.getInstance();
			String time = "" + dateFormat.format(cal.getTime());
			super.onException(throwable, driver);
			WebDriver wd = new Augmenter().augment(driver);
			File source = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File(
						"C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\New folder\\" + time + "test.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void getIframe(WebDriver driver, String id) {
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		int framSize = iframes.size();
		if (framSize > 0) {
			for (WebElement iframe : iframes) {
				if (iframe.getAttribute("id").equals(id)) {
					driver.switchTo().frame(iframe);
				}
			}
		} else {
			System.out.println("No Frame available");
		}
	}

	/*
	 * @Test(groups = { "Regression" }) public void test2() throws IOException {
	 * // try { System.out.println("testng 2"); test = extent.createTest(
	 * "test2 started"); test.info("testng 2"); Assert.assertEquals(false,
	 * true); // } catch (Exception e) {
	 * 
	 * ExtentUtil.fetchTest().log(Status.FAIL,e.getMessage());
	 * ExtentUtil.fetchTest().info("Failed test cases",
	 * MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot().
	 * getAbsolutePath().toString()).build()); e.printStackTrace(); // } }
	 * 
	 * @Test(groups = { "Smoke" }) public void test3() throws IOException { //
	 * try { System.out.println("testng 3"); test = extent.createTest("testng 3"
	 * ); test.log(Status.INFO, "Google is opened");
	 * 
	 * ExtentUtil.fetchTest().info("testng 3" ); Assert.assertEquals(true,
	 * true);
	 * 
	 * // } catch (Exception e) {
	 * 
	 * ExtentUtil.fetchTest().log(Status.FAIL,e.getMessage());
	 * ExtentUtil.fetchTest().info("Failed test cases",
	 * MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot().
	 * getAbsolutePath().toString()).build()); e.printStackTrace();
	 * 
	 * // } }
	 * 
	 * @Test(groups = { "Smoke" }) public void test4() throws IOException { //
	 * try { ExtentUtil.fetchTest().info("testng 4"); Assert.assertEquals(false,
	 * true); // } catch (Exception e) {
	 * 
	 * ExtentUtil.fetchTest().log(Status.FAIL,e.getMessage());
	 * ExtentUtil.fetchTest().info("Failed test cases",
	 * MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot().
	 * getAbsolutePath().toString()).build()); e.printStackTrace(); // } }
	 */

}
