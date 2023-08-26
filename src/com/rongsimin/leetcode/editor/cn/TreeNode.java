package com.rongsimin.leetcode.editor.cn;

/**
 * @author rsm
 * @date 2023/8/23 14:43
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        buildTreeHelper(nums, 0);
    }

    private TreeNode buildTreeHelper(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[index]);

        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex < arr.length) {
            root.left = buildTreeHelper(arr, leftChildIndex);
        }

        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex < arr.length) {
            root.right = buildTreeHelper(arr, rightChildIndex);
        }
        this.val = root.val;
        this.left = root.left;
        this.right = root.right;
        return root;
    }



}