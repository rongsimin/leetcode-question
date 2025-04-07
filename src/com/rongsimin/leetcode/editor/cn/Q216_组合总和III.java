package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-15 17:55:53
 **/
public class Q216_组合总和III {
    public static void main(String[] args) {
        Solution solution = new Q216_组合总和III().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> resList = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            List<Integer> tempList = new ArrayList<>();
            dfs(k, n, tempList, 1, 0, 0);
            return resList;
        }

        private void dfs(int k, int n, List<Integer> tempList, int start, int count, int total) {
            if (count > k || total > n) {
                return;
            }
            if (count == k && total == n) {
                resList.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = start; i <= 9; i++) {
                if (i > n) {
                    break;
                }
                total += i;
                count++;
                tempList.add(i);
                dfs(k, n, tempList, i + 1, count, total);
                total -= i;
                count--;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}