//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics数组 | 分治 | 动态规划 
//
// 👍 6291, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 53.最大子数组和
 *
 * @author rsm
 * @date 2023-09-06 21:23:14
 */
public class Q53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Q53MaximumSubarray().new Solution();

        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{5,4,-1,7,8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubArray2(int[] nums) {
            // dp[i] 为 以i结尾的最大子数组，那么有两种情况
            // dp[i] = Math.max(nums[i], nums[i] + dp[i-1])
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
                max = Math.max(dp[i], max);
            }
            return max;
        }
        public int maxSubArray(int[] nums) {
            // dp[i] 为 以i结尾的最大子数组，那么有两种情况
            // dp[i] = Math.max(nums[i], nums[i] + dp[i-1])
            int dp = nums[0];
            int max = dp;
            for (int i = 1; i < nums.length; i++) {
                dp = Math.max(nums[i], nums[i] + dp);
                max = Math.max(max, dp);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}