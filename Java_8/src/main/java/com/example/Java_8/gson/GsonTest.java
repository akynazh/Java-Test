package com.example.Java_8.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class GsonTest {
    public static void main(String[] args) {
        Person p = new Person(1, "jzh");
        System.out.println("p: " + p);
        Gson gson = new Gson();
        String p_json = gson.toJson(p);
        System.out.println("p_json" + p_json);
        Person p1 = gson.fromJson(p_json, Person.class);
        System.out.println("p1:" + p1);

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(1, "jzh"));
        people.add(new Person(2, "zh"));
        people.add(new Person(3, "z"));
        System.out.println("people:" + people);
        String ps_json = gson.toJson(people);
        System.out.println("ps_json" + ps_json);

        ArrayList<Person> people1 = gson.fromJson(ps_json, new TypeToken<ArrayList<Person>>() {
        }.getType());
        System.out.println("people1" + people1);
        // people1[Person{age=1, name='jzh'}, Person{age=2, name='zh'}, Person{age=3, name='z'}]

        people1 = gson.fromJson(ps_json, new MyType().getType());
        System.out.println("people1" + people1);
        // people1[Person{age=1, name='jzh'}, Person{age=2, name='zh'}, Person{age=3, name='z'}]
        System.out.println("---------------------------------------------------------------------------------");

        ArrayList<Person> people2 = gson.fromJson(ps_json, people.getClass());
        System.out.println(people2);
        // [{age=1.0, name=jzh}, {age=2.0, name=zh}, {age=3.0, name=z}]
        // 显然没有转化为Array<Person> 1.0 <- 1

        System.out.println(new TypeToken<ArrayList<Person>>(){}.getType()); // java.util.ArrayList<com.example.Java_8.gson.Person>
        System.out.println(new TypeToken<ArrayList<Person>>(){}.getRawType()); // class java.util.ArrayList
    }
}
class MyType extends TypeToken<ArrayList<Person>> {}
