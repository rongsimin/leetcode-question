package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-14 16:33:53
 **/
public class Q230_二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        Solution solution = new Q230_二叉搜索树中第K小的元素().new Solution();
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1, null, two);
        TreeNode root = new TreeNode(3, one, four);
        System.out.println(solution.kthSmallest(root, 1));
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
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list, k);
            return list.get(k - 1);
        }

        private void inorder(TreeNode node, List<Integer> list, int k) {
            if (node == null || list.size() >= k) {
                return;
            }
            inorder(node.left, list, k);
            list.add(node.val);
            inorder(node.right, list, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}