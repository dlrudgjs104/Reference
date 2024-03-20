package com.nhnacademy.json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Ex06 {
    public static void main(String[] args){
        // Create JSON objects
        JSONObject animal = new JSONObject();
        JSONArray birds = new JSONArray();
        JSONArray mammals = new JSONArray();

        // Add birds
        birds.put("갈매기");
        birds.put("참새");
        birds.put("펭귄");

        // Add mammals
        mammals.put("사자");
        mammals.put("호랑이");
        mammals.put("말");

        // Add birds and mammals to animal object
        animal.put("조류", birds);
        animal.put("포유류", mammals);

        // Create final JSON object
        JSONObject result = new JSONObject();
        result.put("동물", animal);

        // Print result
        System.out.println(result.toString());


    }
}
