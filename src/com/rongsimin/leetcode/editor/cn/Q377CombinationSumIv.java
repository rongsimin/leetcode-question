//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
//
// Related Topics数组 | 动态规划 
//
// 👍 863, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 377.组合总和 Ⅳ
 *
 * @author rsm
 * @date 2023-09-04 18:00:07
 */
public class Q377CombinationSumIv {
    public static void main(String[] args) {
        Solution solution = new Q377CombinationSumIv().new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 35));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] memo;
        public int combinationSum4(int[] nums, int target) {
            // 跟爬楼梯一样，每一步可以走nums里面的其中一步，有多少种走法
            Arrays.sort(nums);
            if (target < nums[0]) {
                return 0;
            }
            // f(n) = sum(n >= num[i] ? f(n - nums[i]) : 0)
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 2; i <= target; i++) {
                for (int num : nums) {
                    if (i < num) {
                        continue;
                    }
                    dp[i] += dp[i - num];
                }
            }
            return dp[target];
        }
        public int combinationSum5(int[] nums, int target) {
            Arrays.sort(nums);
            if (target < nums[0]) {
                return 0;
            }
            memo = new int[target + 1];
            Arrays.fill(memo, -1);
            // 每次选取nums中的一个元素，直到target == 0 记录一个数
            dfs(nums, target);

            return memo[target];
        }

        private int dfs(int[] nums, int target) {
            if (target == 0) {
                return 1;
            }
            if (memo[target] != -1) {
                return memo[target];
            }
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > target) {
                    continue;
                }
                res += dfs(nums, target - nums[i]);
            }
            return memo[target] = res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}