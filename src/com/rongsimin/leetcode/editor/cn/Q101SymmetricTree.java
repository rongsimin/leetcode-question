//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 2515, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 101.对称二叉树
 *
 * @author rsm
 * @date 2023-08-25 17:35:23
 */
public class Q101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Q101SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSimilar(root.left, root.right);
        }

        private boolean isSimilar(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return isSimilar(left.left, right.right) && isSimilar(left.right, right.left);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}