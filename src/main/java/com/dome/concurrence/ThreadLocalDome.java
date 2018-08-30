package com.dome.concurrence;

class RunnableTest implements Runnable {

    ThreadLocal<Integer> threadLocalCounter ;

    public RunnableTest(ThreadLocal<Integer> threadLocalCounter){
        this.threadLocalCounter=threadLocalCounter;
    }
    public void run() {


        System.out.println("threadLocalCounter: " + threadLocalCounter.get());
    }
}

public class ThreadLocalDome {

    public static void main(String args[]) {
        ThreadLocal<Integer> threadLocalCounter=new ThreadLocal<>();
        threadLocalCounter.set(2);
        RunnableTest commonInstance = new RunnableTest(threadLocalCounter);

        Thread t1 = new Thread( commonInstance);
        Thread t2 = new Thread( commonInstance);
        Thread t3 = new Thread( commonInstance);
        Thread t4 = new Thread( commonInstance);

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}