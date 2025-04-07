package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 2025-03-16 17:04:04
 **/
public class Q198_打家劫舍 {
    public static void main(String[] args) {
        Solution solution = new Q198_打家劫舍().new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] memo;

        public int rob(int[] nums) {
            int[] dp = new int[nums.length + 1];
            dp[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                // dp[i] = max(nums[i] + dp[i + 2], dp[i+1])
                dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
            }
            return dp[0];
        }

        public int robSlow(int[] nums) {
            // f(n) = max(nums[0] + f(2), nums[1] + f(3), ..., nums[n-2] + nums[n], nums[n-1])
            int[] dp = new int[nums.length];
            dp[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                // dp[i] = max(nums[i] + dp[i + 2])
                for (int j = i; j <= nums.length - 1; j++) {
                    dp[i] = Math.max(dp[i], nums[j] + (j + 2 <= nums.length - 1 ? dp[j + 2] : 0));
                }
            }
            return dp[0];
        }

        public int rob2(int[] nums) {
            // f(n) = max(nums[0] + f(2), nums[1] + f(3), ..., nums[n-2] + nums[n], nums[n-1])
            memo = new int[nums.length];
            Arrays.fill(memo, -1);
            return dfs(nums, 0);
        }

        /**
         * 从start开始（包含start）直到数组末尾，可以偷到的最大值
         *
         * @param nums
         * @param start
         * @return
         */
        private int dfs(int[] nums, int start) {
            if (start >= nums.length) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            if (memo[start] == -1) {
                for (int i = start; i < nums.length; i++) {
                    max = Math.max(max, nums[i] + dfs(nums, i + 2));
                }
                memo[start] = max;
            }
            return memo[start];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}