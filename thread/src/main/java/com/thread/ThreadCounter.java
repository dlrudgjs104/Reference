package com.thread;

public class ThreadCounter extends Thread{
    private String name = "";
    private int count = 0;
    private int maxCount;

    public ThreadCounter(String name, int maxCount){
        this.name = name;
        this.maxCount = maxCount;
    }

    public void addCount(){
        count++;
    }

    public int getCount(){
        return count;
    }

    @Override
    public String toString(){
        return name + " : " + count;
    }

    @Override
    public void run(){
        while(getCount() < maxCount){
            try {
                addCount();
                Thread.sleep(1000);
                System.out.println(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            
        }
        
    }
}

class ThreadCounterTest{
    public static void main(String[] args) {
        ThreadCounter counter1 = new ThreadCounter("counter1", 10);
        ThreadCounter counter2 = new ThreadCounter("counter2", 10);
        counter1.start();
        counter2.start();
    }
}
