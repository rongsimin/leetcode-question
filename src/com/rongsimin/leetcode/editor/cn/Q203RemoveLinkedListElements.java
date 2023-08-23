  //给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics递归 | 链表 
//
// 👍 1309, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package com.rongsimin.leetcode.editor.cn;
  
  /**
    * 203.移除链表元素
    *
    * @author rsm
    * @date 2023-08-21 11:37:42
    */
  public class Q203RemoveLinkedListElements{
      public static void main(String[] args) {
           Solution solution = new Q203RemoveLinkedListElements().new Solution();
          System.out.println(solution.removeElements(new ListNode(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val) {
                preNode.next = cur;
                preNode = preNode.next;
            }
            cur = cur.next;
        }
        preNode.next = null;
        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }