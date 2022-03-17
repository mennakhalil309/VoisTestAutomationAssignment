package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {

	public String searchKeyword;
	public String videoNumber;
	
	public void JsonReader() throws IOException, ParseException 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/VideoData.json";
		File srcFile = new File(filePath); 

		JSONParser parser = new JSONParser(); 
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile)); 

		for(Object jsonObj : jarray) 
		{
			JSONObject videoData = (JSONObject) jsonObj ; 
			searchKeyword  = (String) videoData.get("SearchKeyword"); 
			System.out.println(searchKeyword);

			videoNumber = (String) videoData.get("VideoNumber"); 
			System.out.println(videoNumber);
		}

	}
}
