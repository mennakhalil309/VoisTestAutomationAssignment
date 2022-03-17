package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoDetailsPage extends PageBase{

	public VideoDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"container\"]/h1/yt-formatted-string")
	WebElement videoTitleTxt;
	
	public String getContainerTitle() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(videoTitleTxt));
		return videoTitleTxt.getText();
	}
}
