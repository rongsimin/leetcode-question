package com.rongsimin.leetcode.editor.cn.mytest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rsm
 * @date 2023/9/7 17:48
 */
public class 多叉树打印 {
    static List<List<Integer>> 组合 = new ArrayList<>();
    static List<List<Integer>> 排列 = new ArrayList<>();
    static boolean[] isVisited;
    public static List<List<Integer>> 排列(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        isVisited = new boolean[n + 1];
        排列(n, new LinkedList<>());
        return 排列;
    }

    private static void 排列(int n, LinkedList<Integer> list) {
        if (list.size() == n) {
            排列.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            list.add(i);
            排列(n, list);
            list.removeLast();
            isVisited[i] = false;
        }
    }

    public static List<List<Integer>> 组合(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        组合(n, 1, new LinkedList<>());
        return 组合;
    }

    private static void 组合(int n, int start, LinkedList<Integer> list) {
        组合.add(new ArrayList<>(list));
        for (int i = start; i <= n; i++) {
            list.add(i);
            组合(n, i + 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(组合(3));
        System.out.println(排列(3));
    }
}
