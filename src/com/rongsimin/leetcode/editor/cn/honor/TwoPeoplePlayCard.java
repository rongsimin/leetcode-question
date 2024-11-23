package com.rongsimin.leetcode.editor.cn.honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author rsm
 * @date 2023/11/26 19:21
 */
public class TwoPeoplePlayCard {

    private static int[][] f;
    private static int[][] s;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(bf.readLine());
        int[] nums = new int[len];
        String[] input = bf.readLine().split(" ");
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        f = new int[nums.length][nums.length];
        s = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(f[i], -1);
            Arrays.fill(s[i], -1);
        }
        System.out.println(Math.max(first(nums, 0, nums.length - 2), first(nums, 1, nums.length - 1)));
    }

    private static int first(int[] nums, int i, int j) {
        if (i == j) {
            f[i][j] = nums[i];
            return f[i][j];
        }
        if (f[i][j] != -1) {
            return f[i][j];
        }
        f[i][j] = Math.max(nums[i] + last(nums, i + 1, j), nums[j] + last(nums, i, j - 1));
        return f[i][j];
    }

    private static int last(int[] nums, int i, int j) {
        if (i == j) {
            s[i][j] = 0;
            return s[i][j];
        }
        if (s[i][j] != -1) {
            return s[i][j];
        }
        s[i][j] = Math.min(first(nums, i + 1, j), first(nums, i, j - 1));
        return s[i][j];
    }
}
