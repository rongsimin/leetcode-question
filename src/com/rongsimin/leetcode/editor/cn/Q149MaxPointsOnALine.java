//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
//
// 
//
// 示例 1： 
// 
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
// 
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// points 中的所有点 互不相同 
// 
//
// Related Topics几何 | 数组 | 哈希表 | 数学 
//
// 👍 505, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 149.直线上最多的点数
 *
 * @author rsm
 * @date 2023-08-19 11:45:12
 */
public class Q149MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new Q149MaxPointsOnALine().new Solution();

        System.out.println(solution.maxPoints(new int[][]{
                {1,1},
                {2,2},
                {3,3}
        }));
        System.out.println(solution.maxPoints(new int[][]{
                {1,1},
                {3,2},
                {5,3},
                {4,1},
                {2,3},
                {1,4}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxPoints(int[][] points) {
            int maxCount = 1;
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    int count = 2;
                    for (int k = j + 1; k < points.length; k++) {
                        // points[i]、points[j]、points[k]
                        int[] point1 = points[i];
                        int[] point2 = points[j];
                        int[] point3 = points[k];
                        // (y2 - y1) / (x2 - x1) = (y3 - y1) / (x3 - x1)
                        // (y2 - y1) * (x3 - x1) = (y3 - y1) * (x2 - x1)
                        int s1 = (point2[1] - point1[1]) * (point3[0] - point1[0]);
                        int s2 = (point3[1] - point1[1]) * (point2[0] - point1[0]);
                        if (s1 == s2) {
                            count++;
                        }
                    }
                    maxCount = Math.max(maxCount, count);
                }
            }

            return maxCount;
        }
        public int maxPoints2(int[][] points) {
            /**
             * 先取一个点，其它点和它之间，可以计算出斜率，比如有2个点到它的斜率相等，那么这三个点就在一条直线上
             * 假设有n个点呢，那么就是n + 1；
             * key -> 斜率， value -> count
             * [-1, 1] [1, -1]
             */
            int max = 1;
            for (int i = 0; i < points.length; i++) {
                Map<Integer, Integer> countMap = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (i == j) continue;
                    int key = cal(i, j, points);
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                }

                for (Integer value : countMap.values()) {
                    if (value > max) {
                        max = value + 1;
                    }
                }
            }
            return max;
        }

        private int cal(int i, int j, int[][] points) {
            int[] point1 = points[i];
            int[] point2 = points[j];
            int y = point2[1] - point1[1];
            int x = point2[0] - point1[0];

            return y / x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}