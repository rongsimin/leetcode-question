package com.rongsimin.leetcode.editor.cn;
//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "IceCreAm" 
// 
//
// 输出："AceCreIm" 
//
// 解释： 
//
// s 中的元音是 ['I', 'e', 'e', 'A']。反转这些元音，s 变为 "AceCreIm". 
//
// 示例 2： 
//
// 
// 输入：s = "leetcode" 
// 
//
// 输出："leotcede" 
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
// Related Topics双指针 | 字符串 
//
// 👍 363, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q345_反转字符串中的元音字母{
    public static void main(String[] args) {
        Solution solution = new Q345_反转字符串中的元音字母().new Solution();
        System.out.println(solution.reverseVowels("IceCreAm"));
        System.out.println(solution.reverseVowels("leetcode"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u', 'A','E','I','O','U'));

        public String reverseVowels(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }

            char[] chars = s.toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while (left < right) {
                while (left < right && !vowelSet.contains(chars[left])) {
                    left++;
                }
                while (left < right && !vowelSet.contains(chars[right])) {
                    right--;
                }
                swap(chars, left, right);
                left++;
                right--;
            }
            return new String(chars);
        }

        private void swap(char[] s, int left, int right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}