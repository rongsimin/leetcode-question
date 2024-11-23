package com.rongsimin.leetcode.editor.cn.honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中值出现了一次的数字
 * @author rsm
 * @date 2023/11/26 10:31
 */
public class OnlyOneNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String[] input = str.split(" ");
            int[] nums = convertToInt(input);
            Map<Integer, Integer> countMap = new HashMap<>();

        }


    }

    private static int[] convertToInt(String[] input) {
        if (input.length == 0) {
            return new int[0];
        }
        int[] res = new int[input.length];
        return new int[0];
    }
}
