//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 3128, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 121.买卖股票的最佳时机
 *
 * @author rsm
 * @date 2023-09-02 22:14:05
 */
public class Q121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new Q121BestTimeToBuyAndSellStock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            // dp[n][k][0] = Math.max(dp[n - 1][k][0], dp[n - 1][k][1] + prices[n]) 没有股票，最大利润
            // dp[n][k][1] = Math.max(dp[n - 1][k][1], dp[n - 1][k - 1][0] - price[n])
            // dp[n][1][0] 就是所求
            // dp[n][1][0] = Math.max(dp[n - 1][1][0], dp[n - 1][1][1] + prices[n])
            // dp[n][1][1] = Math.max(dp[n - 1][1][1], dp[n - 1][0][0] - price[n]) 因为dp[n - 1][0][0] 表示不允许交易，所以为0
            //             = Math.max(dp[n - 1][1][1], -price[n])

            // dp[n][0] = Math.max(dp[n - 1][0], dp[n - 1][1] + prices[n])
            // dp[n][1] = Math.max(dp[n - 1][1], -price[n])
            //int[][] dp = new int[prices.length][2];
            // base case
            // dp[-1][0] = 0
            // dp[-1][1] = Integer.MIN_VALUE
            // 新状态只和相邻的一个状态有关，
            // 不需要用整个 dp 数组，只需要一个变量储存相邻的那个状态就足够了，这样可以把空间复杂度降到 O(1):
            //for (int i = 0; i < prices.length; i++) {
            //    if (i == 0) {
            //        dp[0][0] = 0;
            //        dp[0][1] = -prices[0];
            //        continue;
            //    }
            //    dp[i][0] =  Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //    dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            //}
            //return dp[prices.length - 1][0];

            int dp_i_0 = 0;
            int dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, -prices[i]);
            }
            return dp_i_0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}