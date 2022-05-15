package cn.jzh.java.reflect.use;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args)  {
        Properties pro = new Properties();
        InputStream is = null;
        try {
            //properties必须相对于src，所以只需指定相对路径
            // is = ReflectTest.class.getClassLoader().getResourceAsStream("pro.properties");

            is = new FileInputStream("Java_2/src/pro.properties");
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String className1 = pro.getProperty("className1");
        String methodName1 = pro.getProperty("methodName1");
        String className2 = pro.getProperty("className2");
        String methodName2 = pro.getProperty("methodName2");
        /*
        ？ 表示不确定的java类型。
        T  表示java类型。
        K V 分别代表java键值中的Key Value。
        E 代表Element。
        实际上字母可以任意指定
        */
        try {
            Class<?> cls1 = Class.forName(className1);
            Object obj = cls1.getDeclaredConstructor().newInstance();
            Method med = cls1.getMethod(methodName1);
            med.invoke(obj);

            Class<?> cls2 = Class.forName(className2);
            obj = cls2.getDeclaredConstructor().newInstance();
            med = cls2.getMethod(methodName2);
            med.invoke(obj);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
