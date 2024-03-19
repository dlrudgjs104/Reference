package com.nhnacademy.regexdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Command Line Arguments 예제
public class Main {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
        }

        System.out.println();

        // 예외처리를 이용한 방법은 사이드 이펙트방법이기 때문에 이용하지 않는게 좋다.
        for (String arg : args) {
            try {
                int value = Integer.parseInt(arg);
                System.out.println("int : " + value);
            } catch (NumberFormatException ignore) {
                System.out.println("String :" + arg);
            }

        }

        System.out.println();

        for (String arg : args) {
            Pattern pattern = Pattern.compile("^\\s*[+-]?(0|[1-9][0-9]{0,9})\\s*$");
            Matcher matcher = pattern.matcher(arg);
            if (matcher.find()) {
                int value = Integer.parseInt(arg.trim());
                System.out.println("int : " + value);
            } else {
                System.out.println("String :" + arg);
            }

        }

        for(String arg : args){
            Pattern pattern = Pattern.compile(arg);
            Matcher matcher = pattern.matcher(arg);
            if(matcher.find()){
                
            }
        }

    }
}