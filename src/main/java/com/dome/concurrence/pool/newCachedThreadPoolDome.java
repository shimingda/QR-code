package com.dome.concurrence.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Executors类的静态newCachedThreadPool()方法可以获得缓存的线程池。
 * newCachedThreadPool()方法创建一个具有可扩展线程池的执行器。
 * 这样的执行者适合于发起许多短命的任务的应用程序。
 */
public class newCachedThreadPoolDome {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newCachedThreadPool();
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

        for (int i=1;i<483647;i++)
            executorService.submit(new newFixedThreadPoolDome.Task());

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

}
