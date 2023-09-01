//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics回溯 
//
// 👍 464, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 52.N 皇后 II
 *
 * @author rsm
 * @date 2023-08-31 20:06:12
 */
public class Q52NQueensIi {
    public static void main(String[] args) {
        Solution solution = new Q52NQueensIi().new Solution();
        System.out.println(solution.totalNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count = 0;
        public int totalNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], '.');
            }
            dfs(0, n, board);
            return count;
        }

        private void dfs(int row, int n, char[][] board) {
            if (row == n) {
                count++;
                return;
            }
            // 在第col列进行摆放
            for (int col = 0; col < n; col++) {
                if (isValid(row, col, board)) {
                    board[row][col] = 'Q';
                    dfs(row + 1, n, board);
                    board[row][col] = '.';
                }
            }
        }

        private boolean isValid(int row, int col, char[][] board) {
            for (int i = row - 1; i >= 0; i--) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}