package cn.jzh.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class SortTest {
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(2);
        list.add(132);
        list.add(52);
        list.forEach(i -> System.out.print(i + " "));
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println();
        list.forEach(i -> System.out.print(i + " "));
    }
    @Test
    public void test2() {
        String[] friends = {"PeanutButter", "Mike", "Zoo"};
        Arrays.sort(friends, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for(String e : friends){
            System.out.println(e);
        }
    }
    @Test
    public void test3() {
        User u1 = new User("peter", 21);
        User u2 = new User("mary", 21);
        User u3 = new User("amy", 31);
        User u4 = new User("lucy", 11);
        LinkedList<User> users = new LinkedList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.forEach(i -> System.out.println(i));
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o2.getAge() == o1.getAge()) {
                    return o1.getUsername().length() - o2.getUsername().length();
                }
                return o2.getAge() - o1.getAge();
            }
        });
        users.forEach(i -> System.out.println(i));
    }
}
class User {
    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}