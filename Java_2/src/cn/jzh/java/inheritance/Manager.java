package cn.jzh.java.inheritance;

public class Manager extends Employee{
    private double mBonus;
    public Manager(String name, int age, double salary, double bonus){
        super(name, age, salary);
        mBonus = bonus;
    }
    public double getmBonus() {
        return mBonus;
    }
}
