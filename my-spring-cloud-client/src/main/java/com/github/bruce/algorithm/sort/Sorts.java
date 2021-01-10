package com.github.bruce.algorithm.sort;

public class Sorts {

    /**
     * 交换两数
     */
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
