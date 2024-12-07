package com.rongsimin.leetcode.editor.cn;
//给定单个链表的头
// head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。 
//
// 插入排序 算法的步骤: 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表
//中。 
//
// 对链表进行插入排序。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [4,2,1,3]
//输出: [1,2,3,4] 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [-1,5,3,4,0]
//输出: [-1,0,3,4,5] 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 列表中的节点数在 [1, 5000]范围内 
// -5000 <= Node.val <= 5000 
// 
//
// Related Topics链表 | 排序 
//
// 👍 681, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class Q147_对链表进行插入排序 {
    public static void main(String[] args) {
        Solution solution = new Q147_对链表进行插入排序().new Solution();
        System.out.println(solution.insertionSortList(new ListNode(new int[]{4, 2, 1, 3})));
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
        public ListNode insertionSortList(ListNode head) {
            ListNode dummyNode = new ListNode(Integer.MIN_VALUE, head);
            // 最后一个排好序的节点
            ListNode lastSortedNode = head;
            // 下一个要排序的节点
            ListNode cur = head.next;
            while (cur != null) {
                if (cur.val >= lastSortedNode.val) {
                    lastSortedNode.next = cur;
                    lastSortedNode = lastSortedNode.next;
                } else {
                    // 需要往前面进行插入，插入到哪里呢
                    ListNode preNode = dummyNode;
                    while (preNode.next != null && preNode.next.val <= cur.val) {
                        preNode = preNode.next;
                    }
                    // 此时 preNode <= cur
                    // preNode.next > cur
                    // 要把 cur 放在 preNode的后面
                    lastSortedNode.next = cur.next;
                    cur.next = preNode.next;
                    preNode.next = cur;
                }
                cur = lastSortedNode.next;
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}