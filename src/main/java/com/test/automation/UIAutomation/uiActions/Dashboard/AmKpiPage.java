package com.test.automation.UIAutomation.uiActions.Dashboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.testBase.TestBase;

public class AmKpiPage extends TestBase {
	public static Logger log = Logger.getLogger(AmKpiPage.class.getName());

	public WebElement dropDownKPITYPE(String kpi) {
		log.info("KPI option:" + kpi);
		return driver.findElement(By.xpath("//select[@id='KPIType']/option[contains(text(),'" + kpi + "')]"));
	}

	public WebElement dropDownAccountManager(String manager) {
		log.info("manager option:" + manager);
		return driver.findElement(By.xpath("//select[@id='AMUsers']/option[contains(text(),'" + manager + "')]"));
	}

	public WebElement dropDownYear(String year) {
		log.info("year option:" + year);
		return driver.findElement(By.xpath("//select[@id='Year']/option[contains(text(),'" + year + "')]"));
	}

	public WebElement dropDownByMonth(String month) {
		log.info("month option:" + month);
		return driver.findElement(By.xpath("//select[@id='Monthly']/option[contains(text(),'" + month + "')]"));
	}

	public WebElement dropDownByQuater(String quater) {
		log.info("quater option:" + quater);
		return driver.findElement(By.xpath("//select[@id='Quarterly']/option[contains(text(),'" + quater + "')]"));
	}

	public WebElement dropDownByYear(String yearly) {
		log.info("yearly option:" + yearly);
		return driver.findElement(By.xpath("//select[@id='Yearly']/option[contains(text(),'" + yearly + "')]"));
	}

	public static void getMonthData() throws FileNotFoundException, IOException
	{
		log.info("get month Data display");
		//List<WebElement> rows = driver.findElements(By.xpath("//div[@id='dynamictable']/table/tbody/tr"));
		List<WebElement> rowslist = waitElements("//div[@id='dynamictable']/table/tbody/tr");
		log.info("Rows Size"+rowslist.size());
		System.out.println("Rows size:"+rowslist.size());
		//List<String,Integer> list = new ArrayList<>();
		//add some stuff	
		/*FileOutputStream outFile = new FileOutputStream(new File("C:\\Users\\yogeshsolanki\\Desktop\\Excel\\demo.xlsx"));
	 	XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("AMI KPI");*/
		for(int rows=0;rows<=rowslist.size();rows++)
		{			
			List<WebElement> colmns = waitElements("//div[@id='dynamictable']/table/tbody/tr['"+rows+"']/td");
			log.info("colmns Size"+colmns.size());
			//System.out.println("colmns size:"+colmns.size());
			//dataSets = new String[rowslist.size()][colmns.size()];
			for(int col=0;col<colmns.size();col++)
			{	 
				log.info(colmns.get(col).getText()+" ");
				try {
					
					System.out.println("done");
					/*workbook.write(outFile);
					outFile.close();*/
					break;
					}
			catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void writeExcel() throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("AMI KPI");

		Object[][] bookData = { { "Head First Java", "Kathy Serria", 79 }, { "Effective Java", "Joshua Bloch", 36 },
				{ "Clean Code", "Robert martin", 42 }, { "Thinking in Java", "Bruce Eckel", 35 }, };

		int rowCount = 0;
		for (Object[] aBook : bookData) {
			Row row = sheet.createRow(++rowCount);

			int columnCount = 0;

			for (Object field : aBook) {
				Cell cell = row.createCell(++columnCount);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

		}

		try (FileOutputStream outputStream = new FileOutputStream(
				"C:\\Users\\yogeshsolanki\\Desktop\\Excel\\JavaBooks.xlsx")) {
			workbook.write(outputStream);
		}
	}

}
