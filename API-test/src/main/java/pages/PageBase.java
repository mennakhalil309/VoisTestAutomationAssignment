package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver driver;
	public Select select;
	public Actions action;
	WebDriverWait wait;
	public JavascriptExecutor jse;
	
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	protected static void clickButton(WebElement button) {
		button.click();
	}
//	protected static void jsClickElement(WebElement element) {
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", element);
//	}
	
	protected static void setTextElementText(WebElement txtElement, String value) {
		txtElement.sendKeys(value);
	}
	public void clearText(WebElement element) 
	{
		element.clear();
	}

}
