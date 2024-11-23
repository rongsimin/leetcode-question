package com.rongsimin.leetcode.editor.cn.honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 密码验证合格程序
 *
 * @author rsm
 * @date 2023/11/26 9:12
 */
public class PasswordValid {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            System.out.println(valid(str));
        }
    }

    private static String valid(String str) {
        if (str == null || str.length() <= 8) {
            return "NG";
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                set.add("Upper");
            } else if (ch >= 'a' && ch <= 'z') {
                set.add("lower");
            } else if (ch >= '0' && ch <= '9') {
                set.add("Number");
            } else {
                set.add("Other");
            }

        }
        if (set.size() < 3) {
            return "NG";
        }
        return getString(str, 0, 3);
    }

    private static String getString(String str, int left, int right) {
        if (right >= str.length()) {
            return "OK";
        }
        if (str.substring(right).contains(str.substring(left, right))) {
            return "NG";
        }
        return getString(str, left + 1, right + 1);
    }
}
