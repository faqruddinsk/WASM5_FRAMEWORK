package V_tiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_Customer_VTiger {
public static void main(String[] args) throws IOException {
	WebDriver driver = null;
	Random r=new Random();
	int RANDOM = r.nextInt(1000);
	//read common-data from property file 
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	Properties pobj=new Properties();
	pobj.load(fisp);
	String BROWSER = pobj.getProperty("browser");
	String URL = pobj.getProperty("url");
	String USERNAME = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");
	
	
	//get test data from Excel sheet
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fise);
	Sheet sh = wb.getSheet("Contact");
	Row rw = sh.getRow(1);
	Cell cel = rw.getCell(2);
	String CUSTNAME = cel.getStringCellValue();
	
	
	
	//step-1 launching the V-Tiger
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		System.out.println("----chrome launched sucessfully-----");
	}
	else {
		System.out.println("---invalid browser");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(URL);
	
	
	
	//step-2 : login to v-Tiger
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	//step-3: Navigation to contacts link
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	
	//step-4: Adding new contact
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(CUSTNAME+RANDOM);
	
	//step-5: saving the customer data
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	//STEP-6 logout from V-Tiger
	WebElement element=driver.findElement(By.xpath("(//img[@border='0'])[3]"));
	Actions act =new Actions(driver);
	act.moveToElement(element).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.close();
}
}
