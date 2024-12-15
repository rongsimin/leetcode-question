package com.rongsimin.leetcode.editor.cn;
//给定一个二叉树，判断它是否是 平衡二叉树 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 1568, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 2024-12-14 09:22:29
 **/
public class Q110_平衡二叉树 {
    public static void main(String[] args) {
        Solution solution = new Q110_平衡二叉树().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int getHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}