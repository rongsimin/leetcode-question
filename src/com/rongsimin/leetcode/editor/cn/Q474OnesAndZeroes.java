//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
// 
// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
// 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
//
// Related Topics数组 | 字符串 | 动态规划 
//
// 👍 1040, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 474.一和零
 *
 * @author rsm
 * @date 2023-09-04 18:07:04
 */
public class Q474OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new Q474OnesAndZeroes().new Solution();
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        //System.out.println(solution.findMaxForm(strs, 5, 3));
        System.out.println(solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int maxLength = 0;

        private int[][][] memo;

        public int findMaxForm(String[] strs, int m, int n) {
            // m个0，n个1（这是一个组合问题，从每一个索引处往下遍历，得到m 个 0， n个1之后停止，更新最值）
            int[][] dp = new int[m + 1][n + 1];
            dp[0][0] = 0;
            for (String str : strs) {
                int ones = 0;
                int zeros = 0;
                char[] charArray = str.toCharArray();
                for (int k = 0; k < charArray.length; k++) {
                    if (charArray[k] == '0') {
                        zeros++;
                    } else {
                        ones++;
                    }
                }
                for (int i = m; i >= zeros; i--) {
                    for (int j = n; j >= ones; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                    }
                }
                //System.out.println(Arrays.deepToString(dp));

            }
            return dp[m][n];
        }

        /**
         * 从 start到 n 之间，最多有 m个0，n个1的子集
         *
         * @param strs
         * @param start
         * @param m
         * @param n
         * @return
         */
        private int dfs(String[] strs, int start, int m, int n) {
            if (m < 0 || n < 0 || start >= strs.length) {
                return 0;
            }
            if (memo[start][m][n] != -1) {
                return memo[start][m][n];
            }
            int calZeros = 0;
            int calOnes = 0;
            for (char ch : strs[start].toCharArray()) {
                if (ch == '0') {
                    calZeros++;
                } else {
                    calOnes++;
                }
            }
            int res;
            //if (m >= calZeros && n >= calOnes) {
            //    res = Math.max(dfs(strs, start + 1, m, n), 1 + dfs(strs, start + 1, m - calZeros, n - calOnes));
            //} else {
            //    res = dfs(strs, start + 1, m, n);
            //}
            res = dfs(strs, start + 1, m, n);
            if (m >= calZeros && n >= calOnes) {
                res = Math.max(dfs(strs, start + 1, m, n), 1 + dfs(strs, start + 1, m - calZeros, n - calOnes));
            }
            memo[start][m][n] = res;
            return res;
        }


        public int findMaxForm2(String[] strs, int m, int n) {
            maxLength = 0;
            // m个0，n个1（这是一个组合问题，从每一个索引处往下遍历，得到m 个 0， n个1之后停止，更新最值）
            dfs2(strs, 0, 0, 0, m, n, 0);
            return maxLength;
        }

        /**
         * 从每一个索引 start 处往后遍历，得到m 个 0， n个1之后停止，更新最值
         *
         * @param strs
         * @param start
         * @param zeros
         * @param ones
         * @param m
         * @param n
         */
        private void dfs2(String[] strs, int start, int zeros, int ones, int m, int n, int count) {
            if (zeros > m || ones > n) {
                return;
            }
            if (count > maxLength) {
                maxLength = count;
            }
            for (int i = start; i < strs.length; i++) {
                int calZeros = cal(strs[i], '0');
                int calOnes = cal(strs[i], '1');
                count++;
                zeros += calZeros;
                ones += calOnes;
                dfs2(strs, i + 1, zeros, ones, m, n, count);
                count--;
                zeros -= calZeros;
                ones -= calOnes;
            }
        }

        private int cal(String str, char ch) {
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == ch) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}