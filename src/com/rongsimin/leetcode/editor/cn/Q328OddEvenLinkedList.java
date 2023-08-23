//给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
//
// 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。 
//
// 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。 
//
// 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,3,5,2,4] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [2,1,3,5,6,4,7]
//输出: [2,3,6,7,1,5,4] 
//
// 
//
// 提示: 
//
// 
// n == 链表中的节点数 
// 0 <= n <= 10⁴ 
// -10⁶ <= Node.val <= 10⁶ 
// 
//
// Related Topics链表 
//
// 👍 728, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 328.奇偶链表
 *
 * @author rsm
 * @date 2023-08-21 10:29:26
 */
public class Q328OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q328OddEvenLinkedList().new Solution();
        System.out.println(solution.oddEvenList(new ListNode(new int[]{2, 1, 3, 5, 6, 4, 7})));
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
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode oddDummyNode = new ListNode(-1);
            ListNode evenDummyNode = new ListNode(-1);
            ListNode oddNode = oddDummyNode;
            ListNode evenNode = evenDummyNode;
            int i = 1;
            while (head != null) {
                if (i % 2 == 1) {
                    oddNode.next = head;
                    oddNode = oddNode.next;
                } else {
                    evenNode.next = head;
                    evenNode = evenNode.next;
                }
                head = head.next;
                i++;
            }
            evenNode.next = null;
            oddNode.next = evenDummyNode.next;
            return oddDummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}