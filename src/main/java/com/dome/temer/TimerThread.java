package com.dome.temer;

/**
 * 线程定时器
 */
public class TimerThread implements Runnable {

    public void run() {
        for (int i=0;i<3;i++){


        final long time=5000;
        System.out.println("start!!!");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}
