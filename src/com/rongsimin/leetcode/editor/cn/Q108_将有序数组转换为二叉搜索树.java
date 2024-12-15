package com.rongsimin.leetcode.editor.cn;

/**
 * 2024-12-14 16:12:11
 **/
public class Q108_将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new Q108_将有序数组转换为二叉搜索树().new Solution();
        System.out.println(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTree(nums, 0, nums.length - 1);
        }

        /**
         * 构建一个左边界为left,右边界是right的平衡二叉树，返回根节点
         *
         * @param nums
         * @param left
         * @param right
         * @return 根节点
         */
        private TreeNode buildTree(int[] nums, int left, int right) {
            if (left == right) {
                return new TreeNode(nums[left]);
            }
            if (left > right) {
                return null;
            }
            int rootIndex = (right + left) / 2;
            TreeNode root = new TreeNode(nums[rootIndex]);
            root.left = buildTree(nums, left, rootIndex - 1);
            root.right = buildTree(nums, rootIndex + 1, right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}