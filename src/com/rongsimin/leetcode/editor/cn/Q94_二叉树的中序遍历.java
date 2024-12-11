package com.rongsimin.leetcode.editor.cn;
//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 2164, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024-12-09 22:01:31
 **/
public class Q94_二叉树的中序遍历 {
    public static void main(String[] args) {
        Solution solution = new Q94_二叉树的中序遍历().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> resList = new ArrayList<>();
            Deque<Command> deque = new LinkedList<>();
            deque.addLast(new Command(false, root));
            while (!deque.isEmpty()) {
                Command command = deque.removeLast();
                if (command.isPrint) {
                    resList.add(command.node.val);
                } else {
                    if (command.node.right != null) {
                        deque.addLast(new Command(false, command.node.right));
                    }
                    deque.addLast(new Command(true, command.node));
                    if (command.node.left != null) {
                        deque.addLast(new Command(false, command.node.left));
                    }
                }
            }
            return resList;
        }

        class Command {
            public boolean isPrint;
            public TreeNode node;

            public Command(boolean isPrint, TreeNode node) {
                this.isPrint = isPrint;
                this.node = node;
            }
        }

        public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> resList = new ArrayList<>();
            inorderTraversal(root, resList);
            return resList;
        }

        private void inorderTraversal(TreeNode root, List<Integer> resList) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left, resList);
            resList.add(root.val);
            inorderTraversal(root.right, resList);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}