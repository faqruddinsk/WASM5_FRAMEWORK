package Vtiger.GenericUtility;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelFileUtility {
		
		public String readDataFromExcel(String sheetname, int rownum, int cellnum) throws Throwable
		{
			FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheetname);
			Row r = s.getRow(rownum);
			Cell cel = r.getCell(cellnum);
			String value = cel.getStringCellValue();
			wb.close();
			return value;
			
			 // return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
	 }
		
		public String excelNumericValue(String sheetname, int rownum, int cellnum) throws Throwable
		{
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Cell cell = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum);
			long value = (long) cell.getNumericCellValue();
			wb.close();
			return String.valueOf(value);	
		}
		/**
		 * This method will give the last row number in particular sheet
		 * @param sheet
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public  int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			 Sheet s = wb.getSheet(sheet);
			int lastRow = s.getLastRowNum();
			wb.close();
			return lastRow;
	}
		
		/**
		 * This method is used to insert data into particular sheet in Excel file
		 * @param sheet
		 * @param row
		 * @param cel
		 * @param value
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public void writeDataIntoExcel(String sheet ,int row,int cel,String value) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath); 
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheet);
				Row r = sh.getRow(row);
				Cell cle = r.createCell(cel);
				 cle.setCellValue(value);
				
			FileOutputStream fos=new FileOutputStream(ConstantsUtility.ExcelFilePath);
			wb.write(fos);
			wb.close();
		}
		
		/**
		 * This method is used to execute test script with multiple data 
		 * hence it will return 2 dimensional Object[][] so that it can direct used in data provider 
		 * @param sheetName
		 * @return
		 * @throws IOException 
		 * @throws EncryptedDocumentException 
		 */
		
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
			FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int lastRow = sh.getLastRowNum();
			int lastCell = sh.getRow(0).getLastCellNum();
			Object[][] data=new Object[lastRow][lastCell];
			for(int i=0;i<lastRow;i++) 
			{
				for(int j=0;j<lastCell;j++) 
				{
					data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			return data;	
		}
    }

