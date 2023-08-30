//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// Related Topics树 | 二叉搜索树 | 二叉树 
//
// 👍 1219, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 450.删除二叉搜索树中的节点
 *
 * @author rsm
 * @date 2023-08-29 16:06:49
 */
public class Q450DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new Q450DeleteNodeInABst().new Solution();
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
            TreeNode delNode = find(root, key);
            if (delNode == null) {
                return root;
            }
            return deleteNode(root, delNode);
        }

        /**
         * 在以root为根节点的二叉树中，删除delNode，并返回删除后的根节点
         *
         * @param root
         * @param delNode
         * @return
         */
        private TreeNode deleteNode(TreeNode root, TreeNode delNode) {
            if (root.val == delNode.val) {
                // root就是要删除的节点
                if (root.right == null) {
                    //TreeNode left = root.left;
                    //root.left = null;
                    //return left;
                    return root.left;
                } else if (root.left == null) {
                    //TreeNode right = root.right;
                    //root.right = null;
                    //return right;
                    return root.right;
                } else {
                    // 左右子树都存在，要删除5
                    TreeNode minNode = findMin(root.right); // 8
                    minNode.right = deleteNode(root.right, minNode);
                    minNode.left = root.left;
                    return minNode;
                }
            } else if (root.val < delNode.val) {
                // 要删除的节点在右边
                root.right = deleteNode(root.right, delNode);
                return root;
            } else {
                root.left = deleteNode(root.left, delNode);
                return root;
            }
        }

        private TreeNode deleteMin(TreeNode node) {
            if (node.left == null) {
                return node.right;
            }
            node.left = deleteMin(node.left);
            return node;
        }

        private TreeNode findMin(TreeNode node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        private TreeNode find(TreeNode root, int key) {
            if (root == null) {
                return null;
            } else if (root.val == key) {
                return root;
            } else if (root.val < key) {
                return find(root.right, key);
            } else {
                return find(root.left, key);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}