package com.rongsimin.leetcode.editor.cn;

/**
 * 2024-12-14 10:04:30
 **/
public class Q404_左叶子之和 {
    public static void main(String[] args) {
        Solution solution = new Q404_左叶子之和().new Solution();
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
            return sumOfLeftLeaves(root, false);
        }

        /**
         * 直接通过递归方法的返回值进行求和
         *
         * @param node
         * @param isLeft
         * @return
         */
        private int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
            if (node.left == null && node.right == null) {
                if (isLeft) {
                    return node.val;
                } else {
                    return 0;
                }
            }
            int res = 0;
            if (node.left != null) {
                res += sumOfLeftLeaves(node.left, true);
            }
            if (node.right != null) {
                res += sumOfLeftLeaves(node.right, false);
            }

            return res;
        }


        public int sumOfLeftLeaves2(TreeNode root) {
            sumOfLeftLeaves2(root, false);
            return sum;
        }

        /**
         * 通过全局变量的形式，因为在叶子节点，已经对sum进行了求和，所以递归方法的返回值要是void
         *
         * @param node
         * @param isLeft
         */

        private void sumOfLeftLeaves2(TreeNode node, boolean isLeft) {
            // 左叶子的定义，第一：要遍历到叶子节点，第二：要是左孩子，所以使用变量 isLeft来标记
            if (node.left == null && node.right == null) {
                if (isLeft) {
                    sum += node.val;
                }
                return;
            }

            if (node.left != null) {
                sumOfLeftLeaves2(node.left, true);
            }
            if (node.right != null) {
                sumOfLeftLeaves2(node.right, false);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}