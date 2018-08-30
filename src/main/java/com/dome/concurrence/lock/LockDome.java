package com.dome.concurrence.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintDemo {

    private final Lock queueLock = new ReentrantLock();

    public void print() {
        queueLock.lock();
        try {
            for (int i=1;i<10;i++){

                System.out.println(Thread.currentThread().getName()+"-------"+i);
            }
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s printed the document successfully.\n", Thread.currentThread().getName());
            queueLock.unlock();
        }
    }
}

class ThreadDemo extends Thread {
    PrintDemo  printDemo;

    ThreadDemo( String name,  PrintDemo printDemo) {
        super(name);
        this.printDemo = printDemo;
    }

    @Override
    public void run() {
        System.out.printf("%s starts printing a document\n", Thread.currentThread().getName());
        printDemo.print();
    }
}

public class LockDome {

    public static void main(String args[]) {
        PrintDemo PD = new PrintDemo();

        ThreadDemo t1 = new ThreadDemo( "Thread - 1 ", PD );
        ThreadDemo t2 = new ThreadDemo( "Thread - 2 ", PD );
        ThreadDemo t3 = new ThreadDemo( "Thread - 3 ", PD );
        ThreadDemo t4 = new ThreadDemo( "Thread - 4 ", PD );

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}