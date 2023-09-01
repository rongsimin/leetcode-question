//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 1007, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 130.被围绕的区域
 *
 * @author rsm
 * @date 2023-08-31 15:12:04
 */
public class Q130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new Q130SurroundedRegions().new Solution();
        char[][] chars = {{'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}};
        //solution.solve(chars);
        //System.out.println(Arrays.deepToString(chars));
        chars = new char[][]{{'X','X','O','X','X','O','X','O'},
                {'X','X','X','O','X','X','O','X'},
                {'X','X','X','O','X','O','X','O'},
                {'O','X','X','X','X','O','O','X'},
                {'O','O','O','X','O','O','O','X'},
                {'O','X','O','O','X','X','O','X'},
                {'O','X','O','O','X','O','X','X'},
                {'O','X','X','X','O','O','O','X'}};
        solution.solve(chars);
        System.out.println(Arrays.deepToString(chars));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean[][] isVisited;

        private int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;

            isVisited = new boolean[m][n];
            // 遍历行
            for (int i = 0; i < n; i++) {
                if (board[0][i] == 'O') {
                    dfs(0, i, m, n, board);
                }
                if (board[m - 1][i] == 'O') {
                    dfs(m - 1, i, m, n, board);
                }
            }
            // 遍历列
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    dfs(i, 0, m, n, board);
                }
                if (board[i][n - 1] == 'O') {
                    dfs(i, n - 1, m, n, board);
                }
            }

            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1 ; j++) {
                    if (!isVisited[i][j] && board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        private void dfs(int i, int j, int m, int n, char[][] board) {
            if (i < 0 || i >=m || j < 0 || j >= n) {
                return;
            }
            if (board[i][j] == 'O' && !isVisited[i][j]) {
                isVisited[i][j] = true;
                for (int k = 0; k < moves.length; k++) {
                    dfs(i + moves[k][0], j + moves[k][1], m, n, board);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}