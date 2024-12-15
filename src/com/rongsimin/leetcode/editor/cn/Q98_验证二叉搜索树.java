package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-14 15:08:45
 **/
public class Q98_验证二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new Q98_验证二叉搜索树().new Solution();
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

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode node, long lower, long upper) {
            if (node == null) {
                return true;
            }
            if (node.val >= upper || node.val <= lower) {
                return false;
            }

            return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
        }

        public boolean isValidBST2(TreeNode root) {
            // 中序遍历
            List<Integer> list = new ArrayList<>();
            inorder(root, list);

            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) >= list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }

        private void inorder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }

        /**
         * 错误，只考虑了左右孩子，但是其实要考虑整个左右子树，都满足才行
         * 5
         * /   |
         * 4    6
         * /  |
         * 3   7
         *
         * @param root
         * @return
         */
        public boolean isValidBSTWrong(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left != null && root.left.val >= root.val) {
                return false;
            }
            if (root.right != null && root.right.val <= root.val) {
                return false;
            }
            return isValidBSTWrong(root.left) && isValidBSTWrong(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}