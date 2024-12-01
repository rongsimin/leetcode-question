package com.rongsimin.leetcode.editor.cn;
//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的欧式距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。 
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
// 👍 318, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashMap;
import java.util.Map;

public class Q447_回旋镖的数量{
    public static void main(String[] args) {
        //Solution solution = new Q447_回旋镖的数量().new Solution();
        //int[][] points = {
        //        {1,1},
        //        {2,2},
        //        {3,3}
        //};
        //System.out.println(solution.numberOfBoomerangs(points));
        //int[][] points = {
        //        {0,0},
        //        {1,0},
        //        {2,0}
        //};
        //System.out.println(solution.numberOfBoomerangs(points));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = calcDistance(points[i], points[j]);
                    countMap.putIfAbsent(distance, 0);
                    countMap.put(distance, countMap.get(distance) + 1);
                }
            }
            for (Integer key : countMap.keySet()) {
                if (countMap.get(key) != 1) {
                    res += countMap.get(key) * (countMap.get(key) - 1);
                }
            }
        }
        return res;
    }
    private int calcDistance(int[] pointX, int[] pointY) {
        return (pointY[0] - pointX[0]) * (pointY[0] - pointX[0]) + (pointY[1] - pointX[1]) * (pointY[1] - pointX[1]);
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}