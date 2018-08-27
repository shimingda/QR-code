package com.dome.thread;

/**
 * 检查线程存活状态
 */
public class CheckLiveDome extends Thread{
    public void run() {
        for (int i = 0; i < 10; i++) {
            printMsg();
        }
    }

    public void printMsg() {
        //获得当前线程名称
        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println("name=" + name);
    }
    public static void main(String[] args) {
        CheckLiveDome tt = new CheckLiveDome();
        tt.setName("Thread");
        System.out.println("before start(), tt.isAlive()=" + tt.isAlive());
        tt.start();
        System.out.println("just after start(), tt.isAlive()=" + tt.isAlive());
        for (int i = 0; i < 10; i++) {
            tt.printMsg();
        }
        System.out.println("The end of main(), tt.isAlive()=" + tt.isAlive());
    }
}
