package VtigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//step-1: create seperate class for every page 
	
	//step-2: identify the elements by using @findBy,@findBys,@findAll
	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	
	//rule-3: create constructor to initializes
	//Initialization
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
//rule-4: provide getters to access the elements 
	//Utilization
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//step-5: business library 
	/**
	 * this method will login to application with user name and password 
	 * @author shaik
	 * @param username
	 * @param password
	 */
public void loginToApp(String username,String password) {
	userNameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginBtn.click();
}
}
