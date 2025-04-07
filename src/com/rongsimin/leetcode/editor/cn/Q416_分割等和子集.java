package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 2025-03-18 17:22:08
 **/
public class Q416_分割等和子集 {
    public static void main(String[] args) {
        Solution solution = new Q416_分割等和子集().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public boolean canPartition(int[] nums) {
            int total = 0;
            for (int num : nums) {
                total += num;
            }
            if (total % 2 == 1) {
                return false;
            }
            memo = new int[nums.length][total / 2 + 1];
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i], -1);
            }
            // f(n, total/2) = f(n-1,total/2) || f(n-1, total/2-nums[n-1])
            return tryPartition(nums, nums.length - 1, total / 2);
        }

        private boolean tryPartition(int[] nums, int index, int target) {
            if (target == 0) {
                return true;
            }
            if (target < 0 || index < 0) {
                return false;
            }
            if (memo[index][target] != -1) {
                return memo[index][target] == 1;
            }
            memo[index][target] = (tryPartition(nums, index - 1, target) || tryPartition(nums, index - 1, target - nums[index])) ? 1 : 0;
            return memo[index][target] == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}