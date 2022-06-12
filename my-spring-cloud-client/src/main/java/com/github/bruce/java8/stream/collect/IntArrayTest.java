package com.github.bruce.java8.stream.collect;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class IntArrayTest {
    public static void main(String[] args) {
        int[] a =  new int[] {1, 1, 7, 7, 7, 7, 2};
        // 输出7，1，2
        List<Integer> collect = IntStream.of(a).boxed().collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream().sorted(comparingLong(e -> {
                    Entry entry = (Entry) e;
                    Object value = entry.getValue();
                    return (Long) value;
                }).reversed())
                .map(Entry::getKey).collect(toList());
        System.out.println(collect);
    }
}
