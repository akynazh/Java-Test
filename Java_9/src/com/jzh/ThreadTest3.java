package com.jzh;


class MThread2 implements Runnable{
    Object obj = new Object();
    private int ticket = 100;
    public void run () {
        while(ticket > 0)
            show();
    }
    private synchronized void show(){//同步监视器默认为this，若为继承式的，则show方法要加上static
        if(ticket > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "购得票号为" + ticket);
            ticket--;
        }
    }
}

public class ThreadTest3{
    public static void main(String[] args) {
        MThread2 m = new MThread2();
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
