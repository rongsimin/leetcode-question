package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 2025-01-01 18:42:39
 **/
public class Q64_最小路径和 {
    public static void main(String[] args) {
        Solution solution = new Q64_最小路径和().new Solution();
        //int[][] ints = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] ints = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(solution.minPathSum(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] isVisited;

        public int minPathSum(int[][] grid) {
            isVisited = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                Arrays.fill(isVisited[i], -1);
            }
            return dfs(grid, 0, 0);
        }

        private int dfs(int[][] grid, int row, int column) {
            if (row == grid.length - 1 && column == grid[0].length - 1) {
                return grid[row][column];
            }
            if (isVisited[row][column] == -1) {
                int res = 0;
                if (row == grid.length - 1) {
                    res = dfs(grid, row, column + 1);
                } else if (column == grid[0].length - 1) {
                    res = dfs(grid, row + 1, column);
                } else {
                    res = Math.min(dfs(grid, row + 1, column), dfs(grid, row, column + 1));
                }
                isVisited[row][column] = res + grid[row][column];
            }

            return isVisited[row][column];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}