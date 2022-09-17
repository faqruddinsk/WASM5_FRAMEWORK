package V_tiger;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData_From_ExcelFile {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
    // step -1 : load the location of the file to the file input stream
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	
	//step-2 : create  a work book 
	Workbook wb = WorkbookFactory.create(fis);
	
	//step-3: get into sheet
	Sheet sh = wb.getSheet("Organization");
	
	//step-4 : get into row
	Row rw = sh.getRow(4);
	//step-5: get into cell
	Cell cl = rw.getCell(2);
	
	//step-6 : read the value present in the cell
	String value = cl.getStringCellValue();
	System.out.println(value);
	
}
}
