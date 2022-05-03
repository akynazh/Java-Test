package cn.jzh.java.inheritance;
//抽象类
public abstract class Person {
    //抽象方法
    public abstract String getDescription();
    private String mName;
    public Person(String name){
        this.mName = name;
    }
    public String getmName(){
        return mName;
    }
}
