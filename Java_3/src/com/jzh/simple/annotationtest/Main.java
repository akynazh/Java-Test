package com.jzh.simple.annotationtest;

import java.lang.reflect.Field;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/7/24 17:53
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<Pet> petClass = Pet.class;
        IPetType type = petClass.getDeclaredField("type").getAnnotation(IPetType.class);
        System.out.println(type.value());
        PetInfo petInfo = petClass.getAnnotation(PetInfo.class); // 返回一个代理$Proxy对象
        System.out.println(petInfo);
        System.out.println(petInfo.name() + "\t" + petInfo.color());
    }
}
