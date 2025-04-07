package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-15 15:09:18
 **/
public class Q46_全排列 {
    public static void main(String[] args) {
        Solution solution = new Q46_全排列().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> resList = new ArrayList<>();
        private boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            visited = new boolean[nums.length];
            List<Integer> tempList = new ArrayList<>();
            backtrack(nums, tempList);
            return resList;
        }

        /**
         * @param nums     选择列表
         * @param tempList 路径
         */
        private void backtrack(int[] nums, List<Integer> tempList) {
            if (tempList.size() == nums.length) {
                resList.add(tempList);
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    // 做选择
                    tempList.add(nums[i]);
                    visited[i] = true;
                    // backtrack
                    backtrack(nums, new ArrayList<>(tempList));
                    // 撤销选择
                    tempList.remove(tempList.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}