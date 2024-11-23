package com.rongsimin.leetcode.editor.cn.honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rsm
 * @date 2023/11/26 16:26
 */
public class BallHeight {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            int high = Integer.parseInt(str);
            getHigh(high, 5);
        }

    }

    private static void getHigh(int n, int count) {
        double sum = n;
        double h = n / 2.0;
        int i = 2;
        while (i <= count) {
            sum += h * 2;
            h /= 2.0;
            i++;
        }
        System.out.println(sum);
        System.out.println(h);
    }
}
