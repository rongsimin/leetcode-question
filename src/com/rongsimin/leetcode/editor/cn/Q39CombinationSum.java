//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// candidates 的所有元素 互不相同 
// 1 <= target <= 40 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2576, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
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
 * 39.组合总和
 *
 * @author rsm
 * @date 2023-08-18 17:24:50
 */
public class Q39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new Q39CombinationSum().new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> resList = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

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
            for (int i = index; i <= candidates.length - 1; i++) {
                if (target < candidates[i]) {
                    break;
                }
                list.add(candidates[i]);
                target -= candidates[i];
                dfs(candidates, i, target, list);
                //dfs(candidates, i + 1, target, list);
                target += candidates[i];
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}