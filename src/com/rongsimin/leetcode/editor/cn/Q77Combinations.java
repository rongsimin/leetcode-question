//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics回溯 
//
// 👍 1476, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.*;

/**
 * 77.组合
 *
 * @author rsm
 * @date 2023-08-30 20:33:49
 */
public class Q77Combinations {
    public static void main(String[] args) {
        Solution solution = new Q77Combinations().new Solution();
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> resList = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            // 从 start 开始，找 k个数
            dfs(n, k, 1, new LinkedList<>());
            return resList;
        }

        private void help(int n, int k, int start, LinkedList<Integer> list) {
            if (list.size() == k) {
                resList.add((List<Integer>) list.clone());
                return;
            }
            // 从[start,n]之间至少要包含k - list.size()个元素，为什么是k - list.size()，因为
            // 当前list中包含了size个，还剩下k - size个空位需要添加，
            // 所以start最大只能到 n - (k - list.size()) + 1
            for (int i = start; i <= n - (k - list.size()) + 1; i++) {
                list.addLast(i);
                help(n, k, i + 1, list);
                list.removeLast();
            }
        }

        private void dfs(int n, int k, int start, LinkedList<Integer> list) {
            if (k == 0) {
                resList.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i <= n - k + 1; i++) {
                list.add(i);
                dfs(n, k - 1, i + 1, list);
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}