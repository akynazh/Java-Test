package cn.jzh.java.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeToken<T> {
    final Type type;

    protected TypeToken() {
        this.type = getSuperclassTypeParameter(getClass());
    }

    /*
       clazz: "class cn.jzh.java.Type.TypeTest$1"（$* 是.class保存 匿名内部类的文件）
       不使用内部类则为
       clazz: "class cn.jzh.java.Type.TypeTest.TypeToken<java.util.ArrayList<cn.jzh.java.Type.Person>>
    */
    private Type getSuperclassTypeParameter(Class<?> clazz) {
        // superclass : cn.jzh.java.Type.TypeToken<java.util.ArrayList<cn.jzh.java.Type.Person>>
        Type superclass = clazz.getGenericSuperclass(); // 从一个Class对象中，获取该对象父类接收到的参数化类型（泛型）
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter."); // 不是带参数类型
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        // 强制转换为ParameterizedType类型，即带参数类型，可以调用对应方法获取参数
        // parameterized : cn.jzh.java.Type.TypeToken<java.util.ArrayList<cn.jzh.java.Type.Person>>
        return parameterized.getActualTypeArguments()[0];
        // 获取第一个参数，即java.util.ArrayList<cn.jzh.java.Type.Person>
    }

    public Type getType() {
        return type;
    }
}

class Person {
}