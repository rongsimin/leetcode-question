package com.rongsimin.leetcode.editor.cn;
//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 2844, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024-12-12 21:38:20
 **/
public class Q101_对称二叉树 {
    public static void main(String[] args) {
        Solution solution = new Q101_对称二叉树().new Solution();

        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode three2 = new TreeNode(3);
        TreeNode four2 = new TreeNode(4);
        TreeNode two = new TreeNode(2, three, four);
        TreeNode two2 = new TreeNode(2, three2, four2);
        TreeNode root = new TreeNode(1, two, two2);
        System.out.println(solution.isSymmetric(root));
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

        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root, root);
        }

        private boolean isSymmetric(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }

            return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        }

        public boolean isSymmetric1(TreeNode root) {
            if (root == null) {
                return true;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> tempList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.removeFirst();
                    tempList.add(node.val);
                    if (node.left != null && Integer.MAX_VALUE != node.val) {
                        deque.addLast(node.left);
                    } else {
                        deque.addLast(new TreeNode(Integer.MAX_VALUE));
                    }
                    if (node.right != null && Integer.MAX_VALUE != node.val) {
                        deque.addLast(node.right);
                    } else {
                        deque.addLast(new TreeNode(Integer.MAX_VALUE));
                    }
                }
                int left = 0;
                int right = tempList.size() - 1;
                while (right >= left) {
                    if (!tempList.get(left).equals(tempList.get(right))) {
                        return false;
                    }
                    right--;
                    left++;
                }
            }
            return true;
        }

        public boolean isSymmetric2(TreeNode root) {
            if (root == null) {
                return true;
            }
            Deque<Command> deque = new LinkedList<>();
            deque.addLast(new Command(false, root));
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Command command = deque.removeLast();
                    if (command.isPrint) {
                        sb.append(command.node.val);
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
            }
            System.out.println(sb);
            int length = sb.toString().length();
            int left = 0;
            int right = length - 1;
            while (right > left) {
                if (sb.charAt(left) != sb.charAt(right)) {
                    return false;
                }
                right--;
                left++;
            }
            return true;
        }

        private class Command {
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