//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 字符串 | 回溯 | 二叉树 
//
// 👍 1017, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 257.二叉树的所有路径
 *
 * @author rsm
 * @date 2023-08-29 09:54:37
 */
public class Q257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new Q257BinaryTreePaths().new Solution();
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

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> resList = new ArrayList<>();
            dnf(root, resList, "");
            return resList;
        }

        private void dnf(TreeNode root, List<String> resList, String temp) {
            if (root.left == null && root.right == null) {
                temp += root.val;
                resList.add(temp);
                return;
            }
            temp += root.val + "->";
            if (root.left != null) {
                dnf(root.left, resList, temp);
            }
            if (root.right != null) {
                dnf(root.right, resList, temp);
            }
        }

        public List<String> binaryTreePaths2(TreeNode root) {
            List<String> list = new ArrayList<>();
            dfs(list, root, "");
            return list;
        }

        private void dfs(List<String> list, TreeNode root, String temp) {
            if (root.left == null && root.right == null) {
                list.add(temp + root.val);
                return;
            }
            if (root.left != null) {
                dfs(list, root.left, temp + root.val + "->");
            }
            if (root.right != null) {
                dfs(list, root.right, temp + root.val + "->");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}