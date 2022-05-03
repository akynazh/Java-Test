package cn.jzh.java.inheritance;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("Bill Gates", 85, 10000000);
        staff[1] = new Employee("Sam Smiths", 38, 99699);
        staff[2] = new Manager("Steve jobs", 56, 658766666, 51565516);
        boolean cmp = staff[0].equals(staff[1]);
        System.out.println(cmp);//false
        System.out.println(staff[0].hashcode());
        for(Employee e : staff)
            System.out.println("name = " + e.getmName() + " age = " + e.getmAge() + " salary = " + e.getmSalary());
            if(staff[2] instanceof Manager) {
                Manager boss = (Manager) staff[2];
                System.out.println(boss.getmName());
            }
            /*
            * 只能在继承层次内进行强制类型转换
            * 在将超类强制转换为子类之前，应该使用instanceof进行检查
            * */
            if(staff[0] instanceof Manager){
                Manager boss1 = (Manager) staff[0];
                System.out.println(boss1.getmName());
            }//no output
        AbEmployee horse = new AbEmployee("Bojack Horseman", 0.826541);
            //Person student = Person("Bob"); //wrong
        System.out.println(horse.getmName() + "is " + horse.getDescription());
        Person girl = new AbEmployee("lala", 0.0);
        /*
        * 一个类被声明为abstract，就不能创建这个类的对象
        * 但可以定义一个抽象类的对象变量，而这个变量只能引用非抽象子类对象
        * */
        System.out.println(girl.getmName() + "is " + girl.getDescription());

        Executive eco = new Executive("Steve Jobs", 56,9e10,8e9,999.999);
        System.out.println(eco.getmName());

        System.out.println(eco.toString());
        System.out.println(staff[0].toString());

        var staffs = new ArrayList<Employee>();
        staffs.ensureCapacity(100);
        staffs.add(new Employee("Hacker", 19, 25000));
        staffs.add(new Employee("Joker", 55, 6566));
        Employee t = staffs.get(0);
        System.out.println(t.toString());
        //staffs.set(2, new Employee("Haru", 2, 6596));//wrong,out of bounds

    }
}
