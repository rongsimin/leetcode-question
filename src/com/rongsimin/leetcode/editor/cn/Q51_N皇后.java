package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2024-12-22 14:56:23
 **/
public class Q51_N皇后 {
    public static void main(String[] args) {
        Solution solution = new Q51_N皇后().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> resList = new ArrayList<>();
            char[][] queue = new char[n][n];
            for (int i = 0; i < queue.length; i++) {
                Arrays.fill(queue[i], '.');
            }
            dfs(n, 0, queue, resList);
            return resList;
        }

        // 在第row 行尝试放入一个queue
        private void dfs(int n, int row, char[][] queue, List<List<String>> resList) {
            if (row == n) {
                List<String> tempList = new ArrayList<>();
                for (char[] ch : queue) {
                    tempList.add(new String(ch));
                }
                resList.add(tempList);
                return;
            }

            for (int col = 0; col < n; col++) {
                if (isValid(queue, row, col)) {
                    queue[row][col] = 'Q';
                    dfs(n, row + 1, queue, resList);
                    queue[row][col] = '.';
                }
            }
        }

        private boolean isValid(char[][] queue, int row, int col) {
            // 往上看
            for (int i = row - 1; i >= 0; i--) {
                if (queue[i][col] == 'Q') {
                    return false;
                }
            }

            // 往右上角看 row = row - 1; col = col + 1
            for (int i = row - 1, j = col + 1; i >= 0 && j < queue.length; i--, j++) {
                if (queue[i][j] == 'Q') {
                    return false;
                }
            }

            // 往左上角看 row = row - 1, col = col - 1
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (queue[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}