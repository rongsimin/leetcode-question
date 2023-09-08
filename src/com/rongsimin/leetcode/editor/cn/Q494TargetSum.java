//给你一个非负整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics数组 | 动态规划 | 回溯 
//
// 👍 1735, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 494.目标和
 *
 * @author rsm
 * @date 2023-09-05 17:38:22
 */
public class Q494TargetSum {
    public static void main(String[] args) {
        Solution solution = new Q494TargetSum().new Solution();
        //System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (target < -sum || target > sum) {
                return 0;
            }
            // dp[i][j]表示前面nums[0,i]个元素，组成背包容量是j的方法数，那么求的就是dp[nums.length - 1][target]
            // 对于当前nums[i] 只有两种选择，一种是+,一种是-
            // dp[i][j] = dp[i-1][j - nums[i]] + dp[i - 1][j + nums[i]];
            //int[][] dp = new int[nums.length][target];
            // 背包的容量题目中说了 0 <= j <= 1000，
            // 那么j +- nums[i] 的范围应该是 -1000 到 1000 可以这样取值
            // 又因为前面实际sum已经求出来，所以边界值可以以它为准 j <= sum && j >= -sum
            // 对数组中的索引进行偏移
            int offset = sum;
            int[][] dp = new int[nums.length][2 * sum + 1];
            dp[0][0 + nums[0] + offset] = 1;
            dp[0][0 - nums[0] + offset] += 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = -sum; j <= sum; j++) {
                    if (Math.abs(j - nums[i]) <= sum) {
                        dp[i][j + offset] += dp[i-1][j - nums[i] + offset];
                    }
                    if (Math.abs(j + nums[i]) <= sum) {
                        dp[i][j + offset] += dp[i-1][j + nums[i] + offset];
                    }
                }
            }
            //System.out.println(Arrays.deepToString(dp));
            return dp[nums.length - 1][target + offset];
        }
        public int findTargetSumWays2(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (target < -sum || target > sum) {
                return 0;
            }
            //if (sum == Math.abs(target)) {
            //    return 1;
            //}
            // dp[i][j]表示前面nums[0,i]个元素，组成背包容量是j的方法数，那么求的就是dp[nums.length - 1][target]
            // 对于当前nums[i] 只有两种选择，一种是+,一种是-
            // dp[i][j] = dp[i-1][j - nums[i]] + dp[i - 1][j + nums[i]];
            //int[][] dp = new int[nums.length][target];
            // 背包的容量题目中说了 0 <= j <= 1000，
            // 那么j +- nums[i] 的范围应该是 -1000 到 1000 可以这样取值
            // 又因为前面实际sum已经求出来，所以边界值可以以它为准 j <= sum && j >= -sum
            // 对数组中的索引进行偏移
            int offset = sum;
            int[][] dp = new int[nums.length + 1][2 * sum + 1];
            dp[0][offset] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = -sum; j <= sum; j++) {
                    if (Math.abs(j - nums[i]) <= sum) {
                        dp[i + 1][j + offset] += dp[i][j - nums[i] + offset];
                        //dp[i][j + offset] += dp[i-1][j - nums[i] + offset];
                    }
                    if (Math.abs(j + nums[i]) <= sum) {
                        dp[i + 1][j + offset] += dp[i][j + nums[i] + offset];
                    }
                }
            }
            return dp[nums.length][target + offset];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}