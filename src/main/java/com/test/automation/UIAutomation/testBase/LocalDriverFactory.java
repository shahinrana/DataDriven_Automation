package com.test.automation.UIAutomation.testBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.test.automation.UIAutomation.utility.ResourceHelper;

public class LocalDriverFactory extends TestBase {
	public static Logger log = Logger.getLogger(LocalDriverFactory.class.getName());
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private static WebDriver driver = null;

	private LocalDriverFactory() {
	}

	public static void initilize(String browser) {
		WebDriver dr = LocalDriverFactory.createInstance(browser);
		setWebDriver(dr);

	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = webDriver.get();
		} else {
			System.out.println("driver is already assigned..");
		}
		return driver;
	}

	public static void setWebDriver(WebDriver driver) {
		webDriver.set(driver);
	}

	public static WebDriver createInstance(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = initChromeDriver();
			log.info("chrome browser");
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = initFirefoxDriver();
			log.info("firefox browser");
		}
		if (browserName.equalsIgnoreCase("ie")) {
			driver = initIEDriver();
			log.info("IE browser");
		}
		if (browserName.equalsIgnoreCase("phantom")) {
			driver = initPhantom();
			log.info("Phantom browser");
		} else
			log.info("browser is invalid, browser of choice..");
		System.out.println("invalid browser type");

		return driver;
	}

	private static WebDriver initPhantom() {
		System.setProperty("phantomjs.binary.path",
				ResourceHelper.getResourcePath("\\resources\\drivers\\phantomjs.exe"));
		return driver = new PhantomJSDriver();
	}

	private static WebDriver initChromeDriver() {

		try {
			
			DesiredCapabilities dc = new DesiredCapabilities();
			ChromeOptions options = new ChromeOptions();
			dc.setCapability(ChromeOptions.CAPABILITY, options);
			options.setCapability(ChromeOptions.CAPABILITY, true);
			 options.addArguments("disable-infobars");
			options.merge(dc);
			    //driver = new ChromeDriver(options);
			//dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
			//
			driver = new RemoteWebDriver(new URL(Config.getProperty("hub")), options);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	private static WebDriver initFirefoxDriver() {

		try {
			FirefoxOptions options = new FirefoxOptions();
			ProfilesIni profileini = new ProfilesIni();
			FirefoxProfile profile = profileini.getProfile("default");
			DesiredCapabilities dc = new DesiredCapabilities();
			profile.setPreference("network.proxy.type", 0);
			// options.addArguments("start-maximized");
			options.setCapability(FirefoxDriver.PROFILE, profile);
			options.merge(dc);
			//dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
			driver = new RemoteWebDriver(new URL(Config.getProperty("hub")), options);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	private static WebDriver initIEDriver() {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			dc.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, false);
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			dc.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			dc.setCapability("allow-blocked-content", true);
			dc.setCapability("allowBlockedContent", true);
			dc.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
			// dc.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(Config.getProperty("hub")), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

}
