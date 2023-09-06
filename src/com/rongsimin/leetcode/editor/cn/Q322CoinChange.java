//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics广度优先搜索 | 数组 | 动态规划 
//
// 👍 2545, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 322.零钱兑换
 *
 * @author rsm
 * @date 2023-09-01 15:48:46
 */
public class Q322CoinChange {
    public static void main(String[] args) {
        Solution solution = new Q322CoinChange().new Solution();
        //System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{2}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // dp[i] 表示总金额为i时，所需要的最少的硬币个数
            // 那么 f(i) = for in coins : min(f(i - coin)) + 1
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            // base case
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i < coins[j]) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
        public int coinChange2(int[] coins, int amount) {
            // dp[n]存放的就是n所需的最少硬币数量
            //f(n) = min(f(n - k)  ) + 1;
            //k值是变量，从coins里面取
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin: coins) {
                    // 选择coins中的其中一个，还剩下amount - coins[i]
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}