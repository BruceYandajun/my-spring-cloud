package com.github.bruce.algorithm;

public class Test {
    public static void main(String[] args) {

    }

    public static double search(int n) {
        int slow = 1;
        int high = n;
        int target = 0;
        while(slow <= high) {
            target = (high + slow) / 2;
            if (target * target < n ) {
                slow = target + 1;
            } else if (target * target > n) {
                high = target - 1;
            } else {
                return target;
            }
        }
        return target;
    }
}
