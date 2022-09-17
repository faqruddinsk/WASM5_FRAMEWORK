package Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;
import VtigerObjectRepository.CreateNewOrganizationPage;
import VtigerObjectRepository.HomePage;
import VtigerObjectRepository.LoginPage;
import VtigerObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithChemicalIndustry {
	public static void main(String[] args) throws Throwable {
		
	WebDriver driver=null;
	//create object utilities 
			JavaUtility jUtil=new JavaUtility();
			PropertyFileUtility pUtil=new PropertyFileUtility();
			ExcelFileUtility eUtil=new ExcelFileUtility();
			WebDriverUtility wUtil=new WebDriverUtility();
			
			
			//read all required data
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String URL = pUtil.readDataFromPropertyFile("url");
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");
			
			String INDUSTRY = eUtil.readDataFromExcel("Organization", 7, 3);
			String ORGNAME = eUtil.readDataFromExcel("Organization", 7, 2);
		
			//launch the browser
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
			
			//navigate to organization
			HomePage hp=new HomePage(driver);
			hp.getOrganizationslink();
			//click on create organization link
			OrganizationsPage orp=new OrganizationsPage(driver);
			orp.clickOnCreateNewOrgImg();
			//create new organization with industry
			CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
			cop.craeteNewOrg(ORGNAME, INDUSTRY);
			
			
			
}
}