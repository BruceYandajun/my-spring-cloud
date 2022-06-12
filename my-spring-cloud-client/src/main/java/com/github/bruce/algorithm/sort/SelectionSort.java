package com.github.bruce.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序：不稳定
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class SelectionSort {

    private static int[] nums = {6, 10, 2, 5, 7};

    public static void main(String[] args) {
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] > nums[j]) {
                    Sorts.swap(nums, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
