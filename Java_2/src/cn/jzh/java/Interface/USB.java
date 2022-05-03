package cn.jzh.java.Interface;

public interface USB {
    void open();

    void close();

    public final int NUM = 1;//接口中只有成员常量！
    int NUM1 = 2;//且默认为成员常量

    static void A() {
        System.out.println("JDK8新特性");
    }

    default void B() {
        System.out.println("JDK8新特性");
    }

    private void C() {
        System.out.println("JDK9新特性");
    }
}
//类与接口可以实现多实现
//接口与接口可以实现多继承