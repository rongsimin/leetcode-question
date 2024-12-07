package com.rongsimin.leetcode.editor.cn;
//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 1335, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class Q82_删除排序链表中的重复元素II {
    public static void main(String[] args) {
        Solution solution = new Q82_删除排序链表中的重复元素II().new Solution();
        System.out.println(solution.deleteDuplicates(new ListNode(new int[]{1, 2, 3, 3, 4, 4, 5})));
        System.out.println(solution.deleteDuplicates(new ListNode(new int[]{1, 1, 1, 2, 3})));
        System.out.println(solution.deleteDuplicates(new ListNode(new int[]{1, 1, 1})));
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummyNode = new ListNode(-1, head);
            ListNode preNode = dummyNode;
            ListNode cur = head;
            ListNode next = head.next;
            // 是否重复
            boolean isRepeat = false;
            while (next != null) {
                while (next != null && next.val == cur.val) {
                    isRepeat = true;
                    next = next.next;
                }
                if (next == null) {
                    break;
                }
                if (isRepeat) {
                    cur = next;
                    next = next.next;
                    isRepeat = false;
                } else {
                    preNode.next = cur;
                    preNode = preNode.next;
                    cur = next;
                    next = next.next;
                }
            }
            if (isRepeat) {
                preNode.next = null;
            } else {
                preNode.next = cur;
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}