package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 2024-12-22 15:10:24
 **/
public class Q37_解数独 {
    public static void main(String[] args) {
        Solution solution = new Q37_解数独().new Solution();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            dfs(board);
        }

        private boolean dfs(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        continue;
                    }
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (dfs(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int i, int j, char ch) {
            // 在这一行没有出现
            for (int k = 0; k < 9; k++) {
                if (board[i][k] == ch) {
                    return false;
                }
            }
            // 在这一列没有出现
            for (int k = 0; k < 9; k++) {
                if (board[k][j] == ch) {
                    return false;
                }
            }
            // 在这个九宫格没有出现
            // [i / 3 * 3, i / 3 * 3 + 2]
            // [j / 3 * 3, j / 3 * 3 + 2]
            for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
                for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
                    if (board[k][l] == ch) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}