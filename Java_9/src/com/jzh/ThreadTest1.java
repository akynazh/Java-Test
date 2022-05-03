package com.jzh;

class myThread1 extends Thread{
    public void run(){
        for(int i = 0; i <= 50; i++){
            if(i % 2 != 0)
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class myThread2 extends Thread{
    public void run(){
        for(int i = 0; i <= 50; i++){
            if(i % 2 == 0)
            System.out.println(Thread.currentThread().getName() + i);
            if(i % 20== 0){
                Thread.yield();
                //线程让步，只是一时间让了占用cpu优先权，之后又可能会夺回优先权
            }
        }
    }
}

public class ThreadTest1{
    public static void main(String[] args) throws InterruptedException {
        var t1 = new myThread1();
        var t2 = new myThread2();
        t1.setName("线程1：");
        t2.setName("线程2：");
        Thread.currentThread().setName("主线程：");
//        t1.setPriority(10);
//        t2.setPriority(1);
//        Thread.currentThread().setPriority(5);
        t1.start();
        t2.start();
        //匿名操作
//        new Thread(){
//            public void run() {
//                for (int i = 0; i < 50; i++) {
//                    if(i % 4 == 0)
//                    System.out.println(Thread.currentThread().getName() + ":" + i);
//                }
//            }
//        }.start();
        for(int i = 0; i <= 50; i++){
            System.out.println(Thread.currentThread().getName() + i);
            if(i == 20) t1.join();
            //调用t1,则t1执行完后才继续
            if(i >= 40) Thread.sleep(1000);
        }
    }
}