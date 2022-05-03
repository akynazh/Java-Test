package com.jzh;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class ParallelTest {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            int a = r.nextInt() % 100;
            values.add(a);
        }

        long sum = values.parallelStream()
                .mapToLong(i -> i)
                .sum();
        System.out.println(sum);

        long count = values.parallelStream()
                .mapToInt(i -> i)
                .count();
        System.out.println(count);

        long count1 = values.parallelStream()
                .mapToInt(i -> i)
                .filter(t -> t >= 50)
                .count();
        long count2 = values.parallelStream()
                .mapToInt(i -> i)
                .filter(t -> t < 50)
                .count();
        System.out.println(count1);
        System.out.println(count2);

        Optional<Integer> max = values.stream()
                .filter(i -> i > 50)
                .max(Comparator.comparing(a -> a));
        System.out.println(max.get());

    }
}
