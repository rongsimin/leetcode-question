//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics数组 | 回溯 | 矩阵 
//
// 👍 1667, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 79.单词搜索
 *
 * @author rsm
 * @date 2023-08-31 11:46:31
 */
public class Q79WordSearch {
    public static void main(String[] args) {
        Solution solution = new Q79WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean[][] isUsed;

        private int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            isUsed = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != word.charAt(0)) {
                        continue;
                    }
                    if (dfs(i, j, m, n, board, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int iStart, int jStart, int m, int n, char[][] board, String word, int index) {
            if (index == word.length()) {
                return true;
            }
            if (!isValid(iStart, jStart, m, n, board, word, index)) {
                return false;
            }
            isUsed[iStart][jStart] = true;
            for (int i = 0; i < move.length; i++) {
                if (dfs(iStart + move[i][0], jStart + move[i][1], m, n, board, word, index + 1)) {
                    return true;
                }
            }
            isUsed[iStart][jStart] = false;
            return false;
        }

        private boolean isValid(int iStart, int jStart, int m, int n, char[][] board, String word, int index) {
            if (iStart < 0 || iStart >= m || jStart < 0 || jStart >= n || isUsed[iStart][jStart] || board[iStart][jStart] != word.charAt(index)) {
                return false;
            }
            return true;
        }

        /* private boolean dfs2(int iStart, int jStart, int m, int n, char[][] board, String word, int index) {
            if (index == word.length()) {
                return true;
            }
            for (int i = iStart; i < m; i++) {
                for (int j = jStart; j < n; j++) {
                    if (isUsed[i][j]) {
                        continue;
                    }
                    isUsed[i][j] = true;
                    if () {
                        index++;
                    } else {
                        // 这个时候要回溯
                        isUsed[i][j] = false;
                    }
                }
            }
            return false;
        } */
    }
//leetcode submit region end(Prohibit modification and deletion)

}