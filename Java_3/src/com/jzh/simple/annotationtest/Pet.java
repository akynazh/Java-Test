package com.jzh.simple.annotationtest;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/7/24 17:51
 */
@PetInfo(name = "mark", color = PetColor.RED)
public class Pet {
    @IPetType(value = "dog")
    private String type;
}
