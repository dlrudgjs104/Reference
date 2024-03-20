package com.nhnacademy.json;

import org.json.JSONObject;

public class Person {
    private String name;
    private Address address;

    public Person(Address address, String name) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress(){
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Ex03 {
    public static void main(String[] args) {
        Person person = new Person(new Address(13487, "Seongnam"), "nhn");
        JSONObject object = new JSONObject(person);

        System.out.println(object);
    }
}