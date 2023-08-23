  //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics链表 | 双指针 
//
// 👍 2643, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package com.rongsimin.leetcode.editor.cn;

  /**
    * 19.删除链表的倒数第 N 个结点
    *
    * @author rsm
    * @date 2023-08-22 11:29:00
    */
  public class Q19RemoveNthNodeFromEndOfList{
      public static void main(String[] args) {
           Solution solution = new Q19RemoveNthNodeFromEndOfList().new Solution();
          //System.out.println(solution.removeNthFromEnd(new ListNode(new int[]{1, 2, 3, 4, 5}), 2));
          System.out.println(solution.removeNthFromEnd(new ListNode(new int[]{1}), 1));
          System.out.println(solution.removeNthFromEnd(new ListNode(new int[]{1, 2}), 1));
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode fast = dummyNode;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        ListNode slow = dummyNode;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }