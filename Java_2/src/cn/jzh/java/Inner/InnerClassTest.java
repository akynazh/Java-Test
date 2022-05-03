package cn.jzh.java.Inner;

import org.junit.Test;

public class InnerClassTest {
    public static void main(String[] args) {
        Tes t1 = new Tes();
        t1.m1();
        // m1 exe
        //m11 exe
        // 0
        Tes.T2 t2 = new Tes.T2();
        t2.m2();
        // m2 exe

        Tes.T3 t3 = t1.new T3();
        t3.m3();
        System.out.println(t3.getAge());
        // m3 exe
        // 0

        Tes.T4 t4 = t1.new T4();
        t4.m4();

        // Tes.T5 t5 = t1.new T5(); // can't
    }
}
class Tes {
    private int data;
    public void m1() {
        System.out.println("m1 exe");
        //局部内部类 只能在定义该内部类的方法内实例化
        class T1 {
            public void m11() {
                System.out.println("m11 exe");
                System.out.println(data);
            }
        }
        T1 t1 = new T1();
        t1.m11();
    }

    //成员内部类

    // 静态成员内部类通过类名.类名实例化
    static class T2 {
        void m2() {
            System.out.println("m2 exe");
        }
    }

    // 其他通过.new 实例化
    class T3 {
        private int age;

        public int getAge() {
            return age;
        }

        public void m3() {
            System.out.println("m3 exe");
        }
    }
    public class T4 {
        private int name;
        public void m4() {
            System.out.println("m4 exe");
        }
    }
    private class T5 {
        private int name;
        private void m5() {
            System.out.println("m5 exe");
        }
    }
}