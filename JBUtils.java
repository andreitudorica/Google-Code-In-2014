import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.parser.JSONParser;
import org.bson.BSON;
import org.bson.BSONObject;
import org.bson.BasicBSONEncoder;
import org.bson.BasicBSONDecoder;

import com.mongodb.DBObject;
import com.mongodb.util.*;

public class JBUtils {
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
	
	protected static JSONObject ReadJSONfromFile(String filepath)
   {
		JSONParser parser = new JSONParser();
		Object obj;
		filepath=filepath+".json";
		File file = new File(filepath);
		JSONObject json = new JSONObject();
		try {
			obj = parser.parse(new FileReader(file));
			json = (JSONObject) obj;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	protected static BSONObject ReadBSONfromFile(String filepath) 
	{
		filepath=filepath+".bson";
    	File file = new File(filepath);
		FileInputStream fileInputStream=null;
        byte[] bson_byte = new byte[(int) file.length()];
        try 
        {
        	fileInputStream = new FileInputStream(file);
        	fileInputStream.read(bson_byte);
        	fileInputStream.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
        BasicBSONDecoder decoder = new BasicBSONDecoder();
        BSONObject bsonObject = decoder.readObject(bson_byte);
		return bsonObject;
	}
	protected static void PrintJSONtoFile(JSONObject json,String filepath)
	{
		filepath=filepath+".json";
		try {
	          File file = new File(filepath);
	          if(file.createNewFile())
	          {
	        	  BufferedWriter output = new BufferedWriter(new FileWriter(file));
	        	  String text= (String) json.toString();
	        	  output.write(text);
	        	  output.close();
	          }
	          else
	          {
	        	  file.delete();
	        	  file.createNewFile();
	        	  BufferedWriter output = new BufferedWriter(new FileWriter(file));
	        	  String text= (String) json.toString();
	        	  output.write(text);
	        	  output.close();
	          }
	        } catch ( IOException e ) {
	           e.printStackTrace();
	        }
	}
	protected static void PrintBSONtoFileDecoded(BSONObject bson,String filepath)

	{
		filepath=filepath+"_decoded.bson";
		try {
	          File file = new File(filepath);
	          if(file.createNewFile())
	          {
	        	  BufferedWriter output = new BufferedWriter(new FileWriter(file));
	        	  String text= (String) bson.toString();
	        	  output.write(text);
	        	  output.close();
	          }
	          else
	          {
	        	  file.delete();
	        	  file.createNewFile();
	        	  BufferedWriter output = new BufferedWriter(new FileWriter(file));
		          String text= (String) bson.toString();
		          output.write(text);
		          output.close();
	          }
	        } catch ( IOException e ) {
	           e.printStackTrace();
	        }
	}
	
	protected static void PrintBSONtoFileEncoded(BSONObject bson,String filepath)
	{
		filepath=filepath+"_encoded.bson";
		BasicBSONEncoder encoder = new BasicBSONEncoder();
		byte[] bson_bytes = encoder.encode(bson);
		
		
		try 
		{
	        File file = new File(filepath);
	        if(file.createNewFile())
	        {
	        	BufferedWriter output = new BufferedWriter(new FileWriter(file));
	        	String text = "";
	        	for(int i = 0; i < bson_bytes.length; i++)
	        	{
	        		text += (char)bson_bytes[i];
	        	}
	        	output.write(text);
	        	output.close();
			}
	        else 
	        {
	        	file.delete();
	        	file.createNewFile();
	        	BufferedWriter output = new BufferedWriter(new FileWriter(file));
	        	String text = "";
	        	for(int i = 0; i < bson_bytes.length; i++)
	        	{
	        		text += (char)bson_bytes[i];
	        	}
	        	output.write(text);
	        	output.close();
	        }
	        
      } catch ( IOException e ) {
         e.printStackTrace();
      }
	}
}
