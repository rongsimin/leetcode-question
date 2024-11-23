package com.rongsimin.leetcode.editor.cn.honor;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 找出字符串中第一个只出现一次的字符
 * @author rsm
 * @date 2023/11/25 16:52
 */
public class FindFirstOneChar {
    public static void main(String[] args) {
        char ch = getFirstOneTimeChar("asdfasdfod");
        if (ch == '.') {
            System.out.println(-1);
        } else {
            System.out.println(ch);
        }
        ch = ' ';
        System.out.println(ch == ' ');
    }

    private static char getFirstOneTimeChar(String str) {
        LinkedHashMap<Character, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            countMap.put(str.charAt(i), countMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '.';
    }
}
