package com.nhnacademy.regexdemo;

import java.util.Arrays;
import java.util.List;

public class Main2 {
    static List<String> classPathList;
    static List<String> moduleList;

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].trim().equals("--class-path") || args[i].trim().equals("-classpath")) {
                if (i + 1 == args.length) {
                    throw new IllegalArgumentException();
                }
                String[] classPaths = args[i + 1].split(";");
                for (String classPath : classPaths) {
                    classPathList = Arrays.asList(classPath);
                }
            }
        }

        if (classPathList != null) {
            System.out.println("--class-path");
            for (String classPath : classPathList) {
                System.out.println(classPath);
            }
        }

        if (moduleList != null) {
            System.out.println("--class-path");
            for (String classPath : classPathList) {
                System.out.println(classPath);
            }
        }
    }
}
