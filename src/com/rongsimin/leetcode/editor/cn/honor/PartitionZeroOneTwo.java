package com.rongsimin.leetcode.editor.cn.honor;

import java.util.Arrays;

/**
 * @author rsm
 * @date 2023/11/24 17:21
 */
public class PartitionZeroOneTwo {
    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 1, 2, 1, 0, 0};
        helper(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void helper(int[] arr) {
        // [0,lt) 是0
        // [gt, n -1] 是2
        int lt = 0;
        int gt = arr.length;
        for (int i = 0; i < gt; ) {
            if (arr[i] < 1) {
                swap(arr, i, lt);
                i++;
                lt++;
            } else if (arr[i] > 1) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
