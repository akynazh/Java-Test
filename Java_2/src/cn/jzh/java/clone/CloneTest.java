package cn.jzh.java.clone;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 Java不提供克隆(复制)对象的自动机制。

 克隆对象意味着逐位复制对象的内容。

 要支持克隆操作，必须在类中实现clone()方法。
 */
public class CloneTest {
    @Test
    public void test1() {
        var original = new CloneEmployee("john", 50000);
        original.setHireDay(2000, 1, 1);

        CloneEmployee copy = null;
        try {
            copy = original.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(copy == original); // false
        copy.raiseSalary(10);
        copy.setHireDay(2002, 12, 31);

        System.out.println("original = " + original);
        System.out.println("copy = " + copy);
    }

    @Test
    public void test2() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0 ; i < 10; i++) arrayList.add(i);
        System.out.println(arrayList);
        try {
            ArrayList<Integer> arrayList1 = (ArrayList<Integer>) arrayList.clone();
            System.out.println(arrayList1);
            System.out.println(arrayList == arrayList1); // false
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class CloneEmployee implements Cloneable {
    //浅拷贝：
    private String name;
    private double salary;

    //深拷贝：对象也拷贝
    private Date hireDay;

    public CloneEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    // 原来super.clone()只是浅拷贝，基本数据类型可以拷贝成功
    // 重写clone()实现深拷贝，将其他类型进行clone
    public CloneEmployee clone() throws CloneNotSupportedException {
        CloneEmployee cloned = (CloneEmployee) super.clone();
        //Object.clone()

        //实现深拷贝
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "CloneEmployee[name = " + name + ", salary = " + salary + ", hireDay = " + hireDay + "]";
    }
}
