package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility{//step-1 : create class for every page 
	
	//step-2: declaration
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//Initialization
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    //utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	//business library
	/*
	 * This method will get the header text for organization
	 */
	public String getOrgHeader() {
		String orgHeader=OrgHeaderText.getText();
		return orgHeader;
		
	}
}
