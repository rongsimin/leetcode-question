package com.rongsimin.leetcode.editor.cn;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics链表 | 双指针 
//
// 👍 2987, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 2024-12-07 22:10:14
 **/
public class Q19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        Solution solution = new Q19_删除链表的倒数第N个结点().new Solution();
        System.out.println(solution.removeNthFromEnd(new ListNode(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(solution.removeNthFromEnd(new ListNode(new int[]{1}), 1));
        System.out.println(solution.removeNthFromEnd(new ListNode(new int[]{1, 2}), 1));
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 倒数第 2 个，也就是 快慢指针要相隔 3个
            // 倒数第 n 个，也就是 快慢指针要相隔 n + 1个
            ListNode dummyNode = new ListNode(-1, head);
            ListNode slow = dummyNode;
            ListNode fast = dummyNode;
            for (int i = 0; i < n + 1; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            // 此时 slow.next就是要删除的节点
            ListNode deleteNode = slow.next;
            slow.next = deleteNode.next;
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}