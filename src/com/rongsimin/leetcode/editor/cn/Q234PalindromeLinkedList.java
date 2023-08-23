//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1759, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 234.回文链表
 *
 * @author rsm
 * @date 2023-08-22 14:36:51
 */
public class Q234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q234PalindromeLinkedList().new Solution();
        System.out.println(solution.isPalindrome(new ListNode(new int[]{1, 2, 2, 1})));
        System.out.println(solution.isPalindrome(new ListNode(new int[]{1, 2, 3, 2, 1})));
        System.out.println(solution.isPalindrome(new ListNode(new int[]{1, 2})));
        System.out.println(Math.pow(1200, 3));
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
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode dummyNode = new ListNode(-1, head);
            ListNode slow = dummyNode;
            ListNode fast = dummyNode;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode right = slow.next;
            ListNode rightHead = reverse(right);
            slow.next = null;
            ListNode leftHead = dummyNode.next;
            while (leftHead != null && rightHead != null) {
                if (leftHead.val != rightHead.val) {
                    return false;
                }
                leftHead = leftHead.next;
                rightHead = rightHead.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {
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