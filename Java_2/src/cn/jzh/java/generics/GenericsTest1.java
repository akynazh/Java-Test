package cn.jzh.java.generics;

import org.junit.Test;

import java.util.*;

public class GenericsTest1 {
    @Test
    public void test1() {
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();
        name.add("jzh");
        age.add(19);
        number.add(100);
        getData(name);
        getData(age);
        getData(number);
        getData1(name);
        getData1(age);
        getData1(number);
    }
    /*
    ?是通配符，泛指所有类型。
    T代表一种类型
     */
    public void getData(List<?> data) {
        System.out.println(data.get(0));
    }
    public <B> void getData1(List<B> data) {
        System.out.println(data.get(0));
    }
}
