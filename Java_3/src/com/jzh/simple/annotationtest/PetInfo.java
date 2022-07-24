package com.jzh.simple.annotationtest;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PetInfo {
    String name() default "";
    PetColor color() default PetColor.WHITE;
}
