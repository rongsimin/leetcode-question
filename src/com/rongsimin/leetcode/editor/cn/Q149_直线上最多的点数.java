package com.rongsimin.leetcode.editor.cn;
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
// 👍 575, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class Q149_直线上最多的点数 {
    public static void main(String[] args) {
        Solution solution = new Q149_直线上最多的点数().new Solution();
        int[][] points = {
                {1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}
        };
        System.out.println(solution.maxPoints(points));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            if (points.length < 3) {
                return points.length;
            }
            int res = 0;
            for (int i = 0; i < points.length - 2; i++) {
                for (int j = i + 1; j < points.length - 1; j++) {
                    int maxPoints = 2;
                    // (y1 - y2) / (x1 - x2) = (y1 - y3) / (x1 - x3) 说明在一条直线上
                    // 换个写法 (y1 - y2) * (x1 - x3) = (y1 - y3) * (x1 - x2)
                    for (int k = j + 1; k < points.length; k++) {
                        if (isValid(points, i, j, k)) {
                            maxPoints++;
                        }
                    }
                    res = Math.max(res, maxPoints);
                }
            }
            return res;
        }

        private boolean isValid(int[][] points, int i, int j, int k) {
            // 换个写法 (y1 - y2) * (x1 - x3) = (y1 - y3) * (x1 - x2)
            return (points[i][1] - points[j][1]) * (points[i][0] - points[k][0]) == (points[i][1] - points[k][1]) * (points[i][0] - points[j][0]);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}