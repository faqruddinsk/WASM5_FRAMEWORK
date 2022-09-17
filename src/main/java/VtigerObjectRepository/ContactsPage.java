package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//create new class for every page
	//declaration
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewContLookUpimg;
	
	//initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
   //utilization
	public WebElement getCreateNewContLookUpimg() {
		return createNewContLookUpimg;
	}
	
	//business library
	public void clickOnCreateNewContImg() {
		createNewContLookUpimg.click();
	}

}
