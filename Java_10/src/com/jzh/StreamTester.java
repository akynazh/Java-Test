package com.jzh;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTester {
    @Test
    public void test1() {

        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    @Test
    public void test2() {
        Person p1 = new Person(10, "a");
        Person p2 = new Person(15, "b");
        Person p3 = new Person(17, "c");
        Person p4 = new Person(18, "e");
        Person p5 = new Person(20, "p");
        Person p6 = new Person(31, "u");
        Person p7 = new Person(28, "v");
        List<Person> people = Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
        System.out.println(people);
        List<Person> filterPeople = people.stream().filter(t -> t.getAge() >= 18).collect(Collectors.toList());
        System.out.println(filterPeople);
    }

    @Test
    public void test3() {
        //统计
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
        long l = list.stream().distinct().count();
        //distinct去重 作用于类需要重写equals和hashcode方法
        System.out.println("No. of distinct elements:" + l);
        String output = list.stream().distinct().collect(Collectors.joining(" "));
        System.out.println(output);
    }

    @Test
    public void test5() {

    }

    class Person {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age);
        }
    }

}

