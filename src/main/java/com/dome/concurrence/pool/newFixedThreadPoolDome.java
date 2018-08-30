package com.dome.concurrence.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 可以通过调用Executors类的static newFixedThreadPool()方法获得一个固定线程池。
 * 最多2个线程将处于活动状态。
 * 如果提交了两个以上的线程，那么它们将保持在队列中，直到线程可用。
 * 如果一个线程由于执行关闭期间的失败而终止，则执行器尚未被调用，则创建一个新线程。
 * 线程会一直存在，直到池关闭。
 */
public class newFixedThreadPoolDome {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        ThreadPoolExecutor pool= (ThreadPoolExecutor) executorService;
        System.out.println("Core threads: " + pool.getCorePoolSize());
        System.out.println("Largest executions: "
                + pool.getLargestPoolSize());
        System.out.println("Maximum allowed threads: "
                + pool.getMaximumPoolSize());
        System.out.println("Current threads in pool: "
                + pool.getPoolSize());
        System.out.println("Currently executing threads: "
                + pool.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): "
                + pool.getTaskCount());

        for (int i=1;i<100;i++)
        executorService.submit(new Task());

        //Stats after tasks execution
        System.out.println("Core threads: " + pool.getCorePoolSize());
        System.out.println("Largest executions: "
                + pool.getLargestPoolSize());
        System.out.println("Maximum allowed threads: "
                + pool.getMaximumPoolSize());
        System.out.println("Current threads in pool: "
                + pool.getPoolSize());
        System.out.println("Currently executing threads: "
                + pool.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): "
                + pool.getTaskCount());
        executorService.shutdown();

    }
    static class Task implements Runnable {
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+"running");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
