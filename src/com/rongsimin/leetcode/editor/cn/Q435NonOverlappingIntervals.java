//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
//
// Related Topics贪心 | 数组 | 动态规划 | 排序 
//
// 👍 1035, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 435.无重叠区间
 *
 * @author rsm
 * @date 2023-09-07 21:44:32
 */
public class Q435NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new Q435NonOverlappingIntervals().new Solution();
        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
        intervals = new int[][]{{1,2},{1,2},{1,2}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
        intervals = new int[][]{{1,2},{2, 3}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
            int n = intervals.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 1; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (intervals[i][0] >= intervals[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(dp[i], max);
            }
            return n - dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}