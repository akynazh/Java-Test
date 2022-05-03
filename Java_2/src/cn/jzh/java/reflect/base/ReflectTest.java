package cn.jzh.java.reflect.base;

import java.lang.reflect.*;

public class ReflectTest {

    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Class c1 = Class.forName("cn.jzh.java.reflect.base.Person");
        System.out.println(c1.getName()); // cn.jzh.java.Reflect.base.Person
        System.out.println(c1); // class cn.jzh.java.Reflect.base.Person
        System.out.println("---------------------");
        Field[] fields1 = c1.getFields();
        for (Field i : fields1) {
            System.out.println(i); // public int cn.jzh.java.Reflect.base.Person.a
        }
        System.out.println("---------------------");
        Field[] fields2 = c1.getDeclaredFields();
        for (Field i : fields2) {
            System.out.println(i);
            /*
               public int cn.jzh.java.Reflect.base.Person.a
               protected int cn.jzh.java.Reflect.base.Person.b
               int cn.jzh.java.Reflect.base.Person.c
               private int cn.jzh.java.Reflect.base.Person.d
            */
        }
        System.out.println("---------------------");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor i : constructors) {
            System.out.println(i);
        }
        /*
        public cn.jzh.java.Reflect.base.Person()
        public cn.jzh.java.Reflect.base.Person(int,int,int,int)
         */
        System.out.println("---------------------");
        Constructor constructor = c1.getConstructor(int.class, int.class, int.class, int.class);
        System.out.println(constructor); // public cn.jzh.java.Reflect.base.Person(int,int,int,int)
        Object p1 = constructor.newInstance(1, 2, 3, 4);
        System.out.println(p1.toString()); // Person{a=1, b=2, c=3, d=4}
        System.out.println("---------------------");
        Method m1 = c1.getMethod("setA", int.class);
        System.out.println(m1); // public int cn.jzh.java.Reflect.base.Person.setA()
        Integer t = 100;
        m1.invoke(p1, 100);
        System.out.println(p1.toString()); // Person{a=100, b=2, c=3, d=4}


    }


}
/*
*   记忆：上三角
*            类内部    本包    子类    外部包
* public      yes     yes    yes    yes
* protected   yes     yes    yes    no
* default     yes     yes    no     no
* private     yes     no     no     no
* */
class Person{
    public int a;
    protected int b;
    int c;
    private int d;

    public Person() {
    }

    public Person(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Person{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
