//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
//
// 
//
// 
// 注意：本题与主站 1143 题相同： https://leetcode-cn.com/problems/longest-common-
//subsequence/ 
//
// Related Topics字符串 | 动态规划 
//
// 👍 144, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * LCR 095.最长公共子序列
 *
 * @author rsm
 * @date 2023-09-06 20:42:23
 */
public class QLCR095QJnOS7 {
    public static void main(String[] args) {
        Solution solution = new QLCR095QJnOS7().new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
        System.out.println(solution.longestCommonSubsequence("abc", "abc"));
        System.out.println(solution.longestCommonSubsequence("abc", "def"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            // dp[i][j] 存放的是text1[0,i - 1] 和 text2[0, j - 1]的最长公共子序列
            // if (text1[i-1] == text2[j - 1]) dp[i][j] = dp[i-1][j-1] + 1
            // else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            // base case
            //dp[0][0] = 0;
            //
            //for (int i = 0; i < text2.length(); i++) {
            //    dp[0][i] = 0;
            //}
            //for (int i = 0; i < text1.length(); i++) {
            //    dp[i][0] = 0;
            //}
            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {
                    if (text1.charAt(i-1) == text2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}