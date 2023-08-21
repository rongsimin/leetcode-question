//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics链表 
//
// 👍 1623, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 92.反转链表 II
 *
 * @author rsm
 * @date 2023-08-19 18:25:56
 */
public class Q92ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new Q92ReverseLinkedListIi().new Solution();
        System.out.println(solution.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4));
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummyNode = new ListNode(-1, head);
            ListNode preNode = dummyNode;
            for (int i = 1; i < left; i++) {
                preNode = preNode.next;
            }
            // preNode.next == left
            ListNode pNode = null;
            ListNode cur = preNode.next;
            ListNode leftNode = cur;
            for (int i = left; i <= right; i++) {
                ListNode next = cur.next;
                cur.next = pNode;
                pNode = cur;
                cur = next;
            }
            // pNode == rightNode
            // cur = rightNode.next;
            preNode.next = pNode;
            leftNode.next = cur;
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}