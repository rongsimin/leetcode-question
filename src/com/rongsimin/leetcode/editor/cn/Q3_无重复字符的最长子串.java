package com.rongsimin.leetcode.editor.cn;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
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
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 10452, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashMap;
import java.util.Map;

public class Q3_无重复字符的最长子串{
    public static void main(String[] args) {
        Solution solution = new Q3_无重复字符的最长子串().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lengthOfLongest = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;// [left, right] 为最长的不重复子串，那么 right - left + 1 就是所求
        int[] freq = new int[256];
        while (right < s.length()) {
            freq[s.charAt(right)]++;
            while (freq[s.charAt(right)] >= 2) {
                freq[s.charAt(left)]--;
                left++;
            }
            lengthOfLongest = Math.max(lengthOfLongest, right - left + 1);
            right++;
        }

        return lengthOfLongest == Integer.MIN_VALUE ? 0 : lengthOfLongest;
    }
    public int lengthOfLongestSubstringOld(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> countMap  = new HashMap<>();
        int lengthOfLongest = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;// [left, right] 为最长的不重复子串，那么 right - left + 1 就是所求
        while (right < s.length()) {
            while (countMap.containsKey(s.charAt(right))) {
                countMap.remove(s.charAt(left));
                left++;
            }
            countMap.put(s.charAt(right), 1);
            lengthOfLongest = Math.max(lengthOfLongest, countMap.size());
            right++;
        }

        return lengthOfLongest == Integer.MIN_VALUE ? 0 : lengthOfLongest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}