package com.dome.thread;

/**
 * 监测状态
 */
public class MonitorDome extends Thread{
    boolean waiting= true;
    boolean ready= false;
    MonitorDome() {
    }
    public void run() {
        String thrdName = Thread.currentThread().getName();
        System.out.println(thrdName + " starting.");
        while(waiting)
            System.out.println("waiting:"+waiting);
        System.out.println("waiting...");
        startWait();
        try {
            Thread.sleep(1000);
        }
        catch(Exception exc) {
            System.out.println(thrdName + " interrupted.");
        }
        System.out.println(thrdName + " terminating.");
    }
    synchronized void startWait() {
        try {
            while(!ready) wait();
        }
        catch(InterruptedException exc) {
            System.out.println("wait() interrupted");
        }
    }
    synchronized void notice() {
        ready = true;
        notify();
    }
}
 class Main {
    public static void main(String args[])
            throws Exception{
        MonitorDome thrd = new MonitorDome();
        Thread.sleep(5000);
        thrd.setName("MyThread #1");
        showThreadStatus(thrd);
        thrd.start();
        showThreadStatus(thrd);
        thrd.waiting = false;
        Thread.sleep(5000);
        showThreadStatus(thrd);
        thrd.notice();
        Thread.sleep(5000);
        showThreadStatus(thrd);
        while(thrd.isAlive())
            System.out.println("alive");
        showThreadStatus(thrd);
    }
    static void showThreadStatus(Thread thrd) {
        System.out.println(thrd.getName() + "Alive:=" + thrd.isAlive() + " State:=" + thrd.getState());
    }
}
