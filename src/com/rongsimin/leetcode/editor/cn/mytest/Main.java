package com.rongsimin.leetcode.editor.cn.mytest;

/**
 * @author rsm
 * @date 2023/11/19 21:21
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 假设A和B是你的两个数据集
        Set<Integer> A = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Set<Integer> B = new HashSet<>(Arrays.asList(5, 6, 7, 8, 9, 10, 11, 12, 13, 14));

        // 创建一个新的集合来存储A的数据，以避免修改原始集合
        Set<Integer> commonData = new HashSet<>(A);

        // 使用retainAll方法找出A和B中相同的数据
        commonData.retainAll(B);

        System.out.println(commonData);
    }
}

