//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 回溯 | 二叉树 
//
// 👍 1029, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 113.路径总和 II
 *
 * @author rsm
 * @date 2023-08-29 10:15:00
 */
public class Q113PathSumIi {
    public static void main(String[] args) {
        Solution solution = new Q113PathSumIi().new Solution();
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

        private List<List<Integer>> resList = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return resList;
            }
            dnf(root, targetSum, new ArrayList<>());
            return resList;
        }

        private void dnf(TreeNode root, int targetSum, List<Integer> temp) {
            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    temp.add(root.val);
                    resList.add(new ArrayList<>(temp));
                }
                return;
            }
            targetSum -= root.val;
            temp.add(root.val);
            if (root.left != null) {
                dnf(root.left, targetSum, new ArrayList<>(temp));
            }
            if (root.right != null) {
                dnf(root.right, targetSum, new ArrayList<>(temp));
            }
        }

        public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
            List<Integer> temp = new ArrayList<>();
            dfs(root, temp, targetSum);
            return resList;
        }

        private void dfs(TreeNode root, List<Integer> temp, int targetSum) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    temp.add(root.val);
                    resList.add(new ArrayList<>(temp));
                }
                return;
            }
            temp.add(root.val);
            dfs(root.left, new ArrayList<>(temp), targetSum - root.val);
            dfs(root.right, new ArrayList<>(temp), targetSum - root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}