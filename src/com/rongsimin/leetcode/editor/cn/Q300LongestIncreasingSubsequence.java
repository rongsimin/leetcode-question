//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics数组 | 二分查找 | 动态规划 
//
// 👍 3384, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 300.最长递增子序列
 *
 * @author rsm
 * @date 2023-09-06 16:11:42
 */
public class Q300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Q300LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(solution.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLIS(int[] nums) {
            // dp[i]表示以第i个数字结尾的最长上升字串的长度，每个元素自身就是一个子序列，初始化长度为1
            int[] dp = new int[nums.length];
            // dp[i] = max(1 + dp[j] if nums[j] > nums[i])
            Arrays.fill(dp, 1);
            int maxLength = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], 1 + dp[j]);
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
            return maxLength;
        }
        public int lengthOfLIS2(int[] nums) {
            Deque<Integer> deque = new LinkedList<>();
            int maxLength = Integer.MIN_VALUE;
            for (int num : nums) {
                if (!deque.isEmpty() && num < deque.getLast()) {
                    maxLength = Math.max(maxLength, deque.size());
                    while (!deque.isEmpty() && num < deque.getLast()) {
                        deque.removeLast();
                    }
                } else {
                    // 要么为空，要么比队尾元素要大，那么就直接放
                    deque.addLast(num);
                }
            }
            return Math.max(maxLength, deque.size());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}