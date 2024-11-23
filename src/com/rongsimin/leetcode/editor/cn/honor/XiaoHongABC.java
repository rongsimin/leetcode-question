package com.rongsimin.leetcode.editor.cn.honor;

/**
 * 想复杂了，
 * 最短的回文串，不是2就是3， 假如是4，那么里面的两个字符一定也是对称的，所以还是2，假如是5，那么最外层也是对称，可以去掉
 * @author rsm
 * @date 2023/11/25 16:17
 */
public class XiaoHongABC {
    public static void main(String[] args) {
        System.out.println(getMinLength("abcca"));
        System.out.println(getMinLength("abcaca"));
        System.out.println(getMinLength("abcab"));
    }

    private static int getMinLength(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                return 2;
            }
            if (i + 2 < str.length() && str.charAt(i) == str.charAt(i + 2)) {
                return 3;
            }
        }
        return -1;
    }
}
