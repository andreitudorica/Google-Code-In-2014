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
		JSONObject json = JBUtils.ReadJSONfromFile("io/JSONInput.txt");
		JBUtils.PrintJSONtoFile(json, "io/JSONOutput1.txt");
		BSONObject bson = JBUtils.JsonToBson(json);
		JBUtils.PrintBSONtoFileDecoded(bson, "io/BSONOutput1Decoded.txt");
		JBUtils.PrintBSONtoFileEncoded(bson, "io/BSONOutput1Encoded.txt");
		////////////////////////////////////////////////////////////////
		BSONObject bson1 =JBUtils.ReadBSONfromFile("io/BSONInput.txt");
		JBUtils.PrintBSONtoFileDecoded(bson1, "io/BSONOutput2Decoded.txt");
		JBUtils.PrintBSONtoFileEncoded(bson1, "io/BSONOutput2Encoded.txt");
		JSONObject json1= JBUtils.BsonToJson(bson1);
		JBUtils.PrintJSONtoFile(json1, "io/JSONOutput2.txt");
	}
	
}
