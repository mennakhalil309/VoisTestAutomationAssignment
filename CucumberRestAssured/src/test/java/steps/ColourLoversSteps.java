package steps;



import static io.restassured.RestAssured.given;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ColourLoversSteps {
	
	private static String BASE_URL;
	RequestSpecification request;
	private  static  Response response;
	private static String responseStr;
	
	@Given("^User set GET colour patterns endpoint$")
	public void user_want_to_execute_GET_colour_patterns_endpoint() throws Throwable {
		BASE_URL = "http://www.colourlovers.com/api/patterns";
	    System.out.println("GET URL: "+BASE_URL);
	}

	@Given("^User set request header$")
	public void user_submit_GET_request() throws Throwable {
	   RestAssured.baseURI = BASE_URL;
	   request = RestAssured.given();
//	   request.header("Host",  "developer.mozilla.org");
	   request.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36");
	}
	@When("^User submit GET request to colour lovers$")
	public void submit_GET_request() throws Throwable {
		response=given().when().get(BASE_URL).then().extract().response();
        System.out.println("Response: " + response.toString());
	}

	@Then("^User should receive valid status code (\\d+)$")
	public void user_should_get_success_status_code(int arg1) throws Throwable {
		Assert.assertEquals(response.statusCode(), arg1); 
	}

	@When("^User Get colour pattern$")
	public void user_Get_colour_pattern() throws Throwable {
		responseStr = given().contentType(ContentType.JSON).when().get(BASE_URL)
				.then().extract().body().asString();
        System.out.println(responseStr);
        	}

	@Then("^Verify numViews greater than (\\d+)$")
	public void verify_numViews_greater_than(int arg1) throws Throwable {
		
		DocumentBuilderFactory factory =
        		DocumentBuilderFactory.newInstance();
        		DocumentBuilder builder = factory.newDocumentBuilder();
        		ByteArrayInputStream input = new ByteArrayInputStream(
        				responseStr.getBytes("UTF-8"));
        				Document doc = builder.parse(input);
        				doc.getDocumentElement().normalize();
        				 NodeList nList = doc.getElementsByTagName("pattern");
        				
        				  for (int temp = 0; temp < nList.getLength(); temp++) {
        			            Node nNode = nList.item(temp);
        			            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        			                Element eElement = (Element) nNode;
        			            String text = eElement.getAttribute("numViews");
        			            long numLong = Long.valueOf(text);
        			            boolean isRightnumViewsRang = numLong>4000;
        			            Assert.assertTrue(isRightnumViewsRang);
        			            }
        				  }

	}

}
