package com.rongsimin.leetcode.editor.cn.honor;

/**
 * 标题：将单向链表按某值划分为左边小，中间相等，右边大的形式
 * @author rsm
 * @date 2023/11/25 16:24
 */
public class ListSort {
    public static void main(String[] args) {
        Node node = new Node(3, new Node(3, new Node(2, new Node(1, new Node(4, new Node(7, new Node(5)))))));
        System.out.println(node);
        //System.out.println(sort(node, 3));
        //System.out.println(sort(node, 6));
        System.out.println(sort(node, 8));
    }

    private static Node sort(Node root, int pivot) {
        Node ltPreNode = new Node(-1);
        Node ltPreNodeCopy = ltPreNode;
        Node equalPreNode = new Node(-1);
        Node equalPreNodeCopy = equalPreNode;
        Node gtPreNode = new Node(-1);
        Node gtPreNodeCopy = gtPreNode;
        Node cur = root;
        while (cur != null) {
            if (cur.val < pivot) {
                ltPreNodeCopy.next = cur;
                ltPreNodeCopy = ltPreNodeCopy.next;
            } else if (cur.val == pivot) {
                equalPreNodeCopy.next = cur;
                equalPreNodeCopy = equalPreNodeCopy.next;
            } else {
                gtPreNodeCopy.next = cur;
                gtPreNodeCopy = gtPreNodeCopy.next;
            }
            cur = cur.next;
        }
        //ltPreNodeCopy.next = null;
        //equalPreNodeCopy.next = null;
        gtPreNodeCopy.next = null;
        equalPreNodeCopy.next = gtPreNode.next;
        ltPreNodeCopy.next = equalPreNode.next;
        return ltPreNode.next;
    }

    private static class Node {
        int val;

        Node next;

        public Node (int val) {
            this(val, null);
        }

        public Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            Node cur = this;
            StringBuilder sb = new StringBuilder();
            while (cur != null) {
                sb.append(cur.val + " -> ");
                cur = cur.next;
            }
            sb.append("NULL");
            return sb.toString();
        }
    }
}
