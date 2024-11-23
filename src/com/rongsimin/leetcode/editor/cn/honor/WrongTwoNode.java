package com.rongsimin.leetcode.editor.cn.honor;

import com.rongsimin.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到搜索二叉树中两个错误的节点
 *
 * @author rsm
 * @date 2023/11/25 11:12
 */
public class WrongTwoNode {
    private List<Integer> list = new ArrayList<>();

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

    public int[] findError (TreeNode root) {
        inorder(root);
        int firstWrongIndex = -1;
        int lastWrongIndex = -1;
        for (int i = 0; i < list.size() - 1; i++) {
           if (list.get(i) > list.get(i + 1)) {
               if (firstWrongIndex == -1) {
                   firstWrongIndex = i;
               }
               lastWrongIndex = i + 1;
           }
        }
        return new int[]{list.get(lastWrongIndex), list.get(firstWrongIndex)};
    }
}
