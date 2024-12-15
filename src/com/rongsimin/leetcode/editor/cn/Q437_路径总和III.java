package com.rongsimin.leetcode.editor.cn;

/**
 * 2024-12-14 11:36:24
 **/
public class Q437_路径总和III {
    public static void main(String[] args) {
        Solution solution = new Q437_路径总和III().new Solution();
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
        private int find;

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            findPath(root, targetSum, 0);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
            return find;
        }

        private void findPath(TreeNode node, int targetSum, long total) {
            total += node.val;
            if (total == targetSum) {
                find++;
            }
            if (node.left == null && node.right == null) {
                return;
            }
            if (node.left != null) {
                findPath(node.left, targetSum, total);
            }
            if (node.right != null) {
                findPath(node.right, targetSum, total);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}