package com.rongsimin.leetcode.editor.cn.honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 判断t1树中是否有与t2树拓扑结构完全相同的子树
 *
 * @author rsm
 * @date 2023/11/27 9:56
 */
public class IsSonTree {
    private static Map<Integer, TreeNode> treeMapOne;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 第一棵树
        String input = bf.readLine();
        String[] treeOneStr = input.split(" ");
        int len = Integer.parseInt(treeOneStr[0]);
        int rootVal = Integer.parseInt(treeOneStr[1]);
        int[][] treeOneNodes = new int[len][3];
        for (int i = 0; i < len; i++) {
            input = bf.readLine();
            treeOneNodes[i] = convertToIntArray(input.split(" "));
        }
        treeMapOne = new HashMap<>();
        treeMapOne.put(rootVal, new TreeNode(rootVal));
        buildTree(treeOneNodes);
        TreeNode treeOne = treeMapOne.get(rootVal);

        // 第二棵树
        input = bf.readLine();
        String[] treeTwoStr = input.split(" ");
        len = Integer.parseInt(treeTwoStr[0]);
        rootVal = Integer.parseInt(treeTwoStr[1]);
        int[][] treeTwoNodes = new int[len][3];
        for (int i = 0; i < len; i++) {
            input = bf.readLine();
            treeTwoNodes[i] = convertToIntArray(input.split(" "));
        }
        treeMapOne = new HashMap<>();
        treeMapOne.put(rootVal, new TreeNode(rootVal));
        buildTree(treeTwoNodes);
        TreeNode treeTwo = treeMapOne.get(rootVal);
        boolean flag = isSonTree(treeOne, treeTwo);
        System.out.println(flag);
    }

    private static boolean isSonTree(TreeNode treeOne, TreeNode treeTwo) {
        String str1 = preOrder(treeOne);
        //System.out.println("str1 = " + str1);
        String str2 = preOrder(treeTwo);
        //System.out.println("str2 = " + str2);

        String str3 = inOrder(treeOne);
        //System.out.println("str3 = " + str3);
        String str4 = inOrder(treeTwo);
        //System.out.println("str4 = " + str4);

        return str1.contains(str2) && str3.contains(str4);
    }

    private static String inOrder(TreeNode node) {
        if (node == null) {
            return "NULL";
        }
        return "" + inOrder(node.left) + ", " + node.val + ", " + inOrder(node.right);
    }

    private static String preOrder(TreeNode node) {
        if (node == null) {
            return "NULL";
        }
        return "" + node.val + ", " + preOrder(node.left) + ", " + preOrder(node.right);
    }

    private static void buildTree(int[][] treeOneNodes) {
        for (int i = 0; i < treeOneNodes.length; i++) {
            //treeOneNodes[i][0]  是根节点
            //treeOneNodes[i][1]  是左儿子
            //treeOneNodes[i][2]  是右儿子
            TreeNode node = treeMapOne.get(treeOneNodes[i][0]);
            if (treeOneNodes[i][1] != 0) {
                node.left = new TreeNode(treeOneNodes[i][1]);
                treeMapOne.put(treeOneNodes[i][1], node.left);
            }
            if (treeOneNodes[i][2] != 0) {
                node.right = new TreeNode(treeOneNodes[i][2]);
                treeMapOne.put(treeOneNodes[i][2], node.right);
            }
        }
    }

    private static TreeNode findRootNode(TreeNode rootNode, int targetVal) {
        if (rootNode == null) {
            return null;
        }
        if (rootNode.val == targetVal) {
            return rootNode;
        }
        TreeNode targetRoot = findRootNode(rootNode.left, targetVal);
        if (targetRoot == null) {
            targetRoot = findRootNode(rootNode.right, targetVal);
        }
        return targetRoot;
    }

    private static int[] convertToIntArray(String[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }
        int[] res = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            res[i] = Integer.parseInt(input[i]);
        }
        return res;
    }

    public static class TreeNode {
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
    }
}
