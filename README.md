JSONtoBSONandBSONtoJSON
=======================
This is a java program to do BSON to JSON and JSON to BSON conversion.
the main.java code has 2 parts. 
The first one reads a JSON from a given path by calling the ReadJSONfromFile function and using as a parameter the path to the JSON file(in my case io/JSONInput.txt). Then it prints the JSONObject to a certain path by calling the PrintJSONtoFile function and using as parameters the JSONObject and the path to the output file (in my case io/JSONOutput1.txt). After that it converts the JSONObject into a BSONObject by calling the function JSONtoBSON and using the JSONObject as a parameter. Afterwards it Prints the decoded and the encoded version of the BSONObject to certain paths by calling the PrintBSONtoFileDecoded and the PrintBSONtoFileEncoded functions and using as parameter for each of the the wanted output files (in my case io/BSONOutput1Encoded.txt and io/BSONOutput1Decoded.txt);
The second part does the same thing but for BSON. Long story short it reads the binary form of the BSON from a file, prints its encoded and decoded form, converts it into JSON (BSONtoJSON function) and prints the JSONObject.

the JBUtils.java code contains the definition of all the functions used in the Main.java code.

GCI task
