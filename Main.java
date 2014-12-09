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
		JSONObject json = JBUtils.ReadJSONfromFile("io/example.json");
		JBUtils.PrintJSONtoFile(json, "io/example.json");
		BSONObject bson = JBUtils.JsonToBson(json);
		JBUtils.PrintBSONtoFileDecoded(bson, "io/example.bson");
		JBUtils.PrintBSONtoFileEncoded(bson, "io/example.bson");
		////////////////////////////////////////////////////////////////
		BSONObject bson1 =JBUtils.ReadBSONfromFile("io/example.bson");
		JBUtils.PrintBSONtoFileDecoded(bson1, "io/example.bson");
		JBUtils.PrintBSONtoFileEncoded(bson1, "io/example.bson");
		JSONObject json1= JBUtils.BsonToJson(bson1);
		JBUtils.PrintJSONtoFile(json1, "io/example.json");
	}
	
}
