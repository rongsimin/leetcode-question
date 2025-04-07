package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 2025-03-16 17:31:04
 **/
public class Q213_打家劫舍II {
    public static void main(String[] args) {
        Solution solution = new Q213_打家劫舍II().new Solution();
        System.out.println(solution.rob(new int[]{2, 3, 2}));
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{1, 2, 3}));
        System.out.println(solution.rob(new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int rob(int[] nums) {
            // 1、偷取 nums[0],那么偷取的范围是nums[0] + f(2, n-1)
            // 2、不偷取 nums[0], 那么偷取的范围是nums[1] + f(3, n)
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(dfs3(nums, 0, nums.length - 2), dfs3(nums, 1, nums.length - 1));
        }

        private int dfs3(int[] nums, int start, int end) {
            //
            return 0;
        }

        public int rob2(int[] nums) {
            // 1、偷取 nums[0],那么偷取的范围是nums[0] + f(2, n-1)
            // 2、不偷取 nums[0], 那么偷取的范围是nums[1] + f(3, n)
            if (nums.length == 1) {
                return nums[0];
            }
            memo = new int[nums.length][nums.length];
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i], -1);
            }
            return Math.max(dfs2(nums, 0, nums.length - 2), dfs2(nums, 1, nums.length - 1));
        }

        private int dfs2(int[] nums, int start, int end) {
            if (start > end) {
                return 0;
            }
            if (start == end) {
                return nums[start];
            }
            if (memo[start][end] == -1) {
                for (int i = start; i <= end; i++) {
                    memo[start][end] = Math.max(memo[start][end], nums[i] + dfs2(nums, i + 2, end));
                }

            }
            return memo[start][end];
        }

        public int rob1(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            // 1、偷取 nums[0],那么偷取的范围是nums[0] + f(2, n-1)
            // 2、不偷取 nums[0], 那么偷取的范围是nums[1] + f(3, n)
            return Math.max(dfs1(nums, 0, nums.length - 2), dfs1(nums, 1, nums.length - 1));
        }

        /**
         * 从 偷取从[start,end]之间的最大值，其中start为要偷取的屋子
         *
         * @param nums
         * @param start
         * @param end
         * @return
         */
        private int dfs1(int[] nums, int start, int end) {
            if (start > end) {
                return 0;
            }
            if (start == end) {
                return nums[start];
            }
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                max = Math.max(max, nums[i] + dfs1(nums, i + 2, end));
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}