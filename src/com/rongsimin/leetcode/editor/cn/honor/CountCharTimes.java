package com.rongsimin.leetcode.editor.cn.honor;

import java.util.HashMap;
import java.util.Map;

/**
 * 计算某字符出现次数
 * @author rsm
 * @date 2023/11/25 17:05
 */
public class CountCharTimes {
    public static void main(String[] args) {
        //System.out.println('A' - 'a');
        System.out.println(getCharTimes("aabc gfAK LHA AA", 'A'));
        System.out.println(getCharTimes("aabcgfAKLHAAA", 'a'));
        System.out.println(getCharTimes("aabc gfAK LHA AA 34347304", ' '));
        System.out.println(getCharTimes("aabc gfAK LHA AA 34347304", '3'));
    }

    private static int getCharTimes(String str, char ch) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            countMap.put(str.charAt(i), countMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        int result = countMap.getOrDefault(ch, 0);
        if ('A' <= ch && ch <= 'Z') {
            result += countMap.getOrDefault((char)(ch + 32), 0);
        } else if ('a' <= ch && ch <= 'z') {
            result += countMap.getOrDefault((char)(ch - 32), 0);
        }
        return result;
    }
}
