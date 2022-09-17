package V_tiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateElectronicsInvester {
public static void main(String[] args) throws IOException {
	WebDriver driver;
	Random r=new Random();
	int RANDOM = r.nextInt(1000);
	//read common data from property file
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	Properties pobj=new Properties();
	pobj.load(fisp);
	String BROWSER = pobj.getProperty("browser");
	String URL = pobj.getProperty("url");
	String USERNAME = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");
	
	//READ the Test-data from Excel sheet
	
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fise);
	Sheet sh = wb.getSheet("Organization");
	Row rw = sh.getRow(1);
	Cell cel = rw.getCell(2);
    String ORGNAME = cel.getStringCellValue();
	
	//step-1 Launching V-Tiger
    if(BROWSER.equalsIgnoreCase("chrome")) {
    	System.out.println("---chrome launched sucessfully----");
    	driver=new ChromeDriver();
    }

    else if(BROWSER.equalsIgnoreCase("firefox")) {
    	System.out.println("----firefox launched sucessfully----");
    	driver=new FirefoxDriver();
    	
    	
    }
    else {
    	System.out.println("----invalid browser----");
    	driver=new ChromeDriver();
    	System.out.println("----chrome launched sucessfully----");
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    driver.get(URL);
    
    
	//step-2 login into V-Tiger
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//step-3 navigate to organization
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	//step-4 create organization
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME+RANDOM);
	driver.findElement(By.xpath("//option[@value='Electronics']")).click();
	driver.findElement(By.xpath("//option[@value='Investor']")).click();
	
	
	//step-5 save and logout
	//driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
	WebElement element=driver.findElement(By.xpath("(//img[@border='0'])[3]"));
	Actions act =new Actions(driver);
	act.moveToElement(element).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.close();
}
}
