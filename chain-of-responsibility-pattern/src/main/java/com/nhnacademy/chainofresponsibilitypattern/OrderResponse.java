package com.nhnacademy.chainofresponsibilitypattern;

public class OrderResponse {
    public void doResponse(Request request){
        System.out.println("[주문 내역 페이지]");
        System.out.println("수건");
        System.out.println("치약");
        System.out.println("신발");
    }
}
