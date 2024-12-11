package com.rongsimin.leetcode.editor.cn;
//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：root = [1,null,2,3] 
// 
//
// 输出：[3,2,1] 
//
// 解释： 
//
// 
//
// 示例 2： 
//
// 
// 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9] 
// 
//
// 输出：[4,6,7,5,2,9,8,3,1] 
//
// 解释： 
//
// 
//
// 示例 3： 
//
// 
// 输入：root = [] 
// 
//
// 输出：[] 
//
// 示例 4： 
//
// 
// 输入：root = [1] 
// 
//
// 输出：[1] 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 1213, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024-12-09 22:12:14
 **/
public class Q145_二叉树的后序遍历 {
    public static void main(String[] args) {
        Solution solution = new Q145_二叉树的后序遍历().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
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
                    deque.addLast(new Command(true, command.node));
                    if (command.node.right != null) {
                        deque.addLast(new Command(false, command.node.right));
                    }
                    if (command.node.left != null) {
                        deque.addLast(new Command(false, command.node.left));
                    }
                }
            }
            return resList;
        }
    }

    class Command {
        public boolean isPrint;
        public TreeNode node;

        public Command(boolean isPrint, TreeNode node) {
            this.isPrint = isPrint;
            this.node = node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}