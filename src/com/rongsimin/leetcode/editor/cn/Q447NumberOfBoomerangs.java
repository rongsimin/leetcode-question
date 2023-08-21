//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 互不相同 
// 
//
// Related Topics数组 | 哈希表 | 数学 
//
// 👍 254, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 447.回旋镖的数量
 *
 * @author rsm
 * @date 2023-08-19 10:36:19
 */
public class Q447NumberOfBoomerangs {
    public static void main(String[] args) {
        Solution solution = new Q447NumberOfBoomerangs().new Solution();
        System.out.println(solution.numberOfBoomerangs(new int[][]{
                {0,0},
                {1,0},
                {2,0}
        }));
        System.out.println(solution.numberOfBoomerangs(new int[][]{
                {1,1},
                {2,2},
                {3,3}
        }));
        System.out.println(solution.numberOfBoomerangs(new int[][]{
                {0,0},
                {1,0},
                {-1,0},
                {0,1},
                {0, -1}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int n = points.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> countMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    int distance = distance(i, j, points);
                    countMap.put(distance, countMap.getOrDefault(distance, 0) + 1);
                }
                for (Integer value : countMap.values()) {
                    if (value > 1) {
                        count += value * (value - 1);
                    }
                }
            }
            return count;
        }

        private int distance(int i, int j, int[][] points) {
            int[] point1 = points[i];
            int[] point2 = points[j];

            return (int) (Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}