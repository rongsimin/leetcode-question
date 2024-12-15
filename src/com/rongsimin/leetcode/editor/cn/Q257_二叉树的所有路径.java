package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-14 10:36:27
 **/
public class Q257_二叉树的所有路径 {
    public static void main(String[] args) {
        Solution solution = new Q257_二叉树的所有路径().new Solution();
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
        private List<String> resList = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            dfs(root, String.valueOf(root.val));
            return resList;
        }


        /**
         * @param node    当前遍历到的节点位置
         * @param pathStr 遍历到 node 节点时，经过的路径
         */
        private void dfs(TreeNode node, String pathStr) {
            if (node.left == null && node.right == null) {
                resList.add(pathStr);
                return;
            }
            if (node.left != null) {
                dfs(node.left, pathStr + "->" + node.left.val);
            }
            if (node.right != null) {
                dfs(node.right, pathStr + "->" + node.right.val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}