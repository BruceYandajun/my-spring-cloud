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
            int current = nums[i];
            int j = i;
            for (; j > 0 && current < nums[j - 1]; j --) {
                nums[j] = nums[j - 1];
            }
            nums[j] = current;
        }
        System.out.println(Arrays.toString(nums));
    }
}
