package com.Thirdeye.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONTokener;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONUtilities {

	// This method return the object of json.
	public static JSONObject getJSONFileObject(String jsonFilePath)
	{
		JSONParser jsonParser = new JSONParser();
    	Object object = null;
    	JSONObject jsonObject = null;
		try {
			object = jsonParser.parse(new FileReader(jsonFilePath));
	    	jsonObject = (JSONObject) object;	    	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		return jsonObject;
	}

	public static JsonObject getJSONFileObject1(String jsonFilePath)
	{
		JsonParser jsonParser = new JsonParser();
		Object object = null;
		JsonObject jsonObject = null;
		try {
			object = jsonParser.parse(new FileReader(jsonFilePath));
			jsonObject = (JsonObject) object;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	public static JsonArray getJSONArray1(String jsonFilePath)
	{
		JsonParser jsonParser = new JsonParser();
		Object object = null;
		JsonArray jsonArray = null;
		try {
			object = jsonParser.parse(new FileReader(jsonFilePath));
			jsonArray = (JsonArray) object;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}

	public static boolean compareJSONasString(String json, String endpoint){
		Response response = given().when()
				.header("Content-Type", "application/json")
				.get(endpoint);
		String res = response.getBody().asString();
		JsonParser parser = new JsonParser();
		JsonElement o1 = parser.parse(json);
		JsonElement o2 = parser.parse(res);
		if(o1.equals(o2)){
			return true;
		}else{
			return false;
		}
	}

	public static void validateSchema(String endpoint, String schema){
		Response response = given().when()
				.header("Content-Type", "application/json")
				.get(endpoint);

		response.then().assertThat().body(matchesJsonSchemaInClasspath(schema));
	}
	
	//
	public static Object getInnerJSONData(String jsonFilePath, String innerJSONName)
	{
		JSONParser parser = new JSONParser();
		Object innerJSON = null;
    	Object object;
		try {
			object = parser.parse(new FileReader(jsonFilePath));
	    	JSONObject jsonObject = (JSONObject) object;
	    	innerJSON = jsonObject.get(innerJSONName);
	    	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return innerJSON;
	}
	public static JSONArray getInnerJSONAtrrayData(JSONObject object, String innerJSONArrayName)
	{
		JSONArray innerArray = null;
	    innerArray = (JSONArray) object.get(innerJSONArrayName);
		return innerArray;
	}
	public static JSONObject objectToJSONObject(Object object){
		Object json = null;
		JSONObject jsonObject = null;
		try {
			json = new JSONTokener(object.toString()).nextValue();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (json instanceof JSONObject) {
			jsonObject = (JSONObject) json;
		}
		return jsonObject;
	}
	public static JSONArray getInnerJSONArrayData(String jsonFilePath, String innerJSONArrayName)
	{
		JSONParser parser = new JSONParser();
		JSONArray innerArray = null;
		try {
	    	Object obj = parser.parse(new FileReader(jsonFilePath));
	    	JSONObject jsonObject = (JSONObject) obj;
	    	innerArray = (JSONArray) jsonObject.get(innerJSONArrayName);
	    	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return innerArray;
	}
	public static String getJSONArrayValue(JSONArray jsonArray, int array, String name)
	{
    	JSONObject json = (JSONObject) jsonArray.get(array);
    	return (String) json.get(name);
	}

	public static org.json.JSONArray mapToJSONArray(Map object) throws JSONException
	{
		org.json.JSONObject jsonObj = new org.json.JSONObject(object);
		org.json.JSONArray jsonArr = new org.json.JSONArray("["+jsonObj.toString()+"]");
		return jsonArr;
	}

	public static Map getJSONArrayToMap(JSONArray jsonArray, int array)
	{
    	Map json = (Map) jsonArray.get(array);
    	return json;
	}

	public static String getJSONArrayValue1(ArrayList jsonArray, int array, String name)
	{
		LinkedTreeMap json = (LinkedTreeMap) jsonArray.get(array);
		return (String) json.get(name);
	}

	public static Double getJSONArrayValueToDouble(ArrayList jsonArray, int array, String name)
	{
		LinkedTreeMap json = (LinkedTreeMap) jsonArray.get(array);
		return (Double) json.get(name);
	}


	// Below methods are for getting the data from API response
	
	// This method return the inner json from a specified response.
	@SuppressWarnings("rawtypes")
	public static Map getInnerJSON(Map response, String key)
	{
		return ((Map) response.get(key));
	}

	
	public static ArrayList getInnerJSON1(Map response, String key)
	{
		return ((ArrayList) response.get(key));
	}
	
	// This method return the value of a field present in specified json response.
	@SuppressWarnings("rawtypes")
	public static String getValueFromResponse(Map response, String elementName)
	{
		return response.get(elementName).toString().split("\\.")[0];
	}

	@SuppressWarnings("rawtypes")
	public static String getActualValueFromResponse(Map response, String elementName)
	{
		return response.get(elementName).toString();
	}
	
	// This method return the value of a field present inside a array of json on a specific index.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String getArrayValue(Map response, String arrayName, int index, String elementName)
	{
		return ((ArrayList<Map>)response.get(arrayName)).get(index).get(elementName).toString().split("\\.")[0];
	}
	public static String getActualArrayValue(Map response, String arrayName, int index, String elementName)
	{
		return ((ArrayList<Map>)response.get(arrayName)).get(index).get(elementName).toString();
	}

	public static Object getArrayValueToMap(Map response, String arrayName, int index, String elementName)
	{
		return ((ArrayList<Map>)response.get(arrayName)).get(index).get(elementName);
	}

	/*public static Object getArrayFromArray(ArrayList<Map> response, String arrayName, int index)
	{
		return response.get(index).get(arrayName);
	}*/
	// This method return the Array from the specified JSON response.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Map> getArray(Map response, String arrayName)
	{
		return ((ArrayList<Map>)response.get(arrayName));
	}
	public static ArrayList<Integer> getIntegerArray(Map response, String arrayName)
	{
		return ((ArrayList<Integer>)response.get(arrayName));
	}
	//This method returns values of an element in Json
	@SuppressWarnings("rawtypes")
	public static String getJsonArrayValue1(JSONObject response,String elementName,int index)
	{
		return (String) ((ArrayList)response.get(elementName)).get(index);
	}

	@SuppressWarnings("rawtypes")
	public static JSONObject getJSONfromString(String jsonString)
	{
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		try{
			json = (JSONObject) parser.parse(jsonString);
		}catch (Exception e){

		}
		return json;
	}

	public static  JSONObject createJsonObject(){
		JSONObject amd_1 = new JSONObject();

//		JSONObject metadata = new JSONObject();
//		ArrayList<Integer> pageNumber = new ArrayList<>();
//		ArrayList<String> labelName = new ArrayList<>();
//		pageNumber.add(8);
//		labelName.add("Prose");
//		metadata.put("label", labelName);
//		metadata.put("page number", pageNumber);
//		amd_1.put("associated-metadata", metadata);

		return amd_1;
	}

	public static Object getInnerJSON2(Map response, String key)
	{
		return response.get(key);
	}

}
