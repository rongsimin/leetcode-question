package com.rongsimin.leetcode.editor.cn;

/**
 * @author rsm
 * @date 2023/11/3 11:31
 */
public class Print100 implements Runnable{
    private final Object lock = new Object();
    private static int count = 0;

    @Override
    public void run() {
        synchronized (lock) {
            while (count < 100) {
                System.out.println(Thread.currentThread().getName() + ": " + count++);
                lock.notify();
                try {
                    //if (count < 100) {
                        lock.wait();
                    //}
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Print100 print100 = new Print100();
        Thread thread1 = new Thread(print100);
        Thread thread2 = new Thread(print100);
        thread1.start();
        thread2.start();
    }
}
