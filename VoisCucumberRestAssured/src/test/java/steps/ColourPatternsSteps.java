package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class ColourPatternsSteps {
    private static String BASE_URL;
    RequestSpecification request;
    private static Response response;
    boolean isRightnumViewsRang;

    @Given("^User set GET colour patterns endpoint$")
    public void user_want_to_execute_GET_colour_patterns_endpoint() throws Throwable {
        BASE_URL = "http://www.colourlovers.com/api/patterns";
        System.out.println("GET URL: " + BASE_URL);
    }

    @Given("^User set request header$")
    public void user_submit_GET_request() throws Throwable {
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given();
        request.header("Host", "www.colourlovers.com");
        request.header("User-Agent", "PostmanRuntime/7.29.0");

    }

    @When("^User submit GET request to colour lovers$")
    public void submit_GET_request() throws Throwable {
        response = request.given().when().get(BASE_URL).then().extract().response();
    }

    @Then("^User should receive valid status code (\\d+)$")
    public void user_should_get_success_status_code(int arg1) throws Throwable {
        Assert.assertEquals(response.statusCode(), arg1);
    }


    @Then("^Verify numViews is greater than (\\d+)$")
    public void verify_numViews_value_range(int value) throws Throwable {
        XmlPath xmlPath = response.xmlPath();
        int numViewsSize = xmlPath.get("patterns.pattern.numViews.item.size()");

        for(int i =0; i<numViewsSize; i++) {
            long numViews = xmlPath.getInt("numViews");
            boolean isRightnumViewsRang = numViews>value;
            Assert.assertTrue(isRightnumViewsRang);
        }
    }

}
