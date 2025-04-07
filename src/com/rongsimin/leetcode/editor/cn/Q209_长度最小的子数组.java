package com.rongsimin.leetcode.editor.cn;
//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics数组 | 二分查找 | 前缀和 | 滑动窗口 
//
// 👍 2290, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class Q209_长度最小的子数组 {
    public static void main(String[] args) {
        Solution solution = new Q209_长度最小的子数组().new Solution();
        int target = 4;
        int[] nums = {1, 4, 4};
        System.out.println(solution.minSubArrayLen(target, nums));
        //int target = 11;
        //int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        //System.out.println(solution.minSubArrayLen(target, nums));
        //int target = 7;
        //int[] nums = {2, 3, 1, 2, 4, 3};
        //System.out.println(solution.minSubArrayLen(target, nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int i = 0;
            int j = 0;
            int minLength = nums.length + 1;
            int total = 0;
            while (i < nums.length) {
                if (total < target && j < nums.length) {
                    total += nums[j];
                    j++;
                }
                while (total >= target && i <= j) {
                    minLength = Math.min(minLength, j - i);
                    total -= nums[i];
                    i++;
                }
                if (j == nums.length) {
                    break;
                }
            }

            return minLength == nums.length + 1 ? 0 : minLength;
        }

        public int minSubArrayLen2(int target, int[] nums) {
            int minLen = Integer.MAX_VALUE;
            // [left, right] 是最小的满足题意的子数组,那么right - left + 1，就是一个可能的解
            int left = 0;
            int right = 0;
            int total = 0;
            while (right < nums.length) {
                total += nums[right];
                while (total >= target) {
                    minLen = Math.min(minLen, right - left + 1);
                    total -= nums[left];
                    left++;
                }
                right++;
            }

            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }

        /**
         * 超时了
         *
         * @param target
         * @param nums
         * @return
         */
        public int minSubArrayLenTimeLimitExceeded(int target, int[] nums) {
            int minLen = Integer.MAX_VALUE;
            // [left, right] 是最小的满足题意的子数组,那么right - left + 1，就是一个可能的解
            int left = 0;
            int right = 0;
            while (right < nums.length) {
                int sum = sum(nums, left, right);
                if (sum >= target) {
                    minLen = Math.min(minLen, right - left + 1);
                    left++;
                } else {
                    right++;
                }
            }

            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }

        private int sum(int[] nums, int left, int right) {
            int total = 0;
            for (int i = left; i <= right; i++) {
                total += nums[i];
            }
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}