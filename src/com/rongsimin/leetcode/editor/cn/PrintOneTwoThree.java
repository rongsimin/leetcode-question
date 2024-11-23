package com.rongsimin.leetcode.editor.cn;

/**
 * 需要共用1把锁，
 * 如果t1拿到，打印A，然后通知另外两个线程，自己进行wait,
 * 如果是t3拿到，不能打印，再次进入等待，只能t2拿到进行打印，也就是需要有个状态值，拿到锁的这个线程，必须和这个状态值对应，才能进行打印，否则就等待被唤醒
 *
 * @author rsm
 * @date 2023/11/3 11:16
 */
public class PrintOneTwoThree {
    private static final Object lock = new Object();

    private static volatile int count = 0;


    private static void printABC(String str, int current) {
        synchronized (lock) {
            try {
                while (count < 10) {
                    if (current != count % 3) {
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + str);
                    count++;
                    lock.notifyAll();
                    if (count < 10) {
                        lock.wait();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        //PrintABC printABC = new PrintABC(0);
        //Thread thread1 = new Thread(printABC, "A");
        //Thread thread2 = new Thread(printABC, "B");
        //Thread thread3 = new Thread(printABC, "C");
        //thread1.start();
        //thread2.start();
        //thread3.start();
        Thread thread1 = new Thread(() ->
                printABC("A", 0)
        );
        Thread thread2 = new Thread(() ->
                printABC("B", 1)
        );
        Thread thread3 = new Thread(() ->
                printABC("C", 2)
        );
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
