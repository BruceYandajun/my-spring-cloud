package com.github.bruce.base.collections.lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSortTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, -1);
        Collections.sort(list);
        System.out.println(list);
    }
}

