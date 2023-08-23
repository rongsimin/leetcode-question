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
// 👍 626, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package com.rongsimin.leetcode.editor.cn;
  
  /**
    * 147.对链表进行插入排序
    *
    * @author rsm
    * @date 2023-08-21 15:32:16
    */
  public class Q147InsertionSortList{
      public static void main(String[] args) {
           Solution solution = new Q147InsertionSortList().new Solution();
          System.out.println(solution.insertionSortList(new ListNode(new int[]{4, 2, 1, 3})));
          System.out.println(solution.insertionSortList(new ListNode(new int[]{-1,5,3,4,0})));
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-10000, head);
        ListNode lastSortedNode = head;
        ListNode cur = head.next; // cur为待排序的位置
        while (cur != null) {
            if (lastSortedNode.val > cur.val) {
                ListNode tempNode = dummyNode;
                while (tempNode.next != null && tempNode.next.val < cur.val) {
                    // 找到第一个大于cur节点的前驱节点
                    tempNode = tempNode.next;
                }
                // tempNode < cur
                // tempNode.next >= cur
                // 把cur节点插入到tempNode后面
                lastSortedNode.next = cur.next;
                cur.next = tempNode.next;
                tempNode.next = cur;
            } else {
                lastSortedNode.next = cur;
                lastSortedNode = lastSortedNode.next;
            }
            cur = lastSortedNode.next;
        }
        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }