package com.rongsimin.leetcode.editor.cn.honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 最小公倍数
 *
 * @author rsm
 * @date 2023/11/26 17:13
 */
public class MinNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = bf.readLine()) != null) {
            String[] split = str.split(" ");
            int[] nums = new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
            System.out.println(getMinNum(nums[0], nums[1]));
        }
    }

    private static long getMinNum(long a, long b) {
        if (a % b == 0) {
            return a;
        }
        if (b % a == 0) {
            return b;
        }
        long max = a * b;
        long min = a > b ? a : b;
        for (long i = min; i <= max; i += min) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }

        return -1L;
    }
}
