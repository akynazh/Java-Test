package cn.jzh.java;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CollectionTest {
    @Test
    public void SetTest() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(23);
        treeSet.add(33);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(30);
        treeSet.forEach(System.out::println);
    }

    @Test
    public void QueueTest() {
        ArrayDeque<String> Q = new ArrayDeque<>();
        Q.add("Jane");
        Q.add("Peter");
        Q.add("Mike");
        Q.add("Lily");
        System.out.println(Q.peek());
        Q.pop();
        System.out.println(Q.peek());
    }

    @Test
    public void MapTest() {
        HashMap<String, Employee> staff = new HashMap<>();
        staff.put("144-25", new Employee("Amy"));
        staff.put("232-45", new Employee("Jack"));
        staff.put("932-50", new Employee("Tim"));
        staff.put("454-25", new Employee("Mike"));
        System.out.println(staff);
        staff.remove("144-25");
        System.out.println(staff);
        staff.put("451-85", new Employee("Mark"));
        System.out.println(staff);
        System.out.println(staff.get("451-85"));
        staff.forEach((k,v)-> System.out.println("key = " + k + ", value = " + v));

        for (Map.Entry<String, Employee> m : staff.entrySet()) {
            System.out.println(m.getKey() + "," + m.getValue());
        }
        for (String s : staff.keySet()) {
            System.out.println(s);
        }
        for (Employee s : staff.values()) {
            System.out.println(s);
        }
    }
}

class Employee{
    private String name;
    public Employee(String s){
        this.name = s;
    }

    public String getName() {
        return name;
    }
    public void setName(String s){
        name = s;
    }
    public String toString(){
        return name;
    }
}
