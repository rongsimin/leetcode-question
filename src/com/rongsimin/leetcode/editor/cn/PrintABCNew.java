package com.rongsimin.leetcode.editor.cn;

/**
 * @author rsm
 * @date 2023/11/3 12:34
 */
public class PrintABCNew {
    private int times;
    private int state;
    private Object object = new Object();

    public PrintABCNew(int times) {
        this.times = times;
    }

    public void printLetter(String name, int targetNum) {
        for (int i = 0; i < times;) {
            synchronized (object) {
                while (state % 3 != targetNum) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                i++;
                System.out.println(Thread.currentThread().getName() + ":" + name);
                object.notifyAll();
                System.out.println(times);
            }
        }
    }

    public static void main(String[] args) {
        PrintABCNew loopThread = new PrintABCNew(10);
        new Thread(() -> {
            loopThread.printLetter("A", 0);
        }).start();
        new Thread(() -> {
            loopThread.printLetter("B", 1);
        }).start();
        new Thread(() -> {
            loopThread.printLetter("C", 2);
        }).start();
    }
}

