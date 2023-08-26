//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 926, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
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
 * 199.二叉树的右视图
 *
 * @author rsm
 * @date 2023-08-24 21:41:31
 */
public class Q199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new Q199BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
            // 每一层的最右边的节点，都能看到
            List<Integer> resList = new ArrayList<>();
            if (root == null) {
                return resList;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            while (!deque.isEmpty()) {
                int sz = deque.size();
                resList.add(deque.getLast().val);
                while (sz > 0) {
                    TreeNode node = deque.removeLast();
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                    sz--;
                }
            }
            return resList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}