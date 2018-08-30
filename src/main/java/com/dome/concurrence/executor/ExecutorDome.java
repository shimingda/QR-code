package com.dome.concurrence.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池执行线程
 * Executor接口是支持启动新任务的一个简单接口。
 */
public class ExecutorDome {
    public static void main(String[] args) {
        Executor executor=Executors.newCachedThreadPool();
        executor.execute(new Task());
    }
    static  class Task implements Runnable{

        @Override
        public void run() {
            try {
                Long duration = (long) (Math.random() * 5);
                System.out.println("Running Task!");
                TimeUnit.SECONDS.sleep(duration);
                System.out.println("Task Completed");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }

