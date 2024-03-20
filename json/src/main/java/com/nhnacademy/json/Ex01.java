package com.nhnacademy.json;

import org.json.JSONException;
import org.json.JSONObject;

public class Ex01 {
    public static void main(String[] args) {
        try {
            JSONObject object = new JSONObject();
            JSONObject object2 = new JSONObject();
            
            object.put("address", object2.put("code", 13487));
            object.put("address", object2.put("city", "Seongnam"));
            object.put("name", "nhn");
            System.out.println(object.toString());
        } catch (JSONException e) {

        }

    }
}