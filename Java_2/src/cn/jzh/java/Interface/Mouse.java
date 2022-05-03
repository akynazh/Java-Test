package cn.jzh.java.Interface;

//接口的子类若是普通类，则必须重写所有抽象方法
//接口 ~ 抽象父类
public class Mouse implements USB, USB1{
    public void open(){
        System.out.println("打开鼠标！");
    }
    public void close(){
        System.out.println("关闭鼠标！");
    }
    public void open1(){
        System.out.println("打开鼠标1！");
    }
}
