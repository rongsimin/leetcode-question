package com.rongsimin.leetcode.editor.cn.honor;

/**
 * @author rsm
 * @date 2023/11/25 10:55
 */
public class GreaterThanNum {
    public static void main(String[] args) {
        //System.out.println(getGreaterThanNum(5, 4, new int[]{1, 2, 4, 4, 5}));
        System.out.println(getGreaterThanNum(5, 1, new int[]{1,1, 2, 4, 4, 5}));
        System.out.println(getGreaterThanNum(4, 1, new int[]{1,1, 1, 1}));
    }

    private static int getGreaterThanNum(int length, int target, int[] nums) {
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left + 1;
    }
}
