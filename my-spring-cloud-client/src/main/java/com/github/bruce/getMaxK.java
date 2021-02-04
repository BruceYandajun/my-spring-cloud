package com.github.bruce;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 获取第K大的数
 */
public class getMaxK {
    public static void main(String[] args) {
        Integer[] array = {7, 5, 6, 4, 3};
        System.out.println(getK_quickSort(array, 5));
    }

    /**
     * 借助LinkedList插入排序
     */
    private static int getK_linkedList(int[] array, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int value : array) {
            int j;
            for (j = 0; j < list.size(); j++) {
                if (value > list.get(j)) {
                    list.add(j, value);
                    break;
                }
            }
            if (j == list.size()) {
                list.addLast(value);
            }
        }
        return list.get(k - 1);
    }

    /**
     * Sort快排
     */
    private static int getK_quickSort(Integer[] array, int k) {
        Arrays.sort(array, (a, b) -> a > b ? -1 : 1);
        return array[k - 1];
    }
}
