package com.rongsimin.leetcode.editor.cn.honor;

import java.util.*;

/**
 * 数组中两个字符串的最小距离
 *
 * @author rsm
 * @date 2023/11/25 18:10
 */
public class TwoStringMinDistance {

    public static void main(String[] args) {
        System.out.println(getMinLength("QWER", "666", new String[]{"QWER", "1234", "qwe", "666", "QWER"}));
    }

    private static int getMinLength(String str1, String str2, String[] strArray) {
        int str1Index = -1;
        int str2Index = -1;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equals(str1)) {
                str1Index = i;
                if (str2Index != -1) {
                    minLength = Math.min(Math.abs(str1Index - str2Index), minLength);
                }
            } else if (strArray[i].equals(str2)) {
                str2Index = i;
                if (str1Index != -1) {
                    minLength = Math.min(Math.abs(str1Index - str2Index), minLength);
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
    private static int getMinLength2(String str1, String str2, String[] strArray) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        Set<String> set = new HashSet<>(Arrays.asList(strArray));
        if (!set.contains(str1) || !set.contains(str2)) {
            return -1;
        }
        List<Integer> str1IndexList = new ArrayList<>();
        List<Integer> str2IndexList = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equals(str1)) {
                str1IndexList.add(i);
            } else if (strArray[i].equals(str2)) {
                str2IndexList.add(i);
            }
        }
        int minLength = Integer.MAX_VALUE;
        for (Integer str1Index : str1IndexList) {
            for (Integer str2Index : str2IndexList) {
                minLength = Math.min(Math.abs(str1Index - str2Index), minLength);
            }
        }
        return minLength;
    }
}
