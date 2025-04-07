package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 2025-02-22 14:38:54
 * 2025-03-16 12:04:54
 **/
public class Q91_解码方法 {
    public static void main(String[] args) {
        Solution solution = new Q91_解码方法().new Solution();
        System.out.println(solution.numDecodings("27"));
        //System.out.println(solution.numDecodings("12"));
        //System.out.println(solution.numDecodings("226"));
        //System.out.println(solution.numDecodings("23412405"));
        //System.out.println(solution.numDecodings("2101"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] memo;

        public int numDecodings(String s) {
            if (s.startsWith("0")) {
                return 0;
            }
            memo = new int[s.length()];
            Arrays.fill(memo, -1);
            return dfs2(s, 0, s.length() - 1);
        }

        private int dfs2(String s, int start, int end) {
            if (start >= end) {
                return 1;
            }
            if (memo[end] != -1) {
                return memo[end];
            }
            if (s.charAt(end) == '0') {
                if (s.charAt(end - 1) != '1' && s.charAt(end - 1) != '2') {
                    memo[end] = 0;
                    return 0;
                } else {
                    memo[end] = dfs2(s, start, end - 2);
                    return memo[end];
                }
            } else {
                if ((s.charAt(end - 1) != '1' && s.charAt(end - 1) != '2') || getInt2(s, end - 1, end) > 26) {
                    memo[end] = dfs2(s, start, end - 1);
                    return memo[end];
                } else {
                    memo[end] = dfs2(s, start, end - 1) + dfs2(s, start, end - 2);
                    return memo[end];
                }
            }
        }

        private int getInt2(String s, int i, int end) {
            String substring = s.substring(i, end + 1);
            return Integer.parseInt(substring);
        }

        public int numDecodingsOld(String s) {
            if (s.startsWith("0")) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            // f(n) = f(n-1) + f(n-2)
            int[] dp = new int[s.length()];
            dp[0] = 1;
            String sub = s.substring(0, 2);
            int val = Integer.parseInt(sub);
            if ((val > 10 && val <= 19) || (val > 20 && val <= 26)) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
            for (int i = 2; i < s.length(); i++) {
                char ch = s.charAt(i);
                int one = ch == '0' ? 0 : 1;
                sub = s.substring(i - 1, i + 1);
                val = Integer.parseInt(sub);
                int two = val > 26 || val < 10 ? 0 : 1;
                dp[i] = one * dp[i - 1] + two * dp[i - 2];
            }
            return dp[dp.length - 1];
        }

        public int numDecodings3(String s) {
            if (s.startsWith("0")) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            // f(n) = f(n - 1) + f(n - 2)
            // 如果 s[n] = '0', s[n] = s[n-2]
            // 如果 s[n-2,n] <= 10 或者 > 26, s[n-2] = 0
            int[] dp = new int[s.length()];
            dp[0] = 1;
            String sub = s.substring(0, 2);
            int val = Integer.parseInt(sub);
            if (val > 10 && val <= 26) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
            for (int i = 2; i < s.length(); i++) {
                int one = 0;
                int two = 0;
                if (s.charAt(i) == '0') {
                    one = 0;
                } else {
                    one = 1;
                }
                sub = s.substring(i - 1, i + 1);
                val = Integer.parseInt(sub);
                if (val > 10 && val <= 26) {
                    two = 2;
                } else if (val > 26) {
                    two = 1;
                } else {
                    two = 0;
                }
                dp[i] = one * dp[i - 1] + two * dp[i - 2];
            }
            return dp[dp.length - 1];
        }

        public int numDecodings2(String s) {
            if (s.startsWith("0")) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            return dfs(s, s.length() - 1);
        }

        /**
         * 对字符串s从0 到 end的子串进行编码映射
         *
         * @param s
         * @param end
         * @return
         */
        private int dfs(String s, int end) {
            if (end == 0) {
                return 0;
            }
            if (end == 1) {
                String sub = s.substring(0, end + 1);
                int val = Integer.parseInt(sub);
                int one = 0;
                int two = 0;
                if (s.charAt(0) != '0') {
                    one = 1;
                }
                if (val >= 10 && val <= 26) {
                    two = 1;
                }
                return one + two;
            }

            return dfs(s, end - 1) + dfs(s, end - 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}