package com.rongsimin.leetcode.editor.cn;
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
//
// Related Topics栈 | 链表 | 数学 
//
// 👍 745, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Deque;
import java.util.LinkedList;

public class Q445_两数相加II {
    public static void main(String[] args) {
        Solution solution = new Q445_两数相加II().new Solution();
        System.out.println(solution.addTwoNumbers(new ListNode(new int[]{7, 2, 4, 3}), new ListNode(new int[]{5, 6, 4})));
        System.out.println(solution.addTwoNumbers(new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{5, 6, 4})));
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> deque1 = new LinkedList<>();
            Deque<Integer> deque2 = new LinkedList<>();
            ListNode node1 = l1;
            ListNode node2 = l2;

            ListNode iteratorNode = null;
            while (node1 != null) {
                deque1.addLast(node1.val);
                node1 = node1.next;
            }
            while (node2 != null) {
                deque2.addLast(node2.val);
                node2 = node2.next;
            }
            int add = 0;
            while (!deque1.isEmpty() || !deque2.isEmpty()) {
                int sum = (!deque1.isEmpty() ? deque1.removeLast() : 0) + (!deque2.isEmpty() ? deque2.removeLast() : 0)
                        + add;
                if (sum >= 10) {
                    add = 1;
                } else {
                    add = 0;
                }
                iteratorNode = new ListNode(sum % 10, iteratorNode);
            }
            if (add == 1) {
                iteratorNode = new ListNode(1, iteratorNode);
            }
            return iteratorNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}