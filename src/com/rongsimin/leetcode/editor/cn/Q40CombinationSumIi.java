//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1428, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40.组合总和 II
 *
 * @author rsm
 * @date 2023-08-30 22:07:04
 */
public class Q40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new Q40CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> resList = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates, 0, target, new LinkedList<>());
            return resList;
        }

        private void dfs(int[] candidates, int index, int target, LinkedList<Integer> list) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                resList.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                target -= candidates[i];
                list.add(candidates[i]);
                dfs(candidates, i + 1, target, list);
                target += candidates[i];
                list.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}