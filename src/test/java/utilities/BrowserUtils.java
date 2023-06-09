package utilities;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

	
	Actions action;
	WebDriverWait wait;
	Select letsSelect;
	JavascriptExecutor js;
	
	// waits for an element to be visable 
	public void waitUntilElementVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	// send keys via actions class to the field that is not interactable 
	public void actionsSendKeys(WebElement element, String txt) {
		action = new Actions(Driver.getDriver());
		action.sendKeys(element, txt).build().perform();
	}
	
	// select by visible text
	public void selectByVisibleText(WebElement element, String tobeSelectedOptionText) {
		letsSelect = new Select(element);
		letsSelect.selectByVisibleText(tobeSelectedOptionText);
	}
	
	// return the selected option from dropdown
	public String getSelectedOption (WebElement selectElement) {
		letsSelect = new Select(selectElement);
		return letsSelect.getFirstSelectedOption().getText();	
	}
	
	// scroll to given element
	public void scrollTo(WebElement element) {
		js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);	
	}
	
	public int randonNumber() {
		Random randy = new Random();
		int randomNum = randy.nextInt((999 - 100) + 1) + 100;
		return randomNum;
	}
	
	
	
	
}
