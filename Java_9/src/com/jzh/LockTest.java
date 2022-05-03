package com.jzh;

import java.util.concurrent.locks.ReentrantLock;

class MThread3 implements Runnable{
    Object obj = new Object();
    private int ticket = 100;
    // Mutex Lock and Reentrant Lock 互斥锁和可重入锁
    ReentrantLock lock  = new ReentrantLock(true);//若为继承形式的，lock要声明为static
    public void run () {
        while (true) {
            try {
                lock.lock();
                if (ticket <= 0) break;
                else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "购得票号为" + ticket);
                    ticket--;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        MThread3 m = new MThread3();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        Thread t3 = new Thread(m);
        t1.setName("从窗口一");
        t2.setName("从窗口二");
        t3.setName("从窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
