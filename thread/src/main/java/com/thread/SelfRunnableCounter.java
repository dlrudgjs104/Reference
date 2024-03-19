package com.thread;

public class SelfRunnableCounter implements Runnable{
    int count;
    int maxCount;
    Thread thread;

    SelfRunnableCounter(String name, int maxCount){
        this.maxCount = maxCount;
        count = 0;
        thread = new Thread(this, name);

    }


    public void start() {
        thread.start();
    }

    @Override
    public void run(){
        while(count < maxCount){
            count++;
            System.out.println(thread.getName() + " : " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }

    }
}

class Test3{
    public static void main(String[] args) {
        SelfRunnableCounter selfrunnablecounter = new SelfRunnableCounter("counter", 10);

        selfrunnablecounter.start();

    }
}
