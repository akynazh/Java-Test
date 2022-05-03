package cn.jzh.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTest {
    @Test
    public void test1() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) a[i] = i;
        int[] b;
        b = Arrays.copyOf(a, 2 * a.length);
        for (int e : b)
            System.out.print(e + " "); // 0 1 2 3 4 5 6 7 8 9 0 0 0 0 0 0 0 0 0 0
        System.out.println();
        for (int i = 0; i < 10; i++)
            a[i] = (int) (Math.random() * 100);//两个括号都要加！！
    }

    @Test
    public void test2() {
        int[][] square = new int[5][5];
        int p = 3;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                square[i][j] = p;
                p++;
            }
        System.out.println(Arrays.deepToString(square));
        // [[3, 4, 5, 6, 7], [8, 9, 10, 11, 12], [13, 14, 15, 16, 17], [18, 19, 20, 21, 22], [23, 24, 25, 26, 27]]
    }

    @Test
    public void test3() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) arrayList.add(i);
        arrayList.forEach(item-> System.out.print(item + " "));
    }
}
