package com.jzh.simple.annotationtest;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface IPetType {
    String value() default "";
}
