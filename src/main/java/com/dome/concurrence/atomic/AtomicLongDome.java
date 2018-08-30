package com.dome.concurrence.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDome {
    static class Counter {
        private AtomicLong c = new AtomicLong(0);

        public void increment() {
            c.getAndIncrement();
        }

        public long value() {
            return c.get();
        }
    }
    public static void main(final String[] arguments) throws InterruptedException {
        final Counter counter = new Counter();
        //1000 threads
        for(int i = 0; i < 1000 ; i++) {
            new Thread(new Runnable() {
                public void run() {
                    counter.increment();
                    System.out.println("Final number (should be 1000): " + counter.value());
                }
            }).start();
        }
        System.out.println("Final number (should be 1000): " + counter.value());
    }
}
