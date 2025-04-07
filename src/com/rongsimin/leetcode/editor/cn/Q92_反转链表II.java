package com.rongsimin.leetcode.editor.cn;
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
// 👍 1887, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class Q92_反转链表II {
    public static void main(String[] args) {
        Solution solution = new Q92_反转链表II().new Solution();
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(solution.reverseBetween(listNode, 1, 3));
        listNode = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(solution.reverseBetween(listNode, 2, 4));
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
            ListNode preLeft = dummyNode;
            // 走 left - 1 步到达left的前一个节点
            for (int i = 0; i < left - 1; i++) {
                preLeft = preLeft.next;
            }
            // preLeft 后面没动过
            ListNode pre = null;
            ListNode cur = preLeft.next;
            for (int i = left; i <= right; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            // 此时 pre 到达 right 节点， cur 到达 right.next 节点
            preLeft.next.next = cur;
            preLeft.next = pre;
            return dummyNode.next;
        }

        public ListNode reverseBetween2(ListNode head, int left, int right) {
            ListNode leftNode = head;
            ListNode dummyNode = new ListNode(1000, leftNode);
            ListNode preNode = dummyNode;
            for (int i = 1; i < left; i++) {
                preNode = leftNode;
                leftNode = leftNode.next;
            }
            // leftNode 此时在 left 的位置
            // preNode 此时在 left的前一个位置
            ListNode cur = leftNode;
            ListNode pre = null;
            // 对 [left, right]之间的元素进行翻转，也就是对 [0, right - left] 进行翻转
            for (int i = 0; i < right - left + 1; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            // 此时对 [left, right] 之间的元素完成翻转
            // cur 指向的是 right 的 后一个节点的位置
            // pre 指向的是 right 节点的位置
            preNode.next = pre;
            leftNode.next = cur;
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}