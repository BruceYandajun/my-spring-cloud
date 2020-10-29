package com.github.bruce.algorithm;

/**
 * 实现斐波那契数列
 * 1 1 2 3 5 8 11 19 ...
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.print(recursion(6));
    }

    /**
     * 递归方式实现
     */
    private static int recursion(int n) {
        if (n <= 1) {
            return n;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    /**
     * 迭代方式实现
     */
    private static int iteration(int n) {
       if (n <= 1) {
           return n;
       }
       int current = 0;
       int first = 0;
       int second = 1;
       for (int i = 2; i <= n; i ++) {
            current = first + second;

       }
       return sum;
    }
}
