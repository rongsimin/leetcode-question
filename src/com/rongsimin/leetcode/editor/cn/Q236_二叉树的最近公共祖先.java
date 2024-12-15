package com.rongsimin.leetcode.editor.cn;

/**
 * 2024-12-14 16:49:14
 **/
public class Q236_二叉树的最近公共祖先 {
    public static void main(String[] args) {
        Solution solution = new Q236_二叉树的最近公共祖先().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return findNode(root, p.val, q.val);
        }

        private TreeNode findNode(TreeNode node, int p, int q) {
            if (node == null) {
                return null;
            }
            if (node.val == p || node.val == q) {
                return node;
            }
            TreeNode node1 = findNode(node.left, p, q);
            TreeNode node2 = findNode(node.right, p, q);
            if (node1 != null && node2 != null) {
                return node;
            } else if (node1 != null) {
                return node1;
            } else {
                return node2;
            }
        }

        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val == root.val || q.val == root.val) {
                return root;
            }
            boolean pInLeft = findNode2(root.left, p);
            boolean qInLeft = findNode2(root.left, q);

            if (pInLeft && qInLeft) {
                return lowestCommonAncestor2(root.left, p, q);
            } else if (!pInLeft && !qInLeft) {
                return lowestCommonAncestor2(root.right, p, q);
            } else {
                return root;
            }
        }

        private boolean findNode2(TreeNode node, TreeNode target) {
            if (node == null) {
                return false;
            }
            if (node.val == target.val) {
                return true;
            }
            return findNode2(node.left, target) || findNode2(node.right, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}