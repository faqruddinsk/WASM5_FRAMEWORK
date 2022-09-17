package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {//step-1: create class for every page
	
	//step-2: declaration 
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewOrgLookUpimg;
	
	//step-3 : initialization
	public OrganizationsPage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	//step-4: utilization
	public WebElement getCreateOrgLookUpimg() {
		return createNewOrgLookUpimg;
	}
	
	//business library
	public void clickOnCreateNewOrgImg() {
		createNewOrgLookUpimg.click();
	}
	

}
