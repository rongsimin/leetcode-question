package com.rongsimin.leetcode.editor.cn;

/**
 * 2025-03-16 14:53:03
 **/
public class Q63_不同路径II {
    public static void main(String[] args) {
        Solution solution = new Q63_不同路径II().new Solution();
        //int[][] ints = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        //System.out.println(solution.uniquePathsWithObstacles(ints));
        //ints = new int[][]{{0, 1}, {0, 0}};
        //System.out.println(solution.uniquePathsWithObstacles(ints));
        int[][] ints = new int[][]{{1, 0}};
        System.out.println(solution.uniquePathsWithObstacles(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // f(i,j) = f(i-1,j) + f(i, j-1)
            // if([i,j] == 1) f(i,j) = 0
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            for (int i = 1; i < obstacleGrid.length; i++) {
                dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
            }
            for (int i = 1; i < obstacleGrid[0].length; i++) {
                dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];
            }
            for (int i = 1; i < obstacleGrid.length; i++) {
                for (int j = 1; j < obstacleGrid[1].length; j++) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}