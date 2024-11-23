package com.rongsimin.leetcode.editor.cn.honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 标题：排成一条线的纸牌博弈问题
 *
 * @author rsm
 * @date 2023/11/26 19:21
 */
public class TwoPeoplePlayCard2 {

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
        for (int i = 0; i < len; i++) {
            f[i][i] = nums[i];
        }


        for (int k = 0; k < len; k++) {
            int i = 0;
            int j = k + 1;
            while (i < len && j < len) {
                f[i][j] = Math.max(nums[i] + s[i + 1][j], nums[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
                i++;
                j++;
            }
        }

        System.out.println(Math.max(f[0][len - 1], s[0][len - 1]));
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
