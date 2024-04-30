package com.nhnacademy.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class User{
    private String userName;
    private int userAge;
    public User(){
    }
    public User(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }
    public String getUserName() {
        return userName;
    }
    public int getUserAge() {
        return userAge;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}

class Main1{
    public static void main(String[] args) {
        try {
            Class userClass = Class.forName(User.class.getName());
            Constructor<?> constructor = userClass.getConstructor();
            User user = (User) constructor.newInstance();
            System.out.println(user);
        } catch (ClassNotFoundException | NoSuchMethodException e){
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Main2{
    public static void main(String[] args) {
        try {
            Constructor cUser = Class.forName(User.class.getName()).getConstructor(String.class ,Integer.TYPE);
            User user = (User) cUser.newInstance("marco",20);
            System.out.println(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Main3{
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName(User.class.getName());
            Object user = clazz.getDeclaredConstructor().newInstance();
            Method setUserNameMethod =clazz.getDeclaredMethod("setUserName",String.class);
            setUserNameMethod.invoke(user, "NHN 아카데미");
            Method getUserNameMethod =clazz.getDeclaredMethod("getUserName");
            String userName = (String)
                    getUserNameMethod.invoke(user);
            Method setUserAgeMethod =clazz.getDeclaredMethod("setUserAge",Integer.TYPE);
            setUserAgeMethod.invoke(user, 30);
            Method getUserAgeMethod =clazz.getDeclaredMethod("getUserAge");
            int userAge = (int) getUserAgeMethod.invoke(user);
            System.out.println("userName:" + userName);
            System.out.println("userAge:" + userAge);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

class Main4{
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName(User.class.getName());
            Object user =clazz.getDeclaredConstructor().newInstance();
            Field userNameField =clazz.getDeclaredField("userName");
            userNameField.setAccessible(true);
            userNameField.set(user, "marco");
            String userName = (String) userNameField.get(user);
            Field userAgeField =clazz.getDeclaredField("userAge");
            userAgeField.setAccessible(true);
            userAgeField.set(user, 30);
            int userAge = userAgeField.getInt(user);
            System.out.println("userName:" + userName);
            System.out.println("userAge:" + userAge);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}