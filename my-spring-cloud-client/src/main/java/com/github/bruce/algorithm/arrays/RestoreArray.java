package com.github.bruce.algorithm.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RestoreArray {

    public static void main(String[] args) {
        int[] array = {0, 0, 0, 3};
        System.out.println(Arrays.toString(restore(array)));
    }

    /**
     * 给定一个整形数组，每个元素存储的是前面比他小的个数，需要还原该数组；
     * 原数组是包含1 到 n的连续正整数（无序）；
     * 举例：输入0，1，1，0，输出原数组 2，4，3，1，
     * 没写出来 [Smirk]，感兴趣的可以写一写
     */

    private static int[] restore(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < len; i ++) {
            list.add(i + 1);
        }
        for (int i = len - 1; i >= 0; i --) {
            res[i] = list.remove(a[i]);
        }
        return res;
    }

}
