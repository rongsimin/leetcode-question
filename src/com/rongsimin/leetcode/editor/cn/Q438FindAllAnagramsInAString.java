//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
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
// Related Topics 哈希表 字符串 滑动窗口 👍 1250 👎 0


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 438.找到字符串中所有字母异位词
 *
 * @author rsm
 * @date 2023-08-16 12:01:42
 */
public class Q438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new Q438FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }

    /**
     * 438.找到字符串中所有字母异位词
     *
     * @author rsm
     * @date 2023-08-16 12:01:42
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int[] pFreq = new int[26];
            // [left,right] 就是一个滑动窗口,窗口长度就是right - left + 1
            int left = 0;
            int right = -1;
            int pLength = p.length();
            int sLength = s.length();
            for (int i = 0; i < pLength; i++) {
                pFreq[p.charAt(i) - 'a'] ++;
            }
            int[] sFreq = new int[26];
            while (right < sLength - 1) {
                right++;
                sFreq[s.charAt(right) - 'a']++;
                if (right - left + 1 > pLength) {
                    sFreq[s.charAt(left) - 'a']--;
                    left++;
                }
                if (right - left + 1 == pLength && isEqual(sFreq, pFreq)) {
                    res.add(left);
                }
            }
            return res;
        }

        private boolean isEqual(int[] sFreq, int[] pFreq){
            for (int i = 0; i < sFreq.length; i++) {
                if (sFreq[i] != pFreq[i]) {
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}