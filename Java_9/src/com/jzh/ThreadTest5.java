package com.jzh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadTest5 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
//        numberThread1 t1 = new numberThread1();
//        Thread t = new Thread(t1);
//        service.execute(t);
        service.execute(new numberThread1());
        service.execute(new numberThread2());
        service.shutdown();
    }
}

class numberThread1 implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class numberThread2 implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
