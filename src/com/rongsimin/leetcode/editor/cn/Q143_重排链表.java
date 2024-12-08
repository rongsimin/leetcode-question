package com.rongsimin.leetcode.editor.cn;
//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1544, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 2024-12-07 22:40:22
 **/
public class Q143_重排链表 {
    public static void main(String[] args) {
        Solution solution = new Q143_重排链表().new Solution();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        solution.reorderList(head);
        System.out.println(head);

        head = new ListNode(new int[]{1, 2, 3, 4});
        solution.reorderList(head);
        System.out.println(head);
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
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 此时 slow.next 就是中间节点的位置
            // fast重要吗，不重要，从slow切开就行了
            ListNode second = slow.next;
            slow.next = null;
            // 此时已经分成两半，dummyNode也改变了，debug看看
            ListNode head2 = reverseList(second);
            mergeList(head, head2);
        }

        private void mergeList(ListNode head, ListNode head2) {
            int i = 0;
            ListNode cur = head;
            ListNode cur2 = head2;
            ListNode dummyNode = new ListNode(-1);
            ListNode pre = dummyNode;
            while (cur != null && cur2 != null) {
                if (i % 2 == 0) {
                    pre.next = cur;
                    pre = pre.next;
                    cur = cur.next;
                } else {
                    pre.next = cur2;
                    pre = pre.next;
                    cur2 = cur2.next;
                }
                i++;
            }
            if (cur != null) {
                pre.next = cur;
            }
            if (cur2 != null) {
                pre.next = cur2;
            }
            head = dummyNode.next;
        }

        private ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = head;
            ListNode pre = null;
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