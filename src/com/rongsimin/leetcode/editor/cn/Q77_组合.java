package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-15 15:46:15
 **/
public class Q77_组合 {
    public static void main(String[] args) {
        Solution solution = new Q77_组合().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> resList = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            List<Integer> tempList = new ArrayList<>();
            dfs(n, 1, tempList, k);
            return resList;
        }

        /**
         * @param n        选择列表[i,n]
         * @param i        选择
         * @param tempList 路径
         * @param k        目标 tempList.size == k
         */
        private void dfs(int n, int i, List<Integer> tempList, int k) {
            if (tempList.size() == k) {
                resList.add(new ArrayList<>(tempList));
                return;
            }
            for (int j = i; j <= n; j++) {
                // 做选择
                tempList.add(j);
                // 往下一层
                dfs(n, j + 1, tempList, k);
                // 撤销选择
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}