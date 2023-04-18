package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CraterItemsPage {

	
	public CraterItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	
	@FindBy ( xpath = "//h3[text()='Items']")			//h3[text()='Items']
	public WebElement itemsPageHeaderText;
	
	@FindBy ( xpath = "//button[text()=' Add Item']")
	public WebElement addItemButton;
	
	@FindBy ( xpath = "//h3[text()='New Item']")
	public WebElement addItemPageHeaderText;
	
						//label[text()='Price ']
	@FindBy ( xpath = "(//input[@type='text'])[2]")
	public WebElement addItemName;
	
	@FindBy ( xpath = "//div[text()='Price ']//parent::label//following-sibling::div/input")
	public WebElement addItemPrice;
	
	@FindBy ( xpath = "//input[@class='w-full absolute inset-0 outline-none appearance-none box-border border-0 text-sm font-sans bg-white rounded-md pl-3.5']") 	//div[text()='select unit']//preceding::input[1]
	public WebElement addItemUnit;
	
	@FindBy ( xpath = "//span[text()='pc']")
	public WebElement addItem_pc_unit;
	
	@FindBy ( name = "description")
	public WebElement addItemDescription;
	
	@FindBy ( xpath = "//button[text()=' Save Item']")
	public WebElement saveItemButton;
	
	@FindBy ( xpath = "//a[@href='/admin/items/47/edit']")
	public WebElement bookItem;
	
	@FindBy ( xpath = "//h3[text()='Edit Item']")
	public WebElement editItemHeaderText;
	
	@FindBy ( xpath = "//span[text()='Dollars']")
	public WebElement addItem_dollars_unit;
	
	@FindBy ( xpath = "//button[@type='submit']")
	public WebElement updateItemButton;
	
	
}
