package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-14 10:50:52
 **/
public class Q113_路径总和II {
    public static void main(String[] args) {
        Solution solution = new Q113_路径总和II().new Solution();
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
        private List<List<Integer>> resList = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return resList;
            }
            List<Integer> tempList = new ArrayList<>();
            dfs(root, tempList, 0, targetSum);
            return resList;
        }

        /**
         * @param node      递归到 node 节点
         * @param tempList  存放 从根节点 到 node 节点的列表
         * @param total     存放 从根节点 到 node 节点之和
         * @param targetSum 目标值
         */
        private void dfs(TreeNode node, List<Integer> tempList, int total, int targetSum) {
            total += node.val;
            tempList.add(node.val);
            if (node.left == null && node.right == null) {
                if (total == targetSum) {
                    resList.add(tempList);
                }
                return;
            }
            if (node.left != null) {
                dfs(node.left, new ArrayList<>(tempList), total, targetSum);
            }
            if (node.right != null) {
                dfs(node.right, new ArrayList<>(tempList), total, targetSum);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}