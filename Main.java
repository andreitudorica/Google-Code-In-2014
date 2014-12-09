import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

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
	
	public static void main(String[] args)
	{
		String json_imput_name="io/JSONInput";
		JSONObject json = JBUtils.ReadJSONfromFile(json_imput_name);
		BSONObject bson = JBUtils.JsonToBson(json);
		JBUtils.PrintBSONtoFileDecoded(bson, json_imput_name);
		JBUtils.PrintBSONtoFileEncoded(bson, json_imput_name);
		////////////////////////////////////////////////////////////////
		String bson_imput_name="io/BSONInput";
		BSONObject bson1 =JBUtils.ReadBSONfromFile(bson_imput_name);
		JSONObject json1= JBUtils.BsonToJson(bson1);
		JBUtils.PrintJSONtoFile(json1, bson_imput_name);
	}
	
}
