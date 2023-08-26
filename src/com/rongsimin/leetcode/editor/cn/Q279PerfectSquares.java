//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics广度优先搜索 | 数学 | 动态规划 
//
// 👍 1792, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 279.完全平方数
 *
 * @author rsm
 * @date 2023-08-24 21:57:58
 */
public class Q279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new Q279PerfectSquares().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            // nums[0] -> n
            // nums[1] -> distance
            Deque<int[]> queue = new LinkedList<>();
            queue.addLast(new int[]{n, 0});
            boolean[] isVisited = new boolean[n + 1];
            isVisited[n] = true;
            while (!queue.isEmpty()) {
                int[] nums = queue.removeFirst();
                int num = nums[0];
                int step = nums[1];
                for (int i = 1; ; i++) {
                    int a = num - i * i;
                    if (a < 0) {
                        break;
                    }
                    if (a == 0) {
                        return step + 1;
                    }
                    if (!isVisited[a]) {
                        queue.addLast(new int[]{a, step + 1});
                        isVisited[a] = true;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}