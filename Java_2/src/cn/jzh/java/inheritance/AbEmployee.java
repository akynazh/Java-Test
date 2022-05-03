package cn.jzh.java.inheritance;

public class AbEmployee extends Person{
    private double mSalary;
    public AbEmployee(String name, double salary){
        super(name);
        this.mSalary = salary;
    }
    public double getmSalary(){
        return mSalary;
    }
    public String getDescription(){
        return String.format("an employee with a salary of $%.2f", mSalary);
    }
}
