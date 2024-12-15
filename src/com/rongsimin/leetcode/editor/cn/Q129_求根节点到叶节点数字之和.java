package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-14 11:15:46
 **/
public class Q129_求根节点到叶节点数字之和 {
    public static void main(String[] args) {
        Solution solution = new Q129_求根节点到叶节点数字之和().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int sumNumbers(TreeNode root) {
            List<Integer> valList = new ArrayList<>();
            dfs(root, valList, 0);
            int res = 0;
            for (Integer val : valList) {
                res += val;
            }
            return res;
        }

        /**
         * @param node    遍历到 node 节点
         * @param valList 用来存放从 根节点到 所有叶子节点的字符串列表
         * @param val     用来存放从 根节点到 node节点的
         */
        private void dfs(TreeNode node, List<Integer> valList, int val) {
            val = val * 10 + node.val;
            if (node.left == null && node.right == null) {
                valList.add(val);
                return;
            }
            if (node.left != null) {
                dfs(node.left, valList, val);
            }
            if (node.right != null) {
                dfs(node.right, valList, val);
            }
        }

        public int sumNumbers2(TreeNode root) {
            List<String> valList = new ArrayList<>();
            dfs2(root, valList, "");
            int res = 0;
            for (String val : valList) {
                res += Integer.parseInt(val);
            }
            return res;
        }

        /**
         * @param node    遍历到 node 节点
         * @param valList 用来存放从 根节点到 所有叶子节点的字符串列表
         * @param str     用来存放从 根节点到 node节点的字符串
         */
        private void dfs2(TreeNode node, List<String> valList, String str) {
            str = str + node.val;
            if (node.left == null && node.right == null) {
                valList.add(str);
                return;
            }
            if (node.left != null) {
                dfs2(node.left, valList, str);
            }
            if (node.right != null) {
                dfs2(node.right, valList, str);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}