package cn.jzh.java;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger big_num1 = new BigInteger("451651651651651651651651841651");
        BigInteger big_num2 = new BigInteger("51615841616518416526525815615615");
        BigInteger big_num3 = big_num2.multiply(big_num1);
        System.out.println(big_num3);
        BigInteger big_num4 = big_num1.subtract(big_num2);
        System.out.println(big_num4);
        BigInteger big_num5 = big_num4.add(BigInteger.valueOf(10));
        System.out.println(big_num5);
        BigInteger sum = BigInteger.valueOf(1);
        for (int i = 1; i <= 50; i++)
            sum = sum.multiply(BigInteger.valueOf(i));
        System.out.println("sum = " + sum);
    }
}

