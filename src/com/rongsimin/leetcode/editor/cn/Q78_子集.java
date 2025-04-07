package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-15 16:06:10
 **/
public class Q78_子集 {
    public static void main(String[] args) {
        Solution solution = new Q78_子集().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> resList = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> tempList = new ArrayList<>();
            dfs(nums, tempList, 0);
            return resList;
        }

        private void dfs(int[] nums, List<Integer> tempList, int index) {
            resList.add(new ArrayList<>(tempList));
            if (index == nums.length) {
                return;
            }
            for (int i = index; i < nums.length; i++) {
                tempList.add(nums[i]);
                dfs(nums, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}