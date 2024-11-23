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

    public TreeNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        buildTreeHelperNew(nums, 0);
    }

    private TreeNode buildTreeHelperNew(int[] nums, int rootIndex) {
        if (rootIndex >= nums.length) {
            return null;
        }
        TreeNode root = new TreeNode(nums[rootIndex]);
        int leftIndex = rootIndex * 2 + 1;
        int rightIndex = rootIndex * 2 + 2;
        TreeNode leftNode = buildTreeHelperNew(nums, leftIndex);
        TreeNode rightNode = buildTreeHelperNew(nums, rightIndex);
        root.left = leftNode;
        root.right = rightNode;
        this.val = root.val;
        this.left = root.left;
        this.right = root.right;
        return root;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        TreeNode node = new TreeNode(ints);
        preorder(node);
    }

    private static void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
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