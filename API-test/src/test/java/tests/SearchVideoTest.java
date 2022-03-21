package tests;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.SearchResultPage;
import pages.VideoDetailsPage;

public class SearchVideoTest extends TestBase{
	HomePage homepaeObj;
	SearchResultPage searchObj;
	VideoDetailsPage videoDetailsObj;
	
	@Test
	public void VideoTitleInSearchResulSameAsInDetailsPage() throws InterruptedException, IOException, ParseException {
		
		JsonDataReader jsonReader = new JsonDataReader(); 
		jsonReader.JsonReader();
		
		homepaeObj = new HomePage(driver);
		searchObj = new SearchResultPage(driver);
		videoDetailsObj = new VideoDetailsPage(driver);
		homepaeObj.enterSearchKeyword(jsonReader.searchKeyword);
		searchObj.filterSearchResultByVideoType();
		String videoTitleStr =  searchObj.getVideoTitle(Integer.parseInt(jsonReader.videoNumber));
		searchObj.selectVideo(Integer.parseInt(jsonReader.videoNumber));
		String containerTitle = videoDetailsObj.getContainerTitle();
		Assert.assertEquals(videoTitleStr, containerTitle);
		
	}
}
