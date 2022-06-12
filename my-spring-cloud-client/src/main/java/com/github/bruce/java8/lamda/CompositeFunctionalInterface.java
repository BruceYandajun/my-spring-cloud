package com.github.bruce.java8.lamda;

import com.github.bruce.java8.methodReference.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;


public class CompositeFunctionalInterface {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(1, "green", "Bruce"),
                new Apple(6, "red", "John"),
                new Apple(3, "yellow", "Jack"),
                new Apple(3, "white", "Jack"),
                new Apple(7, "white", "Jack")
                );
        // 先按重量倒叙排列，如果重量一样，按颜色字幕顺序正向排列
        apples.stream().sorted(comparingInt(Apple::getWeight).reversed().thenComparing(Apple::getColor)).forEach(System.out::println);
        System.out.println("-------------------");
        // 筛选出Jack或John拥有的重量大于5的苹果(注意and、or的计算顺序是从左向右的优先级，a.or(b).and(c)可以看作(a || b) && c)
        Predicate<Apple> predicate = o -> o.getOwner().equals("Jack");
        predicate = predicate.or(o -> o.getOwner().equals("John")).and(o -> o.getWeight() > 5);
        apples = apples.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(apples);
    }
}
