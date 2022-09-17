package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {//class create for every page
	
	//declaration
@FindBy(xpath="//span[@class='lvtHeaderText']")
private WebElement productHeaderText;

//initialization
public ProductInfoPage(WebDriver driver){
	PageFactory.initElements(driver, this);
}

//utilization
public WebElement getProductHeaderText() {
	return productHeaderText;
}

//business library
public String getproductHeaderText() {
	return productHeaderText.getText();
}

}
