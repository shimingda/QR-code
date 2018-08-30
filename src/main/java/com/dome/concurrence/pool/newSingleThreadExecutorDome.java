package com.dome.concurrence.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 可以通过调用Executors类的static newSingleThreadExecutor()方法获得单个线程池。
 */
public class newSingleThreadExecutorDome {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            executor.submit(new Task());
            System.out.println("Shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    static class Task implements Runnable {
        public void run() {
            try {
                Long duration = (long) (Math.random() * 20);
                System.out.println("Running Task!");
                TimeUnit.SECONDS.sleep(duration);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}