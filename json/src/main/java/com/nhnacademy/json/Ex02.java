package com.nhnacademy.json;

import org.json.JSONException;
import org.json.JSONObject;

public class Ex02 {
    public static void main(String[] args) {
        try {
            String jsonText = "{\"address\" : {\"code\" : 13487, \"city\" : \"Seongnam\"}, \"name\" : \"nhn\"}";
            JSONObject object = new JSONObject(jsonText);

            System.out.println(object.toString());
        } catch (JSONException e) {

        }

    }
}
