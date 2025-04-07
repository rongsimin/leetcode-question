package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2024-12-15 17:43:37
 **/
public class QLCR082_组合总和II {
    public static void main(String[] args) {
        Solution solution = new QLCR082_组合总和II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> resList = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<Integer> tempList = new ArrayList<>();
            dfs(candidates, tempList, 0, target, 0);
            return resList;
        }

        private void dfs(int[] candidates, List<Integer> tempList, int total, int target, int start) {
            if (total > target) {
                return;
            }
            if (total == target) {
                resList.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (candidates[i] > target) {
                    break;
                }
                total += candidates[i];
                tempList.add(candidates[i]);
                dfs(candidates, tempList, total, target, i + 1);
                total -= candidates[i];
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}