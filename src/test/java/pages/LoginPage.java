package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy ( name = "email")
	public WebElement emailField;
	
	@FindBy ( name = "password")
	public WebElement passField;
	
	@FindBy ( xpath = "//button[text()='Login']")
	public WebElement LoginBTN;
	
	@FindBy ( xpath = "//h6[text()='Account Settings']")
	public WebElement AccountSettingMess;
}
