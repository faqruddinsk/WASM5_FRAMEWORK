package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {//create class for every page
	//declaration
@FindBy(name="vendorname")
private WebElement vendornameEdt;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

    //initialization
public CreateNewVendorPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//utilization
public WebElement getVendornameEdt() {
	return vendornameEdt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

//business library
public void vendorName(String vendorname) {
	vendornameEdt.sendKeys(vendorname);
	saveBtn.click();
}
}
