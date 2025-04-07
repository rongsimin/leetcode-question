package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 2025-03-16 13:55:00
 **/
public class Q62_不同路径 {
    public static void main(String[] args) {
        Solution solution = new Q62_不同路径().new Solution();
        System.out.println(solution.uniquePaths(3, 7));
        System.out.println(solution.uniquePaths(3, 2));
        System.out.println(solution.uniquePaths(3, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths2(int m, int n) {
            // f(i,j) = f(i-1, j) + f(i, j-1)
            int[][] paths = new int[m][n];
            Arrays.fill(paths[0], 1);
            for (int i = 0; i < paths.length; i++) {
                paths[i][0] = 1;
            }
            for (int i = 1; i < paths.length; i++) {
                for (int j = 1; j < paths[0].length; j++) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
            return paths[m - 1][n - 1];
        }

        int[][] memo;

        public int uniquePaths(int m, int n) {
            memo = new int[m + 1][n + 1];
            for (int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i], -1);
            }
            // f(i,j) = f(i-1, j) + f(i, j-1)
            return dfs(m, n);
        }

        private int dfs(int m, int n) {
            if (m == 1 && n == 1) {
                memo[m][n] = 1;
                return 1;
            }
            if (memo[m][n] == -1) {
                if (m > 1 && n > 1) {
                    memo[m][n] = dfs(m - 1, n) + dfs(m, n - 1);
                } else if (m > 1) {
                    memo[m][n] = dfs(m - 1, n);
                } else {
                    memo[m][n] = dfs(m, n - 1);
                }
            }
            return memo[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}