package com.github.bruce.algorithm.search;

/**
 * 二分查找
 * 时间复杂度：logn
 */
public class BinarySearch {

    private static int[] nums = {2, 5, 6, 7, 10};

    public static void main(String[] args) {
        int target = 1;
        System.out.println(binarySearch(nums, target));
    }

    private static int binarySearch(int[] a, int target) {
        int left = 0, right = a.length - 1, pivot;
        while (left <= right) {
            pivot = (left + right) / 2;
            if (a[pivot] == target) {
                return pivot;
            } else if (target > a[pivot]) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }
}
