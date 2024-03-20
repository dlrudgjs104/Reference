package com.nhnacademy.json;

import java.io.Console;

import org.json.JSONTokener;

public class Ex09 {
    
    public static void main(String[] args){
        Console console = System.console();

        while(true){
            System.out.println("command: ");
            String line = console.readLine();
            if(line.equals("quit")){
                break;
            }    
            System.out.println("input command: " + line);
        }
        
        
        // JSONTokener tokener = new JSONTokener(System.in);

        // while(!tokener.end()){
        //     Object object = tokener.nextValue();
        //     System.out.println(object.getClass().getTypeName() + " : " + object);
        // }
    }
}
