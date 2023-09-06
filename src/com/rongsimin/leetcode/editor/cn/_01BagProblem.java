package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author rsm
 * @date 2023/9/4 9:01
 */
public class _01BagProblem {
    private static int[][] memo;

    public static int bag02(int[] weights, int[] values, int capacity) {
        if (weights.length != values.length || capacity == 0 || weights.length == 0) {
            return 0;
        }
        memo = new int[weights.length][capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return getMaxValue(0, weights, values, capacity);
    }

    public static int bag01Advance(int[] weights, int[] values, int capacity) {
        if (weights.length != values.length || weights.length == 0) {
            return 0;
        }
        // dp[i] 表示 物品从[0,i],可以存放的不超过容量c的最大物品价值
        // base case
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i >= weights[0] ? values[0] : 0;
        }
        // dp[i] = Math.max(dp[i - 1][c], (c >= weights[i] ? dp[i - 1][c - weights[i]] + values[i] : 0));
        for (int i = 1; i < weights.length; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[capacity];
    }

    public static int bag01(int[] weights, int[] values, int capacity) {
        if (weights.length != values.length || weights.length == 0) {
            return 0;
        }
        // dp[i][c] 表示 物品从[0,i],可以存放的不超过容量c的最大物品价值
        // dp[i][c] = Math.max(dp[i - 1][c], (c >= weights[i] ? dp[i - 1][c - weights[i]] + values[i] : 0))
        int[][] dp = new int[weights.length][capacity + 1];
        for (int i = 0; i < capacity + 1; i++) {
            // base case 只放第一个物品
            dp[0][i] = i >= weights[0] ? values[0] : 0;
        }
        for (int i = 1; i < weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], (j >= weights[i] ? dp[i - 1][j - weights[i]] + values[i] : 0));
            }
        }
        return dp[weights.length - 1][capacity];
    }

    /**
     * 返回从start 到 weights.length 可以装入到背包的最大物品价值
     */
    private static int getMaxValue(int start, int[] weights, int[] values, int capacity) {
        if (start >= weights.length) {
            return 0;
        }
        if (memo[start][capacity] != -1) {
            return memo[start][capacity];
        }
        // 只有两种可能，一是没装start,二是装了start
        memo[start][capacity] = getMaxValue(start + 1, weights, values, capacity);
        if (capacity >= weights[start]) {
            memo[start][capacity] = Math.max(memo[start][capacity], values[start] + getMaxValue(start + 1, weights, values, capacity - weights[start]));
        }
        return memo[start][capacity];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3};
        int[] value = new int[]{6, 10, 12};
        //System.out.println(bag01(weights, value, 0));
        System.out.println(bag01Advance(weights, value, 1));
        System.out.println(bag01Advance(weights, value, 2));
        System.out.println(bag01Advance(weights, value, 3));
        System.out.println(bag01Advance(weights, value, 4));
        System.out.println(bag01Advance(weights, value, 5));
    }
}
