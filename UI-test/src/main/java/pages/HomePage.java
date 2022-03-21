package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id = 'search']")
	WebElement searchTxtbox;
	@FindBy(xpath = "//*[@id='search-icon-legacy']")
	WebElement searchBtn;
	
	public void enterSearchKeyword(String searchKeyword) throws InterruptedException {
		setTextElementText(searchTxtbox, searchKeyword);
		//Thread.sleep(1000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		clickButton(searchBtn);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(searchKeyword));
	}
}
