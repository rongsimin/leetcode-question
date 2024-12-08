package com.rongsimin.leetcode.editor.cn;
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
// 👍 1983, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 2024-12-07 23:16:05
 **/
public class Q234_回文链表 {
    public static void main(String[] args) {
        Solution solution = new Q234_回文链表().new Solution();
        ListNode head = new ListNode(new int[]{1, 2, 2, 1});
        System.out.println(solution.isPalindrome(head));
        head = new ListNode(new int[]{1, 2, 3, 2, 1});
        System.out.println(solution.isPalindrome(head));
        head = new ListNode(new int[]{1, 2});
        System.out.println(solution.isPalindrome(head));
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

        public boolean isPalindrome2(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode cur = head;
            int count = 0;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            if (count % 2 == 0) {
                // 说明是偶数个节点
                ListNode dummyNode = new ListNode(-1, head);
                ListNode pre = dummyNode;
                int i = count / 2;
                while (i > 0) {
                    pre = pre.next;
                    i--;
                }
                // 此时pre.next就是后一半
                ListNode second = pre.next;
                pre.next = null;
                ListNode head2 = reverse(second);
                return isEquals(dummyNode.next, head2);
            } else {
                // 说明是奇数个节点
                ListNode pre = head;
                int i = count / 2;
                while (i > 0) {
                    pre = pre.next;
                    i--;
                }
                // 此时pre.next就是后一半
                ListNode second = pre.next;
                pre.next = null;
                ListNode head2 = reverse(second);
                return isEquals(head, head2);
            }
        }

        private ListNode reverse(ListNode head) {
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

        private boolean isEquals(ListNode head, ListNode head2) {
            while (head != null && head2 != null) {
                if (head.val != head2.val) {
                    return false;
                }
                head = head.next;
                head2 = head2.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}