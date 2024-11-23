package com.rongsimin.leetcode.editor.cn.honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rsm
 * @date 2023/11/26 10:22
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String[] input = str.split(" ");
            if (input.length != 2) {
                System.out.println("输入数组长度不合法");
                continue;
            }
            System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
        }
    }
}
