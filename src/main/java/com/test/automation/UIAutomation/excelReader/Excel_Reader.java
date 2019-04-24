package com.test.automation.UIAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader
{
	public FileOutputStream fileOut = null;
	public String path=null;
	public FileInputStream fis=null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public Row row=null;
	public Cell cell=null;

	
	//D:\Java_Project\UIAutomation\resources\excel\TestData.xls;
	/**
	 * This Constructor will reading excel sheet.
	 * @param path
	 */
	public Excel_Reader(String path) {
		//this.path = path;
		try {
			System.out.println("path: "+path);
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This Method will return 2D object Data for each record in excel sheet.
	 * 
	 * @param sheetName
	 * @param fileName
	 * @return String[][]
	 */
	@SuppressWarnings({ "deprecation" })
	public String[][] getDataFromSheet(String sheetName) {
		String dataSets[][] = null;
			try {
				// get sheet from excel workbook
				//System.out.println("ExcelName : "+ExcelName);
				//System.out.println("sheetName : "+sheetName);
				 sheet = workbook.getSheet(sheetName);
				// count number of active rows
				int totalRow = sheet.getLastRowNum() + 1;
				//System.out.println("totalRow : "+totalRow);
				// count number of active columns in row
				int totalColumn = sheet.getRow(0).getLastCellNum();
				//System.out.println("totalColumn : "+totalColumn);
				// Create array of rows and column
				dataSets = new String[totalRow - 1][totalColumn];
				// Run for loop and store data in 2D array
				// This for loop will run on rows
				Iterator<Row> rowIterator=sheet.iterator();
				int i=0;
				int t=0;
				while(rowIterator.hasNext())
				{
					 row=rowIterator.next();
					if(i++!=0)
					{
						int k=t;
						t++;
						Iterator<Cell> cellIterator = row.cellIterator();
						int j=0;
						while(cellIterator.hasNext())
						{
							 cell=cellIterator.next();
							
							// Cell cell = sheet.getRow(i).getCell(0);
							
							switch(cell.getCellType())
							{
								
							case Cell.CELL_TYPE_NUMERIC:
								
								  if (DateUtil.isCellDateFormatted(cell))
								  {									 
									  SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
									  String cellText = String.valueOf(dateFormat.format(cell.getDateCellValue()));
									 // System.out.println("Date:"+cellText + "\t\t");
									  dataSets[k][j++] = cellText;		
										/*System.out.println(cellText);
										dataSets[k][j++] = cellText;		
							            System.out.println(cell.getDateCellValue());*/
							            break;
								  }
								  else
								  {
									    Double value = cell.getNumericCellValue();
					                    Long longValue = value.longValue();
					                    String cellText1 = new String(longValue.toString());
					                    dataSets[k][j++] = cellText1;	
									  
									  //String cellText = String.valueOf(cell.getNumericCellValue());// dataSets[k][j++] 
										//System.out.println("Numeric:"+cellText1);
										/*dataSets[k][j++] = cellText;													
							            System.out.println(cell.getNumericCellValue());*/
							            break;
							       }
								
							case Cell.CELL_TYPE_STRING:
								
								dataSets[k][j++]=cell.getStringCellValue();
								//System.out.println("String:"+cell.getStringCellValue());
								break;
						
							case Cell.CELL_TYPE_BOOLEAN:
								
								String cellText1 = new String(new Boolean(
				                        cell.getBooleanCellValue()).toString());				                
								dataSets[k][j++] = cellText1;
								//System.out.println("Boolean:"+cellText1);
								break;
								
								
							case Cell.CELL_TYPE_FORMULA:
								String cellText2=String.valueOf(cell.getStringCellValue());
								dataSets[k][j++]=cellText2;
								//System.out.println("formula:"+cell.getStringCellValue());
								break;	
								
							case Cell.CELL_TYPE_BLANK:
								String cellText3="";
								dataSets[k][j++]=cellText3;
								//System.out.println("blank:"+cell.getStringCellValue());
								break;							
								
							}
						}
					}
				}
				return dataSets;
				
			/*	for (int i = 1; i < totalRow; i++) {
					XSSFRow rows = sheet.getRow(i);
					// This for loop will run on columns of that row
					for (int j = 0; j < totalColumn; j++) 
					{
						// get Cell method will get cell
						XSSFCell cell = rows.getCell(j);
					
						// If cell of type String , then this if condition will work
						if (cell.getCellType() == Cell.CELL_TYPE_STRING)
						{
							dataSets[i - 1][j] = cell.getStringCellValue();
						}
						// If cell of type Number , then this if condition will work
						else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) 
						{
							String cellText = String.valueOf(cell.getNumericCellValue());
							dataSets[i - 1][j] = cellText;
						}
						else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) 
						{
							String cellText = String.valueOf(cell.getBooleanCellValue());
							dataSets[i - 1][j] = cellText;
						}
						else
						{
							// If cell of type boolean , then this if condition will work
							dataSets[i - 1][j] = String.valueOf(cell.CELL_TYPE_ERROR);
						}
					}

				}*/
				
			} catch (Exception e) {
				System.out.println("Exception in reading Xlxs file" + e.getMessage());
				e.printStackTrace();
			}
			return dataSets;
		}


	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int col_Num = 0;
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			XSSFRow row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) 
			{
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					col_Num = i;
					break;
				}
			}
			row = sheet.getRow(rowNum - 1);
			
			XSSFCell cell = row.getCell(col_Num);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
