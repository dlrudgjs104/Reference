package com.nhnacademy.listener2;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

public class CounterUtils {
    public static void increaseCounter(ServletContext servletContext){
        Long counter = (Long) servletContext.getAttribute("counter");
        counter++;
        servletContext.setAttribute("counter", counter);
        System.out.println(counter);
    }
}
