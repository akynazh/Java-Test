package com.jzh;

class MThread1 implements Runnable{
    Object obj = new Object();
    private int ticket = 100;
    public void run () {
        //synchronized(obj) //错误放置的位置！同步锁必须放在包含共享对象的同步块中!
       // {
            while (true) {
                //同步锁     同步监听器
                //若为继承式的则obj也要声明为static
                synchronized (obj) {
                    if (ticket <= 0) break;
                    else {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "购得票号为" + ticket);
                        ticket--;
                    }
                }
            }
       // }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MThread1 m = new MThread1();
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
