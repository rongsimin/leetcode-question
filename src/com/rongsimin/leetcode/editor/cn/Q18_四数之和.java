package com.rongsimin.leetcode.editor.cn;
//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 1992, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18_四数之和 {
    public static void main(String[] args) {
        Solution solution = new Q18_四数之和().new Solution();
        int[] nums = new int[]{2, 2, 2, 2, 2};
        int target = 8;
        System.out.println(solution.fourSum(nums, target));
        nums = new int[]{1, 0, -1, 0, -2, 2};
        target = 0;
        System.out.println(solution.fourSum(nums, target));
        nums = new int[]{1, -2, -5, -4, -3, 3, 3, 5};
        target = -11;
        System.out.println(solution.fourSum(nums, target));
        nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        target = -294967296;
        System.out.println(solution.fourSum(nums, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums.length < 4) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            List<List<Integer>> resList = new ArrayList<>();
            for (int i = 0; i < nums.length - 3; i++) {
                //if (nums[i] > target) break;
                if (i != 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length - 2; ) {
                    int l = j + 1;
                    int r = nums.length - 1;
                    while (l < r) {
                        long total = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];
                        if (total < (long) target) {
                            l++;
                            while (l < r && nums[l] == nums[l - 1]) {
                                l++;
                            }
                        } else if (total > (long) target) {
                            r--;
                            while (l < r && nums[r] == nums[r + 1]) {
                                r--;
                            }
                        } else {
                            resList.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            l++;
                            while (l < r && nums[l] == nums[l - 1]) {
                                l++;
                            }
                            r--;
                            while (l < r && nums[r] == nums[r + 1]) {
                                r--;
                            }
                        }
                    }
                    j++;
                    while (j < nums.length - 2 && nums[j - 1] == nums[j]) {
                        j++;
                    }
                }
            }

            return resList;
        }

        public List<List<Integer>> fourSum2(int[] nums, int target) {
            List<List<Integer>> resList = new ArrayList<>();
            if (nums.length < 4) {
                return resList;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; ) {
                for (int j = i + 1; j < nums.length - 2; ) {
                    // 固定 i 和 j 两个下标，再找到左右两个边界下标
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        long total = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];
                        if (total > target) {
                            right--;
                            while (left < right && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        } else if (total < target) {
                            left++;
                            while (left < right && nums[left - 1] == nums[left]) {
                                left++;
                            }
                        } else {
                            // 找到其中一组解
                            resList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                            while (left < right && nums[left - 1] == nums[left]) {
                                left++;
                            }
                            right--;
                            while (left < right && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        }
                    }
                    j++;
                    while (j < nums.length - 2 && nums[j - 1] == nums[j]) {
                        j++;
                    }
                }
                i++;
                while (i < nums.length - 3 && nums[i - 1] == nums[i]) {
                    i++;
                }
            }
            return resList;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}