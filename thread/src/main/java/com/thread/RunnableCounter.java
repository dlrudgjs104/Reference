package com.thread;

public class RunnableCounter implements Runnable {
    private String name = "";
    private int count = 0;
    private int maxCount;
    Thread thread;

    public RunnableCounter(String name, int maxCount){
        this.name = name;
        this.maxCount = maxCount;
        thread = new Thread(this);
    }

    public void addCount(){
        count++;
    }

    public int getCount(){
        return count;
    }

    public Thread getThread(){
        return thread;
    }

    @Override
    public String toString(){
        return name + " : " + count;
    }

    public void run(){
        while(getCount() < maxCount){
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

class Test2{
    public static void main(String[] args) {
        RunnableCounter[] counters = new RunnableCounter[10];
        for(int i = 0; i < counters.length; i++){
            counters[i] = new RunnableCounter("counter" + (i + i), 10);

            counters[i].getThread().start();
        }

        boolean allStopped = true;

        while(allStopped){
            

            for(int i = 0; i < counters.length; i++){
                if(counters[i].thread.isAlive()){
                    allStopped = false;
                }
            }
        }
    }
}
