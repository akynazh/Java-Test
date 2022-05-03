package com.jzh;

import static java.lang.Thread.sleep;

class MyThread4 implements Runnable {
    int num = 1;

    @Override
    //wait,notify,notifyAll必须用在同步代码块中，且他们是object下的
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (num <= 100) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                } else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadTest4 {
    public static void main(String[] args) {
        MyThread4 m = new MyThread4();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        t1.setName("男");
        t2.setName("女");
        t1.start();
        t2.start();
    }
}

