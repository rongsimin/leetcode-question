  //给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1354, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package com.rongsimin.leetcode.editor.cn;
  
  /**
    * 143.重排链表
    *
    * @author rsm
    * @date 2023-08-22 11:49:41
    */
  public class Q143ReorderList{
      public static void main(String[] args) {
           Solution solution = new Q143ReorderList().new Solution();
           //solution.reorderList(new ListNode(new int[]{1,2,3,4}));
           solution.reorderList(new ListNode(new int[]{1,2,3,4,5}));
           solution.reorderList(new ListNode(new int[]{1}));
      }
      
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        ListNode dummyNode = new ListNode(-1, head);
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode leftHead = dummyNode.next;
        ListNode rightHead = reverse(right);
        ListNode preNode = dummyNode;
        int i = 0;
        while (leftHead!= null && rightHead != null) {
            if (i % 2 == 0) {
                preNode.next = leftHead;
                preNode = preNode.next;
                leftHead = leftHead.next;
            } else {
                preNode.next = rightHead;
                preNode = preNode.next;
                rightHead = rightHead.next;
            }
            i++;
        }
        if (leftHead != null) {
            preNode.next = leftHead;
        }
        if (rightHead != null) {
            preNode.next = rightHead;
        }
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private void merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }