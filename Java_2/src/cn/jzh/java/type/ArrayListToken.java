package cn.jzh.java.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ArrayListToken<T> {
    Type type;
    protected ArrayListToken() {
        this.type = getSuperclassTypeParameter(getClass());
    }
    private Type getSuperclassTypeParameter(Class<?> clazz) {
        Type superclass = clazz.getGenericSuperclass();
        ParameterizedType p_type = (ParameterizedType) superclass;
        return p_type.getActualTypeArguments()[0];
    }
    public Type getType() {
        return type;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayListToken<Person>(){}.getType());
    }
}
