//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 739, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216.组合总和 III
 *
 * @author rsm
 * @date 2023-08-31 09:11:00
 */
public class Q216CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new Q216CombinationSumIii().new Solution();
        System.out.println(solution.combinationSum3(3, 9));
        System.out.println(solution.combinationSum3(3, 7));
        System.out.println(solution.combinationSum3(4, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> resList = new ArrayList<>();
            if (k > n) {
                return resList;
            }
            dfs(n, k, 1, new LinkedList<>(), resList);
            return resList;
        }

        /**
         * 以start开头，9结尾的整数中，找出k个数字，使其和为 n
         * @param n
         * @param k
         * @param start
         * @param list
         * @param resList
         */
        private void dfs(int n, int k, int start, LinkedList<Integer> list, List<List<Integer>> resList) {
            if (n < 0) {
                return;
            }
            if (n == 0) {
                if (k == list.size()) {
                    resList.add(new ArrayList<>(list));
                }
                return;
            }
            for (int i = start; i <= 9; i++) {
                if (i > n) {
                    break;
                }
                n -= i;
                list.addLast(i);
                dfs(n, k, i + 1, list, resList);
                n += i;
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}