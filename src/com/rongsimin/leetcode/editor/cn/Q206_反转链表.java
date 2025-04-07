package com.rongsimin.leetcode.editor.cn;

/**
 * 2025-04-06 11:33:58
 **/
public class Q206_反转链表 {
    public static void main(String[] args) {
        Solution solution = new Q206_反转链表().new Solution();
        //ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(listNode);
        System.out.println(solution.reverseList(listNode));
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
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            ListNode head1 = head;
            ListNode next = head1.next;
            head1.next = null;
            next.next = head1;
            return newHead;
        }

        public ListNode reverseList2(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}