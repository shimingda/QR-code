package com.dome.temer;

/**
 * 定时器任务测试类
 */
public class TestTimer {
    public static void main(String[] args) {
//        TimerThread timerThread=new TimerThread();
//        timerThread.run();
        TimerScheduled timerScheduled=new TimerScheduled();
        timerScheduled.runTime();
        while (true){

        }
    }
}
