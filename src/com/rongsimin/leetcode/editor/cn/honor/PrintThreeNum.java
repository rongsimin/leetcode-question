package com.rongsimin.leetcode.editor.cn.honor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 不重复打印排序数组中相加和为给定值的所有三元组
 * @author rsm
 * @date 2023/11/25 17:24
 */
public class PrintThreeNum {
    private static List<int[]> resList = new ArrayList<>();

    public static void main(String[] args) {
        getThreeNum(new int[]{-8, -4, -3, 0, 1, 1, 2, 4, 5, 8, 9}, 10);
        resList.forEach((o) -> System.out.println(Arrays.toString(o)));
        System.out.println("-----------------");
        resList = new ArrayList<>();
        getThreeNum(new int[]{-8, -4, -3, 0, 1, 1, 2, 4, 4, 8, 9}, 10);
        resList.forEach((o) -> System.out.println(Arrays.toString(o)));
    }

    private static void getThreeNum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    if (nums[i] < nums[left] && nums[left] < nums[right]) {
                        resList.add(new int[]{nums[i], nums[left], nums[right]});
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                } else if (sum < target) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                }
            }
        }
    }
}
