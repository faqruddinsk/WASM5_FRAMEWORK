package Products;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;
import VtigerObjectRepository.CreateNewProductPage;
import VtigerObjectRepository.CreateNewVendorPage;
import VtigerObjectRepository.HomePage;
import VtigerObjectRepository.LoginPage;
import VtigerObjectRepository.ProductInfoPage;
import VtigerObjectRepository.ProductsPage;
import VtigerObjectRepository.VendorsInfoPage;
import VtigerObjectRepository.VendorsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProdutWithVendor {
    @Test
public void createProductWithVendor()  throws Throwable {

	Random r=new Random();
	int RANDOM = r.nextInt(1000);
	WebDriver driver=null;
	//create objects utility
	JavaUtility jUtil=new JavaUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	//read all required data 
String BROWSER = pUtil.readDataFromPropertyFile("browser");
String URL = pUtil.readDataFromPropertyFile("url");
String USERNAME = pUtil.readDataFromPropertyFile("username");
String PASSWORD = pUtil.readDataFromPropertyFile("password");

String vendorname = eUtil.readDataFromExcel("Products", 4, 3);
String productname = eUtil.readDataFromExcel("Products", 4, 2);

//launch browser
if(BROWSER.equalsIgnoreCase("CHROME")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
else {
	System.out.println("Invalid browser Name");
}
wUtil.maximiseWin(driver);
wUtil.waitForPageLoad(driver);
driver.get(URL);

//login to application

LoginPage lp=new LoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);

//Navigate to more 
HomePage hp=new HomePage(driver);
hp.clickOnMoreLink();
hp.clickOnVendorLink();

//navigate to vendor
VendorsPage vp=new VendorsPage(driver);
vp.clickOnNewVendorImg();

//create new vendor
CreateNewVendorPage cnv=new CreateNewVendorPage(driver);
cnv.vendorName(vendorname+RANDOM);

//validate
VendorsInfoPage vip=new VendorsInfoPage(driver);
String vendorHeaderText = vip.getVendorHeadText();

if(vendorHeaderText.contains(vendorname+RANDOM)) {
	System.out.println("---vendor created sucessfully---");
}else {
	System.out.println("---vendor Not created----");
}

//navigate TO PRODUCTS MODULE
hp.clickOnProductLink();

//click on create new product
ProductsPage cpi=new ProductsPage(driver);
cpi.ClickOnCreateProductImg();

//create product with vendor
CreateNewProductPage cnp=new CreateNewProductPage(driver);
cnp.createNewProduct(productname+RANDOM, vendorname+RANDOM, driver);

//validate
ProductInfoPage pip=new ProductInfoPage(driver);
String productHeaderText = pip.getproductHeaderText();
if(productHeaderText.contains(productname+RANDOM)) {
	System.out.println("---pass---");
}else {
	System.out.println("---Fail----");
}

hp.signOutOfApp(driver);
}
}
