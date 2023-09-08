//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 1154, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 518.零钱兑换 II
 *
 * @author rsm
 * @date 2023-09-07 12:01:50
 */
public class Q518CoinChangeIi {
    public static void main(String[] args) {
        Solution solution = new Q518CoinChangeIi().new Solution();
        //System.out.println(solution.change(5, new int[]{1, 2, 5}));
        //System.out.println(solution.change(3, new int[]{2}));
        System.out.println(solution.change(10, new int[]{5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

       /*  private int[][] memo;

        public int change2(int amount, int[] coins) {
            Arrays.sort(coins);
            memo = new int[amount + 1][coins.length];
            for (int i = 0; i < amount + 1; i++) {

                Arrays.fill(memo[i], -1);
            }
            return dfs(amount, coins, 0);
        }

        private int dfs(int amount, int[] coins, int start) {
            if (amount == 0) {
                return 1;
            }
            if (memo[amount][start] != -1) {
                return memo[amount][start];
            }
            int res = 0;
            for (int i = start; i < coins.length; i++) {
                if (amount >= coins[i]) {
                    res += dfs(amount - coins[i], coins, i);
                }
            }
            memo[amount][start] = res;
            return res;
        } */

        public int change(int amount, int[] coins) {
            // 可以看成是0-1背包问题，amount是背包，coins是物品，有多少种方式可以把背包装满
            // dp[i][j] 表示对于背包容量j,选择前i个物品nums[0,i-1]时，有dp[i][j]种方法，所求即是dp[coins.length][amount]
            // dp[i][j] = dp[i - 1][j] + (j - coins[i - 1] >= 0 ? dp[i - 1][j - coins[i-1]] : 0);
            // base case
            //int[][] dp = new int[coins.length + 1][amount + 1];
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 0; i < coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    dp[j]= dp[j] + (j - coins[i] >= 0 ? dp[j - coins[i]] : 0);
                }
            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}