package com.thread;

public class SharedCount {
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void increment() {
        synchronized (this){
            setCount(getCount() + 1);
        }
        
    }
}

class SharedCounter extends Thread {
    SharedCount sharedCount;
    int count;
    int maxCount;
    String name;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount){
        this.name = name;
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
        count = 0;      
        
    }

    @Override
        public void run(){
            while (count < maxCount){
                count++;
                synchronized(sharedCount){
                    sharedCount.increment();
                }
                
            }
        }

}

class Test4 {
    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();
        SharedCounter counter1 = new SharedCounter("counter1", 10000, sharedCount);
        SharedCounter counter2 = new SharedCounter("counter2", 10000, sharedCount);

        counter1.start();
        counter2.start();
        System.out.println(counter1.getName() + ": started");
        System.out.println(counter2.getName() + ": started");

        counter1.join();
        counter2.join();
        System.out.println(counter1.getName() + ": terminated");
        System.out.println(counter2.getName() + ": terminated");
        System.out.println("sharedCOunt : " + sharedCount.getCount());
    }
}
