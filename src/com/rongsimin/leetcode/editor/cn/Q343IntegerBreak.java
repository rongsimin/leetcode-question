//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics数学 | 动态规划 
//
// 👍 1258, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 343.整数拆分
 *
 * @author rsm
 * @date 2023-09-01 12:17:04
 */
public class Q343IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new Q343IntegerBreak().new Solution();
        System.out.println(solution.integerBreak(2));
        System.out.println(solution.integerBreak(10));
        System.out.println(solution.integerBreak(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] memo;

        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = max3(dp[i], j * (i - j), j * dp[i - j]);
                }
            }
            return dp[n];
        }
        public int integerBreak3(int n) {
            memo = new int[n + 1];
            // memo[i]存放的就是把i进行分割后的最大值
            memo[1] = 1;
            memo[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
                }
            }
            return memo[n];
        }
        public int integerBreak2(int n) {
            memo = new int[n + 1];
            Arrays.fill(memo, -1);
            return dfs(n);
        }

        private int dfs(int n) {
            if (n == 2) {
                return 1;
            }
            if (memo[n] != -1) {
                return memo[n];
            }
            for (int i = 1; i <= n - 1; i++) {
                //minValue = Math.max(minValue, i * (n - 1), i * dfs(n - i));
                memo[n] = max3(memo[n], i * (n - i), i * dfs(n - i));
            }
            return memo[n];
        }

        private int max3(int minValue, int a, int b) {
            return Math.max(Math.max(minValue, a), b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}