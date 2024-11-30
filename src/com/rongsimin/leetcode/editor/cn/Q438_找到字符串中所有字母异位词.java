package com.rongsimin.leetcode.editor.cn;
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 1544, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.List;

public class Q438_找到字符串中所有字母异位词{
    public static void main(String[] args) {
        Solution solution = new Q438_找到字符串中所有字母异位词().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("abab", "ab"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();
        char[] pChars = p.toCharArray();
        int[] pFreq = new int[26];
        for (char ch : pChars) {
            pFreq[ch - 'a']++;
        }
        char[] sChars = s.toCharArray();
        int left = 0;
        int right = 0; // [left, right] 为滑动窗口，
        int[] sFreq = new int[26];
        while (right < sChars.length) {
            sFreq[sChars[right] - 'a']++;
            if (right - left +1 > pChars.length) {
                sFreq[sChars[left] - 'a']--;
                left++;
            }
            if (right - left + 1 == pChars.length && same(sFreq, pFreq)) {
                resList.add(left);
                sFreq[sChars[left] - 'a']--;
                left++;
            }
            right++;
        }
        return resList;
    }

    private boolean same(int[] sFreq, int[] pFreq) {
        for (int i = 0; i < sFreq.length; i++) {
            if (sFreq[i] != pFreq[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagramsWrong(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();
        char[] pChars = p.toCharArray();
        char[] sChars = s.toCharArray();
        int left = 0;
        int right = 0;
        int[] freq = new int[26];
        while (right < sChars.length) {
            freq[sChars[right] - 'a']--;
            freq[pChars[right % pChars.length] - 'a']++;
            if (right - left + 1 == pChars.length && sum(freq)) {
                resList.add(left);
                left++;
            }
            right++;
        }
        return resList;
    }

    private boolean sum(int[] nums) {
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}