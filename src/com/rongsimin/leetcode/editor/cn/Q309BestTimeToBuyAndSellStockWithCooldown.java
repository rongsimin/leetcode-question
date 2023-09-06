//给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 1577, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 309.买卖股票的最佳时机含冷冻期
 *
 * @author rsm
 * @date 2023-09-02 18:15:36
 */
public class Q309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new Q309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(solution.maxProfit(new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit2(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }
            // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            // 如果要在第i天手上有股票，要么我在i-1天就有股票了，要么我在i - 2 天没有股票，但是我今天买入了
            // base case
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;// 第1天的盈利
            dp[0][1] = -prices[0]; // 第一天手上有多少股票
            dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
            dp[1][1] = Math.max(-prices[0],-prices[1]);
            for (int i = 2; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }

        /**
         * 优化空间复杂度
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }
            // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            // 如果要在第i天手上有股票，要么我在i-1天就有股票了，要么我在i - 2 天没有股票，但是我今天买入了
            // base case
            //int[][] dp = new int[prices.length][2];
            int dp_0_0 = 0;// 第1天的盈利
            int dp_0_1 = -prices[0]; // 第一天手上有多少股票
            int dp_1_0 = Math.max(dp_0_0, dp_0_1 + prices[1]); // 第2天的盈利
            int dp_1_1 = Math.max(-prices[0],-prices[1]);// 第2天的股票
            for (int i = 2; i < prices.length; i++) {
                int dp10 = dp_1_0;
                int dp11 = dp_1_1;
                dp_1_0 = Math.max(dp_1_0, dp_1_1 + prices[i]);
                dp_1_1 = Math.max(dp_1_1, dp_0_0 - prices[i]);
                dp_0_0 = dp10;
                dp_0_1 = dp11;
            }
            return dp_1_0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}