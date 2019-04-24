package com.test.automation.UIAutomation.errorScreenShot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import com.test.automation.UIAutomation.testBase.TestBase;
import com.test.automation.UIAutomation.utility.DateTimeHelper;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class ErrorScreenShot extends TestBase {

	/**
	 * This Method will return screen capture path.
	 * 
	 * @param methodname
	 * @param imageExtension
	 * @param folderName
	 * @return path 
	 */
	
	public static String getScreenShot(String methodname, String imageExtension, String folderName) {
		String dest = null;
		File destFile = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/resources/ScreenShots/" + folderName;
			System.out.println("image path:" + (String) reportDirectory + "_" + methodname + "_"
					+ DateTimeHelper.getCurrentDateTime() + imageExtension);
			log.info((String) reportDirectory + "_" + methodname + "_" + DateTimeHelper.getCurrentDateTime()
					+ imageExtension);
			dest = (String) reportDirectory + "_" + methodname + "_" + DateTimeHelper.getCurrentDateTime()
					+ imageExtension;
			log.info("Dest=" + dest);
			destFile = new File((String) reportDirectory + "_" + methodname + "_" + DateTimeHelper.getCurrentDateTime()
					+ imageExtension);
			System.out.println("reportDirectory:" + reportDirectory);
			FileUtils.copyFile(scrFile, destFile);
			log.info("image path : " + destFile.getAbsolutePath());
			log.info("Take screenshot completed");
			return dest;
		} catch (Exception e) {
			log.error(e.getMessage());
			System.out.println("ErrorScreenShot(class)->getScreenShot(method) error:" + e.getMessage());
		}
		return dest;
	}

	/*public static File getScreenShotEntire(String methodname, String imageExtension, String folderName) {
		File dest=null;
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/resources/ScreenShots/" + folderName;
			Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000))
					.takeScreenshot(driver);
			BufferedImage image = screenshot.getImage();
			 dest = new File((String) reportDirectory + "_" + methodname + "_" + DateTimeHelper.getCurrentDateTime()
				+ imageExtension);
			ImageIO.write(image, "PNG", dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest;
	}*/

}
