package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2024-12-15 16:37:09
 **/
public class Q90_子集II {
    public static void main(String[] args) {
        Solution solution = new Q90_子集II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> resList = new ArrayList<>();
        private boolean[] isVisited;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            isVisited = new boolean[nums.length];
            Arrays.sort(nums);
            List<Integer> tempList = new ArrayList<>();
            dfs(nums, tempList, 0);
            return resList;
        }

        private void dfs(int[] nums, List<Integer> tempList, int index) {
            resList.add(new ArrayList<>(tempList));
            for (int i = index; i < nums.length; i++) {
                // 做选择
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }

                tempList.add(nums[i]);
                // 往下一层
                dfs(nums, tempList, i + 1);
                // 撤销选择
                tempList.remove(tempList.size() - 1);
            }
        }
        private void dfs2(int[] nums, List<Integer> tempList, int index) {
            resList.add(new ArrayList<>(tempList));
            for (int i = index; i < nums.length; i++) {
                // 做选择
                if (i >= 1 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                    continue;
                }

                tempList.add(nums[i]);
                isVisited[i] = true;
                // 往下一层
                dfs2(nums, tempList, i + 1);
                // 撤销选择
                tempList.remove(tempList.size() - 1);
                isVisited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}