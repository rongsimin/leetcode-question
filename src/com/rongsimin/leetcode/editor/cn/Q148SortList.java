  //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics链表 | 双指针 | 分治 | 排序 | 归并排序 
//
// 👍 2082, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package com.rongsimin.leetcode.editor.cn;

  /**
    * 148.排序链表
    *
    * @author rsm
    * @date 2023-08-21 16:53:24
    */
  public class Q148SortList{
      public static void main(String[] args) {
           Solution solution = new Q148SortList().new Solution();
          System.out.println(solution.sortList(new ListNode(new int[]{4, 2, 1, 3})));
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(right);
        return merge(leftHead, rightHead);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                preNode.next = left;
                preNode = preNode.next;
                left = left.next;
            } else {
                preNode.next = right;
                preNode = preNode.next;
                right = right.next;
            }
        }
        if (left != null) {
            preNode.next = left;
        }
        if (right != null) {
            preNode.next = right;
        }
        return dummyNode.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }