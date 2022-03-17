package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends PageBase {

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"container\"]/ytd-toggle-button-renderer")
	WebElement filterBtn;
	@FindBy(xpath = "//*[@id=\"collapse-content\"]/ytd-search-filter-group-renderer[2]/ytd-search-filter-renderer[1]")
	WebElement videoTypeFilterBtn;
	@FindBy(xpath = "//*[@id=\"video-title\"]/yt-formatted-string")
	List<WebElement> resultsList;
	@FindBy(xpath = "//iron-collapse[@id='collapse']S")
	WebElement filterCollapseWindow;
	@FindBy(xpath = "//ytd-item-section-renderer[@class='style-scope ytd-section-list-renderer']")
	WebElement serachResultContainer;
	
	public void filterSearchResultByVideoType() {

		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", filterBtn);
		
		action = new Actions(driver);
		action.moveToElement(videoTypeFilterBtn).click().perform();
	//	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//	wait.until(ExpectedConditions.visibilityOf(filterCollapseWindow));
	//	clickButton(videoTypeFilterBtn);
	}

	public void selectVideo(int videoNumber) {
		resultsList.get(videoNumber).click();
	}
	public String getVideoTitle(int videoNumber) {
		return resultsList.get(videoNumber).getText();
	}
}
