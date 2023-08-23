  //给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
//
// Related Topics栈 | 链表 | 数学 
//
// 👍 683, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package com.rongsimin.leetcode.editor.cn;

  import java.util.Stack;

  /**
    * 445.两数相加 II
    *
    * @author rsm
    * @date 2023-08-21 11:11:17
    */
  public class Q445AddTwoNumbersIi{
      public static void main(String[] args) {
           Solution solution = new Q445AddTwoNumbersIi().new Solution();
          System.out.println(solution.addTwoNumbers(new ListNode(new int[]{7, 2, 4, 3}), new ListNode(new int[]{5, 6, 4})));
          System.out.println(solution.addTwoNumbers(new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{5, 6, 4})));
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int plus = 0;
        ListNode lastNode = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            sum += plus;
            plus = sum / 10;
            lastNode = new ListNode(sum % 10, lastNode);
        }
        if (plus == 1) {
            lastNode = new ListNode(1, lastNode);
        }
        return lastNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }