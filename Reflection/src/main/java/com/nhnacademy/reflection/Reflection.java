package com.nhnacademy.Reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Reflection {
    public static void main(String[] args) {
        Class c = ArrayList.class;
        Method m[] = c.getDeclaredMethods();
        for(int i=0; i<m.length; i++){
            System.out.println(m[i].toString());
        }
    }
}
