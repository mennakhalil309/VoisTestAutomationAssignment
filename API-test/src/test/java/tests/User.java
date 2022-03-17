package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class User {
	String url = "https://jsonplaceholder.typicode.com/users";
	//get random userId
	 Random r = new Random();
    int randomUserId = r.nextInt(10);
    
	@Test
	public void GetUser() {
		
		
		given().when().get(url).then().assertThat().statusCode(200);
		String responseStr=given().when().get(url+"?id="+randomUserId).then().extract().response().asString();
        System.out.println(responseStr);
        
     // get user's email address from the response
        JsonPath jsonPath = new JsonPath(responseStr);
        String emailAddress = jsonPath.getString("email");
        System.out.println(emailAddress);
	}

	@Test
    public void whenGetUserPosts() {
		String responseStr = given().contentType(ContentType.JSON).when().get("https://jsonplaceholder.typicode.com/posts"+"?userId="+randomUserId)
                .then().assertThat().statusCode(200).extract().body().asString();
        System.out.println(responseStr);
        JSONArray jsonArray = new JSONArray(responseStr);
        // Using the userID, get the user’s associated posts
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            int id = Integer.valueOf(jsonObj.get("id").toString());
            boolean isRightIdRang = id>0 && id<=100;
            Assert.assertTrue(isRightIdRang);
        }
    }
	
	@Test
    public void whenAddPost() {
		  String requestBody = "{\n" +
	            "  \"title\": \"Vois task\",\n" +
	            "  \"body\": \"Vois API task by Menna\",\n" +
	            "  \"userId\": \"1\" \n}";
          Response response = given().header("Content-type", "application/json")
                        .and().body(requestBody)
                        .when().post("https://jsonplaceholder.typicode.com/posts")
                        .then().extract().response();
         Assert.assertEquals(201, response.statusCode());
	}
}
