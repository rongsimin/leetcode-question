package com.rongsimin.leetcode.editor.cn;

//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// Related Topics链表 
//
// 👍 1171, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
// 0406_12:18
public class Q83_删除排序链表中的重复元素 {
    public static void main(String[] args) {
        Solution solution = new Q83_删除排序链表中的重复元素().new Solution();
        System.out.println(solution.deleteDuplicates(new ListNode(new int[]{1, 1, 2, 3, 3})));
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
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null) {
                if (fast.val != slow.val) {
                    slow.next = fast;
                    slow = fast;
                }
                fast = fast.next;
            }
            slow.next = null;
            return head;
        }

        public ListNode deleteDuplicates2(ListNode head) {
            ListNode dummyNode = new ListNode(1000);
            ListNode preNode = dummyNode;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val != preNode.val) {
                    preNode.next = cur;
                    preNode = cur;
                }
                cur = cur.next;
            }
            preNode.next = null;
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}