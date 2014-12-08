import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.bson.BSON;
import org.bson.BSONObject;
import org.bson.BasicBSONEncoder;
import org.bson.BasicBSONDecoder;

import com.mongodb.DBObject;
import com.mongodb.util.*;

public class ReadJSON 
{
	protected static BSONObject JsonToBson(JSONObject json)
	{
		BSONObject bson = (BSONObject) JSON.parse(JSON.serialize(json));
		
		return bson;
	}
	
	protected static JSONObject BsonToJson(BSONObject bson)
	{
		String json_string = JSON.serialize(bson);
		
		JSONParser parser = new JSONParser();
		
		Object obj = null;
		
		try 
		{
			obj = parser.parse(json_string);
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		JSONObject json = (JSONObject) obj;
		
		return json;
	}
	
	public static void main(String[] args)
	{
		JSONParser parser = new JSONParser();
		try
		{
		Object obj = parser.parse(new FileReader("io/input.txt"));
		JSONObject json = (JSONObject) obj;
		
		System.out.println(json.toString());
		BSONObject bson = (BSONObject) JsonToBson(json);
		System.out.println(bson);
		System.out.println(BsonToJson(bson));
		
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
