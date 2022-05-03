package cn.jzh.java.type;

import java.util.ArrayList;

public class TypeTest {
    public static void main(String[] args) {
        System.out.println(new PersonListType().getType()); // java.util.ArrayList<cn.jzh.java.type.Person>

        // 使用匿名类则不需要PersonListType了，代码更加简洁
        System.out.println(new TypeToken<ArrayList<Person>>(){}.getType()); // java.util.ArrayList<cn.jzh.java.type.Person>

        System.out.println(new TypeToken<Person>(){}.getType()); // class cn.jzh.java.type.Person
    }
}
class PersonListType extends TypeToken<ArrayList<Person>> {}
/*
为什么需要一个TypeToken<T>进行包裹呢，因为有一个方法getGenericSuperclass可以获得包含了参数类型的父类
用一个类继承于TypeToken<T>, 指定T为自定义的参数类型如ArrayList<Person>，
通过调用getGenericSuperclass获取父类，
把父类强制转换为ParameterizedType类型，即带参数类型，即可调用对应方法获取参数
*/

