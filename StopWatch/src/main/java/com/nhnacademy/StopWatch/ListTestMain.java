package com.nhnacademy.StopWatch;

public class ListTestMain {
    public static void main(String[] args) {
        PerformanceTestable arrayListTest = new ArrayListTest(); // ArrayListTest 객체 생성
        ListTestProxy listTestProxy = new ListTestProxy(arrayListTest); // ArrayListTestProxy 객체 생성 및 PerformanceTestable 객체 전달
        System.out.println("arrayList 실행");
        listTestProxy.test();

        PerformanceTestable LinkedListTest = new LinkedListTest();
        listTestProxy = new ListTestProxy(LinkedListTest);
        System.out.println("LinkedList 실행");
        listTestProxy.test();
    }
}
