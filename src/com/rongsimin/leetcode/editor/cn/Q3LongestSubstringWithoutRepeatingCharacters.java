//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8947 👎 0


package com.rongsimin.leetcode.editor.cn;

/**
 * 3.无重复字符的最长子串
 *
 * @author rsm
 * @date 2023-03-26 12:50:04
 */
public class Q3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Q3LongestSubstringWithoutRepeatingCharacters().new Solution();
        int[] freq = new int[256];
        System.out.println(freq['a']);
        System.out.println(freq['A']);
        System.out.println(freq[' ']);
        System.out.println(freq['1']);
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 3.无重复字符的最长子串
     *
     * @author rsm
     * @date 2023-03-26 12:50:04
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            // [left,right] 区间内无重复字符
            int[] freq = new int[256];
            int left = 0;
            int right = -1;
            int minLen = Integer.MIN_VALUE;
            while (left < s.length()) {
                if (right + 1 < s.length() && freq[s.charAt(right + 1)] == 0) {
                    right++;
                    freq[s.charAt(right)] = 1;
                    minLen = Math.max(minLen, right  - left + 1);
                } else {
                    freq[s.charAt(left)]--;
                    left++;
                }
            }
            return minLen == Integer.MIN_VALUE ? 0 : minLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}