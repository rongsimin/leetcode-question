package com.rongsimin.leetcode.editor.cn;
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1103, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 2024-12-07 22:25:47
 **/
public class Q61_旋转链表 {
    public static void main(String[] args) {
        Solution solution = new Q61_旋转链表().new Solution();
        System.out.println(solution.rotateRight(new ListNode(new int[]{1, 2, 3, 4, 5}), 2));
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            // 挪动次数为 k % n
            int sz = 0;
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
                sz++;
            }
            k = k % sz;
            if (k == 0) {
                return head;
            }
            ListNode dummyNode = new ListNode(-1, head);
            ListNode slow = dummyNode;
            ListNode fast = dummyNode;
            for (int i = 0; i < k + 1; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            // 此时 slow.next的节点就是要挪到前面去的
            ListNode newHead = slow.next;
            slow.next = null;
            cur = newHead;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = dummyNode.next;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}