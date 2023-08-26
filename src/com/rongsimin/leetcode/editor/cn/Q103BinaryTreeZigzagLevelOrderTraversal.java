//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 广度优先搜索 | 二叉树 
//
// 👍 799, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 103.二叉树的锯齿形层序遍历
 *
 * @author rsm
 * @date 2023-08-24 20:23:48
 */
public class Q103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q103BinaryTreeZigzagLevelOrderTraversal().new Solution();
        Integer[] integers = {1, 2, 3, 4, null, null, 5};
        TreeNode root = new TreeNode(integers);
        System.out.println(solution.zigzagLevelOrder(root));
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> resList = new ArrayList<>();
            if (root == null) {
                return resList;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            int level = 0;
            while (!deque.isEmpty()) {
                int sz = deque.size();
                List<Integer> list = new ArrayList<>();
                while (sz > 0) {
                    TreeNode node = null;
                    if (level % 2 == 0) {
                        node = deque.removeFirst();
                    } else {
                        node = deque.removeLast();
                    }
                    list.add(node.val);
                    if (level % 2 == 0) {
                        if (node.left != null) {
                            deque.addLast(node.left);
                        }
                        if (node.right != null) {
                            deque.addLast(node.right);
                        }
                    } else {
                        if (node.right != null) {
                            deque.addFirst(node.right);
                        }
                        if (node.left != null) {
                            deque.addFirst(node.left);
                        }
                    }

                    sz--;
                }
                resList.add(list);
                level++;
            }
            return resList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}