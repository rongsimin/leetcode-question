package com.rongsimin.leetcode.editor.cn.honor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 字符串排序
 *
 * @author rsm
 * @date 2023/11/25 17:56
 */
public class StringSort {
    public static void main(String[] args) {
        System.out.println(sort(new String[]{"cap", "to", "cat", "card", "two", "too", "up", "boat", "boot", "Ab", "BB", "cc", "cc"}));
    }

    private static List<String> sort(String[] strArray) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < strArray.length; i++) {
            treeMap.put(strArray[i], treeMap.getOrDefault(strArray[i], 0) + 1);
        }
        List<String> resList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                resList.add(entry.getKey());
            }
        }
        return resList;
    }
}
