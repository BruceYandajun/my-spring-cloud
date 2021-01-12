package com.github.bruce.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序：不稳定
 * 时间复杂度：O(nlogn)
 */
public class QuickSort {
    private static int[] nums = {6, 10, 2, 5, 7};

    public static void main(String[] args) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    private static int partition(int[] a, int begin, int end) {
        int counter = begin;
        for (int i = begin; i < end; i ++) {
            if (a[i] < a[end]) {
                Sorts.swap(a, counter, i);
                counter ++;
            }
        }
        Sorts.swap(a, counter, end);
        return counter;
    }
}
