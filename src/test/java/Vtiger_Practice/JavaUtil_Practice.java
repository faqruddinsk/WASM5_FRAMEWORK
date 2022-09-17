package Vtiger_Practice;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;

public class JavaUtil_Practice {
	public static void main(String[] args) throws Throwable {
		
	
	JavaUtility jlib=new JavaUtility();

	System.out.println(jlib.getRandomNumber());
	
	System.out.println(jlib.getSystemDate());
	
	System.out.println(jlib.getSystemDateInFormat());
	
	
	PropertyFileUtility plib=new PropertyFileUtility();
	
	//String b = plib.readDataFromPropertyFile("browser");
	System.out.println(plib.readDataFromPropertyFile("browser"));
	//System.out.println(b);
	
	ExcelFileUtility elib=new ExcelFileUtility();
	
	//System.out.println(elib.getRowCount("Products"));
	//String data = elib.readDataFromExcel("Organization", 1, 2);
	elib.writeDataIntoExcel("Organization", 0, 9, "haihalo");
	//System.out.println(data);
}
}