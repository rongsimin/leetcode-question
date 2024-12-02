package com.rongsimin.leetcode.editor.cn;
//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 873, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class Q86_分隔链表 {
    public static void main(String[] args) {
        Solution solution = new Q86_分隔链表().new Solution();
        System.out.println(solution.partition(new ListNode(new int[]{1, 4, 3, 2, 5, 2}), 3));
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
        public ListNode partition(ListNode head, int x) {
            ListNode dummyNodeLtX = new ListNode(-1000);
            ListNode dummyNodeGtX = new ListNode(1000);
            ListNode ltNodePre = dummyNodeLtX;
            ListNode gtNodePre = dummyNodeGtX;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val < x) {
                    ltNodePre.next = cur;
                    ltNodePre = cur;
                } else {
                    gtNodePre.next = cur;
                    gtNodePre = cur;
                }
                cur = cur.next;
            }
            // 此时 dummyNodeLtX 里面全是小于x的，它的最后一个节点是 ltNodePre
            // 此时 dummyNodeGtX 里面全是大于等于x的，它的最后一个节点是 gtNodePre
            gtNodePre.next = null;
            ltNodePre.next = dummyNodeGtX.next;
            return dummyNodeLtX.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}