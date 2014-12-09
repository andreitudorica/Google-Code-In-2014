JSON-BSON and BSON-JSON converter
=======================
The JBUtils.java file contains 7 functions: 

Function               | Description
-----------------------|-------------
ReadJSONfromFile       |it takes as a parameter the path of the input file, reads a string, converts it into a JSONObject and returns it.
ReadBSONfromFile       |  it takes as a parameter the path of the input file, reads a byte array, deserialises it into a BSONObject and returns it.
PrintJSONtoFile        | it takes as parameters the JSONObject and the path of the output file, converts the JSONObject into a string and prints it.
PrintBSONtoFileDecoded | it takes as parameters the BSONObject and the path of the output file, converts the BSONObject into a string and prints it.
PrintBSONtoFileEncoded | it takes as parameters the BSONObject and the path of the output file, converts the BSONObject into a byte array, the byte array into a string and prints it.
JSONtoBSON             | it takes as a parameter the JSONObject, converts it into a decoded BSONObject and returns it.
BSONtoJSON             | it takes as a parameter the decoded BSONObject, converts it into a JSONObject and returns it.

the Main.java file contains just the calls to the functions previously described.
GCI task
