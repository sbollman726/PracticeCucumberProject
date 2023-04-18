package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.CraterItemsPage;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class itemsManagementSteps {

	LoginPage login = new LoginPage();
	CraterItemsPage itemsPage = new CraterItemsPage();
	CraterCommonPage commonPage = new CraterCommonPage();
	BrowserUtils utils = new BrowserUtils();
	
	String itemName;
	
	@Given("As an entity user, I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
		Driver.getDriver().get(DataReader.getProperty("appurl"));
		login.login();
	}
	
	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() {
		commonPage.itemsLink.click();
		Assert.assertTrue(itemsPage.itemsPageHeaderText.isDisplayed());		
	}
	
	@When("I click on the Add Item button")
	public void i_click_on_the_add_item_button() {
		utils.waitUntilElementVisible(itemsPage.addItemButton);
		itemsPage.addItemButton.click();
	}
	
	@Then("I should be on item input page")
	public void i_should_be_on_item_input_page() {
		utils.waitUntilElementVisible(itemsPage.addItemPageHeaderText);
		Assert.assertTrue(itemsPage.addItemPageHeaderText.isDisplayed());
	}
	
	@When("I provide item information name {string}, price {string}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String name, Integer price, String unit, String description) {
		itemName = name;
		itemsPage.addItemName.sendKeys(name);
		itemsPage.addItemPrice.sendKeys(price.toString());
		itemsPage.addItemUnit.click();
		utils.waitUntilElementVisible(itemsPage.addItem_pc_unit);
		Driver.getDriver().findElement(By.xpath("//span[text()='"+unit+"']")).click();
		itemsPage.addItemDescription.sendKeys(description);
	}
	
	@When("I click Save Item button")
	public void i_click_save_item_button() {
		itemsPage.saveItemButton.click();

	}
	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
		Assert.assertTrue(
				Driver.getDriver().findElement(By.xpath("//a[]text()='"+itemName+"'")).isDisplayed());
	}
	
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Test Case 2 Update**
	
	
	@When("I select the item {string}")
	public void i_select_the_item(String books) {
		itemsPage.bookItem.click();
		System.out.println("1");
	}
	
	@Then("I should be on item details page")
	public void i_should_be_on_item_details_page() {
		Assert.assertTrue(itemsPage.editItemHeaderText.isDisplayed());
		System.out.println("2");
	}
	
	@When("I update the item price to {int} dollars")
	public void i_update_the_item_price_to_dollars(Integer num) {
		utils.waitUntilElementVisible(itemsPage.addItemPrice);
		itemsPage.addItemPrice.clear();
		itemsPage.addItemPrice.sendKeys(num.toString());
		itemsPage.addItemPrice.sendKeys("00");
		itemsPage.addItemUnit.click();
		itemsPage.addItem_dollars_unit.click();
		itemsPage.addItemUnit.click();
		System.out.println("3");
	}
	
	@When("I click Update Item button")
	public void i_click_update_item_button() {
		utils.scrollTo(itemsPage.updateItemButton);
		itemsPage.updateItemButton.click();
	}
	
	@Then("the Item price is updated to {int} dollars")
	public void the_item_price_is_updated_to_dollars(Integer num) {
		String num1 = Driver.getDriver().findElement(By.xpath("//tr[1]/td[3]")).getText();
		Assert.assertTrue(num1.equals(num));
	}
	

	
}
