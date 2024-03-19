package com.thread;
public class Counter {
    private String name = "";
    private int count = 0;
    int maxCount;

    public Counter(String name, int maxCount){
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

    public void run(){
        while(getCount() < 10){
            try {
                addCount();
                Thread.sleep(1000);
                System.out.println(this);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
        }
        
    }
}

class Test{
    public static void main(String[] args) {
        Counter counter1 = new Counter("counter1", 10);
        Counter counter2 = new Counter("counter2", 10);
        counter1.run();
        counter2.run();
    }
}
