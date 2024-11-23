//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
// 
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
// 
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 1115, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144.二叉树的前序遍历
 *
 * @author rsm
 * @date 2023-08-23 14:35:51
 */
public class Q144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q144BinaryTreePreorderTraversal().new Solution();
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

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Stack<CommandNew> stack = new Stack<>();
            stack.push(new CommandNew(false, root));
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                CommandNew pop = stack.pop();
                if (pop.isPrint) {
                    list.add(pop.node.val);
                } else {
                    if (pop.node.right != null) stack.push(new CommandNew(false, pop.node.right));
                    if (pop.node.left != null) stack.push(new CommandNew(false, pop.node.left));
                    stack.push(new CommandNew(true, pop.node));
                }
            }

            return list;
        }

        private class CommandNew {
            boolean isPrint;
            TreeNode node;

            public CommandNew(boolean isPrint, TreeNode node) {
                this.isPrint = isPrint;
                this.node = node;
            }
        }
        public List<Integer> preorderTraversal2(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> resList = new ArrayList<>();
            Stack<Command> stack = new Stack<>();
            stack.push(new Command(false, root));
            while (!stack.isEmpty()) {
                Command top = stack.pop();
                if (top.isPrint) {
                    resList.add(top.node.val);
                } else {
                    if (top.node.right != null) {
                        stack.push(new Command(false, top.node.right));
                    }
                    if (top.node.left != null) {
                        stack.push(new Command(false, top.node.left));
                    }
                    stack.push(new Command(true, top.node));
                }
            }
            return resList;
        }

        private class Command {
            /**
             * true:print,false:go
             */
            public boolean isPrint;
            public TreeNode node;

            public Command(boolean isPrint, TreeNode node) {
                this.isPrint = isPrint;
                this.node = node;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}