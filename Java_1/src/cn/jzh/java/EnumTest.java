package cn.jzh.java;

import org.junit.Test;

import java.util.*;
public class EnumTest {
    @Test
    public void test1() {
        for (Color color : Color.values()) {
            System.out.println(color.ordinal() + ":" +color);
        }
        Color c1 = Color.BLACK;
        System.out.println(c1.ordinal() + ":" + c1);
        try {
            Color b = Color.valueOf("B");
            System.out.println(b);
        } catch (IllegalArgumentException e) {
            System.out.println("不存在该枚举对象");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size:(SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        try {
            Size size = Enum.valueOf(Size.class, input);
            System.out.println("abbreviation = " + size.getAbbreviation());
        } catch (Exception e) {
            System.out.println("不存在该枚举对象");
        }
    }
}

enum Color {
    GREEN, RED, BLACK, WHITE
}
enum Size{
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    //enum[SMALL, MEDIUM, LARGE, EXTRA_LARGE]
    Size(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }
    private final String abbreviation;//abbreviation即缩写的意思
}
