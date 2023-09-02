//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26" 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1 1 10 6) 
// "KJF" ，将消息分组为 (11 10 6) 
// 
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 1436, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 91.解码方法
 *
 * @author rsm
 * @date 2023-09-01 16:44:13
 */
public class Q91DecodeWays {
    public static void main(String[] args) {
        Solution solution = new Q91DecodeWays().new Solution();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("23412405"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if (s.startsWith("0")) {
                return 0;
            }
            //  f(i) 表示字符串s的前i个字符的解码数
            // 情况1：如果第i个字符为 0;f(i) = f (i - 1)
            // 情况2：如果第i个字符不是0，表示第i个字符本身可以解码，还要看它能不能和前一个字符组成解码 s[i -1][i]
            // 情况2是并列关系，f(i) += f(i - 1) && f(i) += f(i - 2) 要求i > 1才有可能
            int[] dp = new int[s.length() + 1];
            dp[0] = 1; // 空字符串
            for (int i = 1; i <= s.length(); i++) {
                if (s.charAt(i - 1) != '0') {
                    dp[i] += dp[i -1];
                }
                if (i > 1 && Integer.parseInt(s.substring(i -2, i)) >= 10 && Integer.parseInt(s.substring(i - 2, i)) <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}