  //给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 319 👎 0

  
  package com.rongsimin.leetcode.editor.cn;
  
  /**
    * 345.反转字符串中的元音字母
    *
    * @author rsm
    * @date 2023-08-15 16:42:07
    */
  public class Q345ReverseVowelsOfAString{
      public static void main(String[] args) {
           Solution solution = new Q345ReverseVowelsOfAString().new Solution();

          System.out.println(solution.reverseVowels("hello"));
          System.out.println(solution.reverseVowels("leetcode"));
      }
      /**
    * 345.反转字符串中的元音字母
    *
    * @author rsm
    * @date 2023-08-15 16:42:07
    */
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        String lowerCase = s.toLowerCase();
        char[] charArray = lowerCase.toCharArray();
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !isValidChar(charArray[i])) {
                i++;
            }
            while (i < j && !isValidChar(charArray[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(i, j, chars);
            i++;
            j--;
        }

        return new String(chars);
    }

          private boolean isValidChar(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
          }

          private void swap(int i, int j, char[] charArray) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }