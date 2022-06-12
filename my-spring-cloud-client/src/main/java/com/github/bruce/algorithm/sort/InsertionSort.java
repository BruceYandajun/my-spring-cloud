package com.github.bruce.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序：稳定
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class InsertionSort {
    private static int[] nums = {6, 10, 2, 5, 7};

    public static void main(String[] args) {
        for (int i = 1; i < nums.length; i ++) {
            for (int j = i; j > 0; j --) {
                if (nums[j] < nums[j - 1]) {
                    Sorts.swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
