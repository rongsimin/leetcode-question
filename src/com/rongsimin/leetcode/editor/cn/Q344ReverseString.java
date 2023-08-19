  //编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 都是 ASCII 码表中的可打印字符 
// 
//
// Related Topics 双指针 字符串 👍 825 👎 0

  
  package com.rongsimin.leetcode.editor.cn;
  
  /**
    * 344.反转字符串
    *
    * @author rsm
    * @date 2023-08-15 16:39:25
    */
  public class Q344ReverseString{
      public static void main(String[] args) {
           Solution solution = new Q344ReverseString().new Solution();
      }
      /**
    * 344.反转字符串
    *
    * @author rsm
    * @date 2023-08-15 16:39:25
    */
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        int right = s.length - 1;
        int left = 0;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }