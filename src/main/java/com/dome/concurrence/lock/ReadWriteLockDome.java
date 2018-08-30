package com.dome.concurrence.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock接口允许一次读取多个线程，但一次只能写入一个线程。
 *
 * 读锁 - 如果没有线程锁定ReadWriteLock进行写入，则多线程可以访问读锁。
 * 写锁 - 如果没有线程正在读或写，那么一个线程可以访问写锁。
 */
public class ReadWriteLockDome {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private static String message = "a";

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new WriterA());
        t1.setName("Writer A");
        Thread t2 = new Thread(new WriterB());
        t2.setName("Writer B");
        Thread t3 = new Thread(new Reader());
        t3.setName("Reader");
        t1.start();
        t2.start();
        t3.start();

    }

    static class Reader implements Runnable {

        public void run() {
            if(lock.isWriteLocked()) {
                System.out.println("Write Lock Present.");
            }
            lock.readLock().lock();
            try {

                for (int i=1;i<10;i++){

                    System.out.println(Thread.currentThread().getName()+"-------"+i);
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() +": "+ message );
                lock.readLock().unlock();
            }
        }
    }

    static class WriterA implements Runnable {

        public void run() {
            lock.writeLock().lock();
            try {
                for (int i=1;i<10;i++){

                    System.out.println(Thread.currentThread().getName()+"-------"+i);
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                message = message.concat("a");
                lock.writeLock().unlock();
            }
        }
    }

    static class WriterB implements Runnable {

        public void run() {
            lock.writeLock().lock();
            try {
                for (int i=1;i<10;i++){

                    System.out.println(Thread.currentThread().getName()+"-------"+i);
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                message = message.concat("b");
                lock.writeLock().unlock();
            }
        }
    }
}