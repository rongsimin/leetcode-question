package com.rongsimin.leetcode.editor.cn;
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
// 👍 811, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class Q328_奇偶链表 {
    public static void main(String[] args) {
        Solution solution = new Q328_奇偶链表().new Solution();
        System.out.println(solution.oddEvenList(new ListNode(new int[]{1, 2, 3, 4, 5})));
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
            // 奇数虚拟头结点
            ListNode dummyNodeOdd = new ListNode(Integer.MAX_VALUE);
            ListNode oddNode = dummyNodeOdd;
            // 偶数虚拟头结点
            ListNode dummyNodeEven = new ListNode(Integer.MIN_VALUE);
            ListNode evenNode = dummyNodeEven;
            int count = 1;
            ListNode cur = head;
            while (cur != null) {
                if (count % 2 == 1) {
                    oddNode.next = cur;
                    oddNode = cur;
                } else {
                    evenNode.next = cur;
                    evenNode = cur;
                }
                cur = cur.next;
                count++;
            }
            oddNode.next = dummyNodeEven.next;
            evenNode.next = null;
            return dummyNodeOdd.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}