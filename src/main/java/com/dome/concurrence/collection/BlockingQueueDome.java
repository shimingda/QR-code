package com.dome.concurrence.collection;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue接口是Queue接口的子接口，另外还支持诸如在检索元素之前等待队列变为非空的操作，并在存储元素之前等待队列中的空间变得可用 。
 * BlockingQueue接口中的方法
 * 序号	方法	                                                    描述
 * 1	boolean add(E e)	                                        将指定的元素插入到此队列中，如果可以立即执行此操作，而不会违反容量限制，在成功时返回true，并且如果当前没有空间可用，则抛出IllegalStateException。
 * 2	boolean contains(Object o)	                                如果此队列包含指定的元素，则返回true。
 * 3	int drainTo(Collection<? super E> c)	                    从该队列中删除所有可用的元素，并将它们添加到给定的集合中。
 * 4	int drainTo(Collection<? super E> c, int maxElements)	    最多从该队列中删除给定数量的可用元素，并将它们添加到给定的集合中。
 * 5	boolean offer(E e)	                                        将指定的元素插入到此队列中，如果可以立即执行此操作而不违反容量限制，则成功返回true，如果当前没有空间可用，则返回false。
 * 6	boolean offer(E e, long timeout, TimeUnit unit)	            将指定的元素插入到此队列中，等待指定的等待时间(如有必要)才能使空间变得可用。
 * 7	E poll(long timeout, TimeUnit unit)	                        检索并删除此队列的头，等待指定的等待时间(如有必要)使元素变为可用。
 * 8	void put(E e)	                                            将指定的元素插入到此队列中，等待空间/容量可用。
 * 9	int remainingCapacity()	                                    返回此队列可理想地(在没有内存或资源约束的情况下)接受而不阻止的附加元素数，如果没有内在限制则返回Integer.MAX_VALUE。
 * 10	boolean remove(Object o)	                                从该队列中删除指定元素的单个实例(如果存在)。
 * 11	E take()	                                                检索并删除此队列的头，如有必要，等待元素可用。
 */
public class BlockingQueueDome {
    public static void main(final String[] arguments) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }


    static class Producer implements Runnable {

        private BlockingQueue<Integer> queue;

        public Producer(BlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            Random random = new Random();

            try {
                int result = random.nextInt(100);

                queue.put(result);
                System.out.println("Added: " + result);
                result = random.nextInt(100);
                queue.put(result);
                System.out.println("Added: " + result);
                result = random.nextInt(100);
                queue.put(result);
                System.out.println("Added: " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Consumer implements Runnable {

        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue queue){
            this.queue = queue;
        }
        @Override
        public void run() {
            try {
                System.out.println("Removed: " + queue.take());
                System.out.println("Removed: " + queue.take());
                System.out.println("Removed: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
