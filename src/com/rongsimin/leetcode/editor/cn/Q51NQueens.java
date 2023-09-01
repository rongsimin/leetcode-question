//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics数组 | 回溯 
//
// 👍 1876, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51.N 皇后
 *
 * @author rsm
 * @date 2023-08-31 20:07:15
 */
public class Q51NQueens {
    public static void main(String[] args) {
        Solution solution = new Q51NQueens().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> resList = new ArrayList<>();
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], '.');
            }
            dfs(0, n, board, resList);
            return resList;
        }

        // 在第row行摆放一个皇后
        private void dfs(int row, int n, char[][] board, List<List<String>> resList) {
            if (row == n) {
                List<String> list = new ArrayList<>();
                generateStr(board, list);
                resList.add(list);
                return;
            }
            // 在第col列进行摆放
            for (int col = 0; col < n; col++) {
                if (isValid(row, col, board)) {
                    board[row][col] = 'Q';
                    dfs(row + 1, n, board, resList);
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

        private void generateStr(char[][] board, List<String> list) {
            for (char[] ch : board) {
                list.add(new String(ch));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}