//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 1694, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 437.路径总和 III
 *
 * @author rsm
 * @date 2023-08-29 11:19:05
 */
public class Q437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new Q437PathSumIii().new Solution();
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
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            // 1、当前节点在这个路径中
            int one = (int) findSum(root, targetSum);
            // 2、当前节点不在这个路径中
            int two = pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
            return one + two;
        }

        private long findSum(TreeNode root, long targetSum) {
            if (root == null) {
                return 0;
            }
            long count = 0;
            if (root.val == targetSum) {
                count++;
            }
            count += findSum(root.left, targetSum - root.val);
            count += findSum(root.right, targetSum - root.val);
            return count;
        }

        private int findSum2(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            // 叶子节点会终止，
            if (root.val == targetSum) {

            }
            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    return 1;
                }
                return 0;
            }
            int left = findSum2(root.left, targetSum - root.val);
            int right = findSum2(root.right, targetSum - root.val);
            return left + right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}