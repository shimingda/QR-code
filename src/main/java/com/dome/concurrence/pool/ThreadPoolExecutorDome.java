package com.dome.concurrence.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor是一个ExecutorService，可以使用可能的几个池线程来执行每个提交的任务，通常使用Executors工厂方法进行配置。
 * 它还提供了各种实用方法来检查当前线程统计信息并进行控制。
 */
public class ThreadPoolExecutorDome {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();

        //Stats before tasks execution
        System.out.println("Core threads: " + executor.getCorePoolSize());
        System.out.println("Largest executions: "
                + executor.getLargestPoolSize());
        System.out.println("Maximum allowed threads: "
                + executor.getMaximumPoolSize());
        System.out.println("Current threads in pool: "
                + executor.getPoolSize());
        System.out.println("Currently executing threads: "
                + executor.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): "
                + executor.getTaskCount());

        executor.submit(new Task());
        executor.submit(new Task());

        //Stats after tasks execution
        System.out.println("Core threads: " + executor.getCorePoolSize());
        System.out.println("Largest executions: "
                + executor.getLargestPoolSize());
        System.out.println("Maximum allowed threads: "
                + executor.getMaximumPoolSize());
        System.out.println("Current threads in pool: "
                + executor.getPoolSize());
        System.out.println("Currently executing threads: "
                + executor.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): "
                + executor.getTaskCount());

        executor.shutdown();
    }

    static class Task implements Runnable {

        public void run() {
            try {
                Long duration = (long) (Math.random() * 5);
                System.out.println("Running Task! Thread Name: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(duration);
                System.out.println("Task Completed! Thread Name: "+ Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}