//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可
//流向大西洋 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 数组 | 矩阵 
//
// 👍 623, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417.太平洋大西洋水流问题
 *
 * @author rsm
 * @date 2023-08-31 16:20:46
 */
public class Q417PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new Q417PacificAtlanticWaterFlow().new Solution();
        int[][] heights = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(solution.pacificAtlantic(heights));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            boolean[][] canPacific = new boolean[m][n];
            boolean[][] canAtlantic = new boolean[m][n];

            // 遍历首行和末行
            for (int i = 0; i < n; i++) {
                dfs(0, i, canPacific, heights[0][i], heights);
                dfs(m - 1, i, canAtlantic, heights[m - 1][i], heights);
            }

            // 遍历首列和末列
            for (int i = 0; i < m; i++) {
                dfs(i, 0, canPacific, heights[i][0], heights);
                dfs(i, n - 1, canAtlantic, heights[i][n - 1], heights);
            }
            List<List<Integer>> resList = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canPacific[i][j] && canAtlantic[i][j]) {
                        resList.add(Arrays.asList(i, j));
                    }
                }
            }
            return resList;
        }

        private void dfs(int i, int j, boolean[][] isVisited, int height, int[][] heights) {
            if (!inArea(i, j, heights) || isVisited[i][j] || height > heights[i][j]) {
                return;
            }
            isVisited[i][j] = true;
            dfs(i + 1, j, isVisited, heights[i][j], heights);
            dfs(i - 1, j, isVisited, heights[i][j], heights);
            dfs(i, j + 1, isVisited, heights[i][j], heights);
            dfs(i, j - 1, isVisited, heights[i][j], heights);
        }

        private boolean inArea(int i, int j, int[][] heights) {
            return i >= 0 && i < heights.length && j >= 0 && j < heights[0].length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}