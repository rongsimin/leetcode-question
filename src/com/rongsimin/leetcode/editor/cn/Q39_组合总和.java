package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2024-12-15 15:31:10
 **/
public class Q39_组合总和 {
    public static void main(String[] args) {
        Solution solution = new Q39_组合总和().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> resList = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> tempList = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, tempList, 0, 0, target);
            return resList;
        }

        /**
         * @param candidates 选择列表
         * @param tempList   路径
         * @param total      路径和
         * @param target     目标
         */
        private void dfs(int[] candidates, List<Integer> tempList, int index, int total, int target) {
            if (total > target) {
                return;
            }
            if (total == target) {
                resList.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                // 做选择
                tempList.add(candidates[i]);
                total += candidates[i];
                // 往下一层
                dfs(candidates, tempList, i, total, target);
                // 撤销选择
                tempList.remove(tempList.size() - 1);
                total -= candidates[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}