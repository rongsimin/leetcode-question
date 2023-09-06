//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 1870, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 416.分割等和子集
 *
 * @author rsm
 * @date 2023-09-04 11:10:12
 */
public class Q416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new Q416PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{3, 3, 3, 4,5}));
        //System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        //System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] isTwoSum;

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            // dp[c]表示 容量为c的背包，能不能被物品装满
            boolean[] dp = new boolean[sum / 2 + 1];
            // base case 只放nums[0] 时，看能不能装满背包
            for (int i = 0; i <= sum / 2; i++) {
                dp[i] = nums[0] == i;
            }
            // 再装其它物品时，看能不能把背包装满
            for (int i = 1; i < nums.length; i++) {
                for (int j = sum / 2; j >= nums[i]; j--) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
            return dp[sum / 2];
        }
        public boolean canPartition3(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            // dp[i][c]表示nums前面i个元素，能否组成和为c的组合
            boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
            for (int i = 0; i <= sum / 2; i++) {
                dp[0][i] = nums[0] == i;
            }
            // 要么不放num[i]，要么放nums[i]
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= sum / 2; j++) {
                    dp[i][j] = dp[i - 1][j] || (j >= nums[i] ? dp[i - 1][j - nums[i]] : false);
                }
            }
            return dp[nums.length - 1][sum / 2];
        }
        public boolean canPartition2(int[] nums) {
            // 分成两个子集，首先对数组进行求和sum，如果sum为奇数，则不可能平分
            // 如果sum为偶数，则可以转化成完全背包问题，把原问题换成，找出一部分元素，使其和等于sum/2，如果可以找到，那么返回true
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            isTwoSum = new int[nums.length][sum / 2 + 1];
            for (int[] ints : isTwoSum) {
                Arrays.fill(ints, -1);
            }

            // 使用递归来解决 dfs(nums, 0, sum/2) 从0开始往后遍历，直到sum为0
            // 两种可能使得这个式子成立：1、dfs(nums, index + 1, sum) || dfs(nums, index + 1, sum - nums[index])
            return dfs(nums, 0, sum / 2);
        }

        /**
         * 两种可能使得这个式子成立：1、dfs(nums, index + 1, sum) || dfs(nums, index + 1, sum - nums[index])
         * @param nums
         * @param index
         * @param sum
         * @return
         */
        private boolean dfs(int[] nums, int index, int sum) {
            if (sum == 0) {
                return true;
            }
            if (sum < 0 || index == nums.length) {
                return false;
            }
            if (isTwoSum[index][sum] != -1) {
                return isTwoSum[index][sum] == 0;
            }
            boolean result = dfs(nums, index + 1, sum) || dfs(nums, index + 1, sum - nums[index]);
            isTwoSum[index][sum] = result ? 0 : 1;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}