package com.github.bruce.base.collections.lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListSortTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-1, 2, 3);
        Collections.sort(list);
        System.out.println(list);
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);

        int[] a = new int[] {2, -2, 3};
        Arrays.sort(a);
        for(int i : a) System.out.print(i + " ");
    }
}

