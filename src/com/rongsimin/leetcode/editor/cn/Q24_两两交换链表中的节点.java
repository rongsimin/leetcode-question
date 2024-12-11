package com.rongsimin.leetcode.editor.cn;
//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics递归 | 链表 
//
// 👍 2318, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class Q24_两两交换链表中的节点 {
    public static void main(String[] args) {
        Solution solution = new Q24_两两交换链表中的节点().new Solution();
        System.out.println(solution.swapPairs(new ListNode(new int[]{1, 2, 3, 4})));
        System.out.println(solution.swapPairs(new ListNode(new int[]{1, 2, 3, 4, 5})));
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummyNode = new ListNode(-1, head);
            ListNode first = head;
            ListNode second = head.next;
            ListNode pre = dummyNode;
            while (first != null && second != null) {
                ListNode next = second.next;
                first.next = next;
                second.next = first;
                pre.next = second;

                pre = first;
                first = first.next;
                if (next != null) {
                    second = next.next;
                }
            }
            if (first != null) {
                pre.next = first;
            }
            return dummyNode.next;
        }

        public ListNode swapPairs2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummyNode = new ListNode(-1, head);
            ListNode preNode = dummyNode;
            ListNode one = head;
            ListNode two = head.next;
            while (one != null && two != null) {
                ListNode three = two.next;
                one.next = three;
                two.next = one;
                preNode.next = two;
                preNode = one;
                // one 和 two 往后挪动
                one = three;
                if (three != null) {
                    two = three.next;
                }
            }
            preNode.next = one;
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}