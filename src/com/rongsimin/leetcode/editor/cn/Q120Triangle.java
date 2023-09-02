//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 1253, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120.三角形最小路径和
 *
 * @author rsm
 * @date 2023-09-01 10:29:29
 */
public class Q120Triangle {
    public static void main(String[] args) {
        Solution solution = new Q120Triangle().new Solution();
        System.out.println(solution.minimumTotal(new ArrayList<>(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3)))));
        System.out.println(solution.minimumTotal(new ArrayList<>(Arrays.asList(Arrays.asList(-1), Arrays.asList(-2, -3)))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int size = triangle.size();
            int[][] dp = new int[size][size];
            List<Integer> list = triangle.get(size - 1);
            for (int i = 0; i < list.size(); i++) {
                dp[size - 1][i] = list.get(i);
            }
            for (int level = size - 2; level >= 0; level--) {
                list = triangle.get(level);
                for (int i = 0; i < list.size(); i++) {
                    dp[level][i] = Math.min(dp[level + 1][i], dp[level + 1][i + 1]) + list.get(i);
                }
            }
            return dp[0][0];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}