package com.github.bruce.algorithm.arrays;

import java.util.Arrays;

/**
 * 两个无序数组，求两者之间差值的绝对值最小的数
 * 如：{9, 5, 20} 与 {4, 1, 80}，最小的差绝对值是1 = |5 - 4|
 */
public class MinAbsOfTwoArray {
    public static void main(String[] args) {
        int[] a = {9, 5, 20};
        int[] b = {1, 4, 80};
        System.out.println(minAbs(a, b));
    }

    private static int minAbs(int[] a, int[] b) {
        // 先排序
        Arrays.sort(a);
        Arrays.sort(b);
        // 双指针法
        int i = 0;
        int j = b.length - 1;
        int pre = Math.abs(a[i] - b[j]);
        while (i < a.length && j >= 0) {
            int x = i;
            int y = j;
            if (Math.abs(a[i] - b[j]) > pre) {
                return pre;
            }
            if (a[i] == b[j]) {
                return 0;
            } else if (a[i] < b[j]) {
                if (j > 0) {
                    j --;
                } else {
                    i ++;
                }
            } else {
                i ++;
            }
            pre  = Math.abs(a[x] - b[y]);
        }
        return pre;
    }
}
