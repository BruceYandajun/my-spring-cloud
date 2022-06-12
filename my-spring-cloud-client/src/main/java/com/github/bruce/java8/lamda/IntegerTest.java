package com.github.bruce.java8.lamda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * <p>
 * </p>
 * DATE 2/12/18.
 *
 * @author yandajun.
 */
public class IntegerTest {
    public static void main(String[] args) {
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        System.out.println(primes);
        IntSummaryStatistics stats = primes.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
        List<Integer> addTenForEach = primes.stream().map(n -> n += 10).collect(Collectors.toList());
        System.out.println(addTenForEach);
        primes.forEach(n -> n += 10);
        System.out.println(addTenForEach);
    }
}
