package com.jzh;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        Test t = new Test();
        FutureTask ft = new FutureTask(t);
        new Thread(ft).start();
        try {
            Object x = ft.get();
            System.out.println("总和为：");
            System.out.println(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Test implements Callable{
    int sum;
    @Override
    public Object call() throws Exception {
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
