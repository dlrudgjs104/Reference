package com.nhnacademy.json;

import org.json.JSONObject;

public class Ex05 {
    public static void main(String[] args){
        JSONObject customer = new JSONObject();
        customer.put("name", "nhn");
        customer.put("age", 10);

        Object nameObject = customer.get("name");
        System.out.println("Name type: " + nameObject.getClass().getTypeName());
        System.out.println(nameObject);

        Object age = customer.get("age");
        System.out.println(age.getClass().getTypeName());
        System.out.println(age);
        
        if(nameObject instanceof String){
            System.out.println("Name is String");
        }

        System.out.println();
    }
}
