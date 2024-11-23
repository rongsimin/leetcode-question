package com.rongsimin.leetcode.editor.cn.honor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rsm
 * @date 2023/11/24 19:38
 */
public class PrintNK {
    public static void main(String[] args) {
        System.out.println(printNK(new int[]{1, 2, 3, 1, 2, 3, 4}, 7, 7));
        System.out.println(printNK(new int[]{1,  1, 2, 3}, 4, 1));
    }

    private static String printNK(int[] nums, int n, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > n / k) {
                stringBuilder.append(entry.getKey() + " ");
            }
        }
        return stringBuilder.length() > 0 ? stringBuilder.substring(0, stringBuilder.length() - 1): "-1";
    }
}
