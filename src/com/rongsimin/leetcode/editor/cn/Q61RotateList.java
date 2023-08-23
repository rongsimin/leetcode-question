  //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 967, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package com.rongsimin.leetcode.editor.cn;
  
  /**
    * 61.旋转链表
    *
    * @author rsm
    * @date 2023-08-22 11:48:28
    */
  public class Q61RotateList{
      public static void main(String[] args) {
           Solution solution = new Q61RotateList().new Solution();
          System.out.println(solution.rotateRight(new ListNode(new int[]{0, 1, 2}), 3));
          System.out.println(solution.rotateRight(new ListNode(new int[]{1, 2, 3, 4, 5}), 2));
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = calSize(head);
        k = k % size;
        if (k == 0) {
            return head;
        }
        ListNode preLastKNode = head;
        for (int i = 0; i < size - k - 1; i++) {
            preLastKNode = preLastKNode.next;
        }
        ListNode rightNode = preLastKNode.next;
        ListNode cur = rightNode;
        preLastKNode.next = null;
        // 找到 rightNode 的最后一个节点
        for (int i = 0; i < k - 1; i++) {
            cur = cur.next;
        }
        cur.next = head;
        return rightNode;
    }

    private int calSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }