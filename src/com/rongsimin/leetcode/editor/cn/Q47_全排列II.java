package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2024-12-15 17:21:22
 **/
public class Q47_全排列II {
    public static void main(String[] args) {
        Solution solution = new Q47_全排列II().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> resList = new ArrayList<>();
        private boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<Integer> tempList = new ArrayList<>();
            used = new boolean[nums.length];
            dfs(nums, tempList);
            return resList;
        }

        private void dfs(int[] nums, List<Integer> tempList) {
            if (tempList.size() == nums.length) {
                resList.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                used[i] = true;
                dfs(nums, tempList);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}