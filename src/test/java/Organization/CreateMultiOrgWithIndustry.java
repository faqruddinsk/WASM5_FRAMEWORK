package Organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Vtiger.GenericUtility.BaseClass;
import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;
import VtigerObjectRepository.CreateNewOrganizationPage;
import VtigerObjectRepository.HomePage;
import VtigerObjectRepository.LoginPage;
import VtigerObjectRepository.OrganizationInfoPage;
import VtigerObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMultiOrgWithIndustry extends BaseClass {
	
	//create objects of all utilities 
	/*JavaUtility jUtil=new JavaUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	WebDriver driver=null;*/
	
@Test(dataProvider = "OrgName")
public void createMutliOrgTest(String OrgName,String IndustryType) throws Throwable {
	
	//read the required data
/*	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME= pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	String OrgN = OrgName+jUtil.getRandomNumber();
	
//launch the browser
if(BROWSER.equalsIgnoreCase("CHROME")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	System.out.println("Chrome was launched ");
}
else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	System.out.println("firefox was launched");
}
else {
	System.out.println("Invalid browser Name");
}
wUtil.maximiseWin(driver);
wUtil.waitForPageLoad(driver);
driver.get(URL);

//login to application
LoginPage lp=new LoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);*/
	
	
	


//navigate to organization
HomePage hp=new HomePage(driver);
hp.getOrganizationslink();

//click on create organization link
OrganizationsPage op=new OrganizationsPage(driver);
op.clickOnCreateNewOrgImg();

//create new organization with industry
CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
cop.craeteNewOrg(OrgName, IndustryType);

//validate
OrganizationInfoPage oip=new OrganizationInfoPage(driver);
String OrgHeaderTxt = oip.getOrgHeader();

//Assert.assertTrue(OrgHeaderTxt.contains(OrgName));
if(OrgHeaderTxt.contains(OrgName)) {
	System.out.println("Pass");
}else {
	System.out.println("fail");
}
}

 @DataProvider(name = "getData")
public Object[][] getData() throws EncryptedDocumentException, IOException 
{
	return eUtil.readMultipleDataFromExcel("MultiOrg");
}

}
