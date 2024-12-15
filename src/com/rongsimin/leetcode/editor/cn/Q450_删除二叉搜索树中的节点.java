package com.rongsimin.leetcode.editor.cn;

/**
 * 2024-12-14 15:50:56
 * 20分钟没思路
 * 第二次：2024-12-14 18:10:56
 **/
public class Q450_删除二叉搜索树中的节点 {
    public static void main(String[] args) {
        Solution solution = new Q450_删除二叉搜索树中的节点().new Solution();
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            TreeNode afterNode = null;
            if (root.val > key) {
                // 要删除的节点在root左边
                root.left = deleteNode(root.left, key);
                afterNode = root;
            } else if (root.val < key) {
                // 要删除的节点在root右边
                root.right = deleteNode(root.right, key);
                afterNode = root;
            } else {
                // 要删除的就是 root 节点
                if (root.left == null) {
                    //如果左子树为空，那么返回右子树即可
                    afterNode = root.right;
                } else if (root.right == null) {
                    //如果右子树为空，那么返回左子树即可
                    afterNode = root.left;
                } else {
                    // 左右子树都不为空，那么找到右子树里面的最小值，来作为根节点
                    // 删除右子树里面的最小值
                    // 这个新的根节点左边连接原来的左边
                    // 这个新的根节点右边连接原来的右边
                    TreeNode minNode = findMin(root.right);
                    TreeNode afterRemove = removeMin(root.right);
                    minNode.left = root.left;
                    minNode.right = afterRemove;
                    afterNode = minNode;
                }

            }
            return afterNode;
        }

        // 删除 node 为根节点里面的最小值
        private TreeNode removeMin(TreeNode node) {
            if (node.left == null) {
                // 说明 node 就是最小值
                return node.right;
            }
            node.left = removeMin(node.left);
            return node;
        }

        private TreeNode findMin(TreeNode node) {
            if (node == null) {
                return null;
            }
            if (node.left == null) {
                return node;
            }
            return findMin(node.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}