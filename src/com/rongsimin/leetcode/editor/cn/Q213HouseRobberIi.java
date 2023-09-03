//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 1440, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 213.打家劫舍 II
 *
 * @author rsm
 * @date 2023-09-02 16:54:28
 */
public class Q213HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new Q213HouseRobberIi().new Solution();
        //System.out.println(solution.rob(new int[]{0, 0}));
        System.out.println(solution.rob(new int[]{1, 2}));
        System.out.println(solution.rob(new int[]{1,2,3,1}));
        //System.out.println(solution.rob(new int[]{1,2,3,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int rob(int[] nums) {
            // 要么偷第一家，要么偷最后一家
            // f(0, n - 1),或者是f(1, n)
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(robZeroOrNot(nums, 0, nums.length - 2), robZeroOrNot(nums, 1, nums.length - 1));
        }

        /**
         * 从start 到 end之间可偷取的最大值
         * @param nums
         * @param start
         * @param end
         * @return
         */
        private int robZeroOrNot(int[] nums, int start, int end) {
            int[] dp = new int[end + 1];
            dp[end] = nums[end];
            // dp[i]表示[i,end]可偷取的最大值,要么偷取i，要么
            // dp[i] = Math.max(dp[i+1], nums[i] + dp[i + 2])
            for (int i = end - 1; i >= start; i--) {
                dp[i] = Math.max(dp[i+1], nums[i] + (i + 2 <= end ? dp[i + 2] : 0));
            }
            return dp[start];
        }


        public int rob2(int[] nums) {
            // 也就是要么偷第一家，要么偷最后一家
            // f(0,n - 1) = Math.max(f(0, n - 2), f(1, n - 1))
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
        }

        /**
         * 从[start,end]中可偷取的最大值
         * @param nums
         * @param start
         * @param end
         * @return
         */
        private int rob(int[] nums, int start, int end) {
            int[] dp = new int[end + 1];
            dp[end] = nums[end];
            // 从[i,end] 可偷取的最大值
            for (int i = end - 1; i >= 0; i--) {
                for (int j = i; j <= end ; j++) {
                    dp[i] = Math.max(dp[i], nums[i] + (i + 2 <= end ? dp[i + 2] : 0));
                }
            }
            return dp[start];
        }
        /**
         * 从[start,end]中可偷取的最大值
         * @param nums
         * @param start
         * @param end
         * @return
         */
        private int rob2(int[] nums, int start, int end) {
            int[] dp = new int[end - start + 1];
            dp[dp.length - 1] = nums[end];
            // 从[i,end] 可偷取的最大值
            for (int i = end - start - 1; i >= 0; i--) {
                dp[i] = Math.max(dp[i + 1], nums[i + start] + (i + 2 <= dp.length - 1 ? dp[i + 2] : 0));
            }
            return dp[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}