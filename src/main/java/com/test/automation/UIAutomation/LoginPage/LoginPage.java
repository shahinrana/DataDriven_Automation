package com.test.automation.UIAutomation.LoginPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.UIAutomation.config.ElementLoad;
import com.test.automation.UIAutomation.testBase.TestBase;

public class LoginPage extends TestBase
{
	public static Logger log = Logger.getLogger(LoginPage.class.getName());
	public static String jsb;

	//excelReader er = excelReader();
	
	@FindBy(how = How.XPATH, using = "//form[@id='frmlogin']/div/h1")
	public static WebElement JobSeekerLoginbtn;

	 static WebElement assertErrormesg;
	
	@FindBy(how = How.XPATH, using = "//span[starts-with(text(),'Welcome')]")
	private static WebElement welcomestring;
	

	
	//*[@id="userProfile"]/div[3]/div[1]/span/a[2]

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public static boolean loginToApplication(String username, String password) {

		try {
			
			// test=extent.startTest(jsb);
			WebElement txtbx_UserName = ElementLoad.getWebElement("username",loginPropertyFile);
			System.out.println("username:"+txtbx_UserName.toString());
			sendKeys(txtbx_UserName, username);
			log.info(txtbx_UserName.toString());
			// test=extent.startTest(jsb);
			
			WebElement txtbx_Password = ElementLoad.getWebElement("password",loginPropertyFile);
			//sendKeys(txtbx_UserName, username);
			System.out.println("Password:"+txtbx_Password.toString());
			
			sendKeys(txtbx_Password, password);
			log.info(txtbx_Password.toString());

			// test=extent.startTest(jsb);
			WebElement btn_SingIn = ElementLoad.getWebElement("submitbutton",loginPropertyFile);
			click(btn_SingIn);
			jsb = "SignIn button clicked" + btn_SingIn.toString();
			log.info("jsb:"+jsb);
			//driver.findElement(By.xpath("//*[@id='cboxClose']")).click();
			log.info("welcomestring:" + welcomestring.toString());
			return isElementPresent(welcomestring);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return isElementPresent(welcomestring);

	}

	public String asserterrormesag() {
		try {
			assertErrormesg=ElementLoad.getWebElement("assertErrormesg",loginPropertyFile);
			log.info("Error message is " + assertErrormesg.getText()+" xpath is:"+assertErrormesg.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return getText(assertErrormesg);

	}

	public void verifyInvalidLogin(String invalidErrorMessage) {
		Assert.assertEquals(asserterrormesag(), invalidErrorMessage);
		// return true;
	}

	public boolean verifyLogOutSuccess() {

		log.info("Login button display:" + JobSeekerLoginbtn.toString());
		return isElementPresent(JobSeekerLoginbtn);

	}

}
