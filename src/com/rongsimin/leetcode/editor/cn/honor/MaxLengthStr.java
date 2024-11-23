package com.rongsimin.leetcode.editor.cn.honor;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author rsm
 * @date 2023/11/24 16:33
 */
public class MaxLengthStr {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("等待输入：");
            String str = scanner.nextLine();
            System.out.println("输入的是:" + str);
            if (str != null && str.trim().equals("stop")) {
                break;
            }
            System.out.println(maxlength(str));
        }
    }

    private static int maxlength(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                count += 2;
                stack.pop();
            }
        }
        return stack.isEmpty() ? count : 0;
    }
}
