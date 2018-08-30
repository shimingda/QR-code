package com.dome.concurrence.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorService接口是Executor接口的子接口，并添加了功能来管理生命周期，这两个单独的任务和执行器本身。
 */
public class ExecutorServiceDome {
    public static void main(String[] args) {
        ExecutorService executor=Executors.newSingleThreadExecutor();
        System.out.println("thread start");
        executor.submit(new Task());
        executor.shutdown();
        System.out.println("thread end");
        System.out.println(executor.isShutdown());
    }
    static class Task implements Runnable {
        public void run() {
            try {

                System.out.println("Running Task!");
                TimeUnit.SECONDS.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
