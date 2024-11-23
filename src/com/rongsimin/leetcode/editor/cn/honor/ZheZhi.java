package com.rongsimin.leetcode.editor.cn.honor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rsm
 * @date 2023/11/24 19:53
 */
public class ZheZhi {
    private static Map<TreeNode, Integer> treeNodeMap = new HashMap<>();

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(1);
        inorder(treeNode);
        System.out.println("--------------------------");
        treeNode = buildTree(2);
        inorder(treeNode);
        System.out.println("--------------------------");
        treeNode = buildTree(3);
        inorder(treeNode);
        System.out.println("--------------------------");
        treeNode = buildTree(4);
        inorder(treeNode);
        System.out.println("--------------------------");
    }

    private static TreeNode buildTree(int count) {
        TreeNode root = new TreeNode("down");
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        for (int i = 2; i <= count; i++) {
            int size = deque.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = deque.removeFirst();
                node.left = new TreeNode("down");
                node.right = new TreeNode("up");
                deque.addLast(node.left);
                deque.addLast(node.right);
            }
        }
        return root;
    }

    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    private static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(String val) {
            this.val = val;
        }

        public TreeNode(String val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
