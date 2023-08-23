//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics递归 | 链表 
//
// 👍 3247, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 21.合并两个有序链表
 *
 * @author rsm
 * @date 2023-08-21 14:34:40
 */
public class Q21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Q21MergeTwoSortedLists().new Solution();
        System.out.println(solution.mergeTwoLists(new ListNode(new int[]{1, 2, 4}), new ListNode(new int[]{1, 3, 4})));
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode dummyNode = new ListNode(-1);
            ListNode preNode = dummyNode;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    preNode.next = list1;
                    preNode = preNode.next;
                    list1 = list1.next;
                } else {
                    preNode.next = list2;
                    preNode = preNode.next;
                    list2 = list2.next;
                }
            }
            if (list1 != null) {
                preNode.next = list1;
            }
            if (list2 != null) {
                preNode.next = list2;
            }
            return dummyNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}