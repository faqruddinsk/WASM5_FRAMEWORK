package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {//create class for web page 
	//declaration
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//Initialization
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
    //Business library
	public String getContactHeader() {
		return contactHeaderText.getText();
	}
}
