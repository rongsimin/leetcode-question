//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 2274, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 200.岛屿数量
 *
 * @author rsm
 * @date 2023-08-31 15:01:30
 */
public class Q200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new Q200NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] moves = new int[][]{{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(i, j, m, n, grid);
                    }
                }
            }
            return count;
        }

        private void dfs(int i, int j, int m, int n, char[][] grid) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return;
            }
            if (grid[i][j] == '1') {
                grid[i][j] = '0';
                for (int k = 0; k < moves.length; k++) {
                    dfs(i + moves[k][0], j + moves[k][1], m, n, grid);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}