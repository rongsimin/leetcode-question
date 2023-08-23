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
// 👍 1170, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 82.删除排序链表中的重复元素 II
 *
 * @author rsm
 * @date 2023-08-21 11:49:12
 */
public class Q82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new Q82RemoveDuplicatesFromSortedListIi().new Solution();
        System.out.println(solution.deleteDuplicates(new ListNode(new int[]{1, 1, 1, 2, 3})));
        System.out.println(solution.deleteDuplicates(new ListNode(new int[]{1,2,3,3,4,4,5})));
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
            while (cur != null && next != null) {
                if (cur.val == next.val) {
                    int repeatVal = cur.val;
                    while (cur != null && cur.val == repeatVal) {
                        cur = cur.next;
                    }
                    if (cur != null) {
                        next = cur.next;
                    }
                } else {
                    // 如果不相等，那么可以保存下来
                    preNode.next = cur;
                    preNode = preNode.next;
                    cur = next;
                    next = next.next;
                }
            }
            if (cur != null) {
                preNode.next = cur;
                preNode = preNode.next;
            }
            preNode.next = null;
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}