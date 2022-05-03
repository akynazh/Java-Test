package cn.jzh.java;

import org.junit.Test;

import java.time.*;

public class CalendarTest {
    @Test
    public void test1() {
        LocalDate date = LocalDate.now();
        System.out.println(date);//2021-03-21
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        System.out.println(year);//2021
        System.out.println(month);//3
        System.out.println(day);//21
    }

    @Test
    public void test2() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        int value = date.getDayOfWeek().getValue();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) System.out.println("   ");
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == day) System.out.print("*");
            else System.out.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();
    }
    /*
    Mon Tue Wed Thu Fri Sat Sun
      1   2   3   4   5   6   7
      8   9  10  11  12  13  14
     15  16  17  18  19  20  21*
     22  23  24  25  26  27  28
     29  30  31
    */
}

