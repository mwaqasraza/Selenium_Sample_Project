package com.digital.util;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;

public class JsonUtils {

    public static String extract_Json_Node_By_Json_Path(String jsonString, String jsonPath) {
        try {
            Object result = JsonPath.read(jsonString, jsonPath);
            return result != null ? result.toString() : null;
        } catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<String> extract_Json_Array_By_Json_Path(String jsonString, String jsonPath) {
        try {
            Configuration config = Configuration.defaultConfiguration().addOptions(Option.ALWAYS_RETURN_LIST);
            Object result = JsonPath.using(config).parse(jsonString).read(jsonPath);
            if (result instanceof java.util.List) {
                return new ArrayList<>((java.util.List<String>) result);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean set_Json_Node_By_Json_Path(String jsonString, String jsonPath, Object value) {
        try {
            DocumentContext documentContext = JsonPath.parse(jsonString);
            documentContext.set(jsonPath, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ArrayList<JSONObject> get_JSON_Array_By_JsonPath(String jsonString, String jsonPath) throws org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        ArrayList<JSONObject> als = (ArrayList<JSONObject>) parser.parse(extract_Json_Node_By_Json_Path(jsonString,jsonPath).toString());
        return als;
    }

    public static String delete_Json_Node_At_JsonPath(String jsonString, String jsonPath){
        DocumentContext dc = JsonPath.parse(jsonString);
        dc.delete(jsonPath);
        return dc.jsonString();
    }

}