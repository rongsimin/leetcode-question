package com.rongsimin.leetcode.editor.cn.honor;

/**
 * n个数里出现次数大于等于n/2的数
 * @author rsm
 * @date 2023/11/25 12:03
 */
public class GreaterN2 {
    public static void main(String[] args) {
        System.out.println(findNum(new int[]{4,3, 9, 3, 2, 5, 6, 7, 3, 2, 3, 3, 3}));
    }

    private static int findNum(int[] nums) {
        // [left, lt) 是小于 nums[0] ,[lt,i) 是等于nums[0] [lt, gt)
        // [gt, right] 大于 nums[0]
        int lt = 0;
        int gt = nums.length;
        int temp = nums[0];
        for (int i = 1; i < gt;) {
            if (nums[i] < temp) {
                swap(nums, i, lt);
                lt++;
                i++;
            } else if (nums[i] == temp) {
                i++;
            } else {
                gt--;
                swap(nums, i, gt);
            }
        }

        return nums[nums.length / 2];
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
