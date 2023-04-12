package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.DataReader;
import utilities.Driver;

public class UserManagementSteps {
	
	LoginPage loginPage = new LoginPage();

	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		Driver.getDriver().get(DataReader.getProperty("appurl"));
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		loginPage.emailField.sendKeys(DataReader.getProperty("username"));
		loginPage.passField.sendKeys(DataReader.getProperty("password"));
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		loginPage.LoginBTN.click();
	}

	@Then("I see the dashboard page")
	public void i_see_the_dashboard_page() {
		Assert.assertTrue(loginPage.AccountSettingMess.isDisplayed());
	}

	@When("I enter an invalid username and password")
	public void i_enter_an_invalid_username_and_password() {
		loginPage.emailField.sendKeys(DataReader.getProperty("username"));
		loginPage.passField.sendKeys(DataReader.getProperty("invalidpass"));
	}

	@Then("I see an error message")
	public void i_see_an_error_message() {
		Alert letsHandle = Driver.getDriver().switchTo().alert();
		String errorMess = letsHandle.getText();
		Assert.assertTrue(!errorMess.isBlank());
	}

	@Then("I am not logged in")
	public void i_am_not_logged_in() {
		Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(DataReader.getProperty("appurl")));
	}
	
	
}
