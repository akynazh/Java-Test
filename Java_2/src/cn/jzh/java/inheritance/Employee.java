package cn.jzh.java.inheritance;

import java.util.Objects;

public class Employee {
    private int mAge;
    private double mSalary;
    private String mName;

    public double getmSalary() {
        return mSalary;
    }

    public int getmAge() {
        return mAge;
    }

    public String getmName() {
        return mName;
    }

    public Employee(String name, int age, double salary) {
        this.mName = name;
        this.mAge = age;
        this.mSalary = salary;
    }

    /*
     * 编写一个完美的equals方法的建议：
     * 1.显式参数命名为otherObject，稍后将它强制转换为另一个名为other的变量
     * 2.检测this与otherObject是否相等
     * 3.检测otherObject是否为null
     * 4.比较this与otherObject的类，如果equals的语义可以在子类中改变，就使用getclass检测
     *                           如果所有的子类都有相同的相等性语义，就使用instanceof检测
     * 5.将otherObject强制转换为相应类类型的变量
     * 6.使用==比较基本类型字段 使用Object.equals比较对象字段
     * */
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;//地址
        if (otherObject == null) return false;
        /*
         * 如果子类有自己的相等性概念，则必须使用getClass检测
         * 如果只由超类决定相等性概念，就可以使用instanceof检测，这样可以实现在不同子类对象之间进行相等性比较
         * */
        //if(!(otherObject instanceof Classname))   return false;
        if (getClass() != otherObject.getClass()) return false;

        //现在我们知道otherObject是一个non-null Employee

        //将Object类型的otherObject强制转换为相应类类型（Employee）的变量
        var other = (Employee) otherObject;
        return Objects.equals(mName, other.mName) && mSalary == other.mSalary && mAge == other.mAge;
    }

    // 重写equals是 在两个对象某些字段相等时就认定两个对象相等 的情况下进行的
    // 因此重写equals最好要重写hashcode()，对需要进行比较的部分字段进行hash()
    // 这样是为了提高程序的效率，比如当向集合中插入元素时，会先进行hashcode的比较，如果不同，那没就不必在进行equals的比较了，这样就大大减少了equals比较的次数
    public int hashcode() {
        return Objects.hash(mName, mAge, mSalary);
    }

    public String toString() {
        return getClass().getName() + "[name = " + mName + ", salary = " + mSalary + ", age = " + mAge + "]";
    }
}
