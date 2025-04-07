package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2024-12-29 17:05:30
 **/
public class Q417_太平洋大西洋水流问题 {
    public static void main(String[] args) {
        Solution solution = new Q417_太平洋大西洋水流问题().new Solution();
        int[][] heights = new int[][]{{10, 10, 10}, {10, 1, 10}, {10, 10, 10}};
        System.out.println(solution.pacificAtlantic(heights));
        heights = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        System.out.println(solution.pacificAtlantic(heights));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] diff = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1},
        };

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            boolean[][] canPacific = new boolean[m][n];
            boolean[][] canAtlantic = new boolean[m][n];
            List<List<Integer>> resList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                dfs(heights, 0, i, heights[0][i], canPacific);
                dfs(heights, m - 1, i, heights[m - 1][i], canAtlantic);
            }
            for (int i = 0; i < m; i++) {
                dfs(heights, i, 0, heights[i][0], canPacific);
                dfs(heights, i, n - 1, heights[i][n - 1], canAtlantic);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canPacific[i][j] && canAtlantic[i][j]) {
                        resList.add(Arrays.asList(i, j));
                    }
                }
            }
            return resList;
        }

        private void dfs(int[][] heights, int i, int j, int height, boolean[][] canReach) {
            if (!inArea(heights, i, j) || canReach[i][j] || height > heights[i][j]) {
                return;
            }
            canReach[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int addX = diff[k][0];
                int addY = diff[k][1];
                // 挪动的时候，比较的是 heights[i][j] 与 heights[i + addX][j + addY]
                dfs(heights, i + addX, j + addY, heights[i][j], canReach);
            }
        }

        private boolean inArea(int[][] heights, int i, int j) {
            return i >= 0 && i < heights.length && j >= 0 && j < heights[0].length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}