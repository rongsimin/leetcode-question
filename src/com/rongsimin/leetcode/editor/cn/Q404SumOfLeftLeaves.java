//给定二叉树的根节点 root ，返回所有左叶子之和。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [3,9,20,null,null,15,7] 
//输出: 24 
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// 
//
// 示例 2: 
//
// 
//输入: root = [1]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 1000] 范围内 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 643, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 404.左叶子之和
 *
 * @author rsm
 * @date 2023-08-26 11:40:57
 */
public class Q404SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new Q404SumOfLeftLeaves().new Solution();
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
        private int sum;
        public int sumOfLeftLeaves(TreeNode root) {
            traverse(root);
            return sum;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            traverse(root.left);
            traverse(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}