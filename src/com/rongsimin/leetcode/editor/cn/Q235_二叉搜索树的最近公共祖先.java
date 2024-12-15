package com.rongsimin.leetcode.editor.cn;

/**
 * 2024-12-14 15:00:24
 **/
public class Q235_二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        Solution solution = new Q235_二叉搜索树的最近公共祖先().new Solution();
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
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}