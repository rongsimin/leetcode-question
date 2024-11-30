package com.rongsimin.leetcode.editor.cn;
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 3053, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashMap;
import java.util.Map;

public class Q76_最小覆盖子串 {
    public static void main(String[] args) {
        Solution solution = new Q76_最小覆盖子串().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("a", "a"));
        System.out.println(solution.minWindow("a", "aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindowV2(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            char[] tCharArray = t.toCharArray();
            Map<Character, Integer> tCountMap = new HashMap<>();
            for (char ch : tCharArray) {
                tCountMap.putIfAbsent(ch, 0);
                tCountMap.put(ch, tCountMap.get(ch) + 1);
            }
            char[] sCharArray = s.toCharArray();
            int left = 0;
            int right = 0;
            int resL = -1;
            int resR = -1;
            int minLength = Integer.MAX_VALUE;
            Map<Character, Integer> sCountMap = new HashMap<>();
            while (right < sCharArray.length) {
                sCountMap.putIfAbsent(sCharArray[right], 0);
                sCountMap.put(sCharArray[right], sCountMap.get(sCharArray[right]) + 1);
                while (isContains(sCountMap, tCountMap)) {
                    if (minLength > right - left + 1) {
                        minLength = right - left + 1;
                        resL = left;
                        resR = right;
                    }
                    sCountMap.put(sCharArray[left], sCountMap.get(sCharArray[left]) - 1);
                    left++;
                }
                right++;
            }
            return resL == -1 ? "" : s.substring(resL, resR + 1);
        }

        private boolean isContains(Map<Character, Integer> sCountMap, Map<Character, Integer> tCountMap) {
            for (Map.Entry<Character, Integer> entry : tCountMap.entrySet()) {
                Character key = entry.getKey();
                Integer tValue = entry.getValue();
                if (!sCountMap.containsKey(key) || sCountMap.get(key) < tValue) {
                    return false;
                }
            }
            return true;
        }

        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            char[] tCharArray = t.toCharArray();
            int[] tFreq = new int[256];
            for (char ch : tCharArray) {
                tFreq[ch]++;
            }

            char[] sCharArray = s.toCharArray();
            int[] sFreq = new int[256];
            int left = 0;
            int right = 0;
            int resL = -1;
            int resR = -1;
            int minLength = Integer.MAX_VALUE;
            while (right < sCharArray.length) {
                sFreq[sCharArray[right]]++;
                while (isContains(sFreq, tFreq)) {
                    if (minLength > right - left + 1) {
                        minLength = right - left + 1;
                        resL = left;
                        resR = right;
                    }
                    sFreq[sCharArray[left]]--;
                    left++;
                }
                right++;
            }
            return resL == -1 ? "" : s.substring(resL, resR + 1);
        }
        public String minWindowOld(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            char[] tCharArray = t.toCharArray();
            int[] tFreq = new int[256];
            for (char ch : tCharArray) {
                tFreq[ch]++;
            }

            String res = s + " ";
            char[] sCharArray = s.toCharArray();
            int[] sFreq = new int[256];
            int left = 0;
            int right = 0;
            while (right < sCharArray.length) {
                sFreq[sCharArray[right]]++;
                while (isContains(sFreq, tFreq)) {
                    if (res.length() > right - left + 1) {
                        res = s.substring(left, right + 1);
                    }
                    sFreq[sCharArray[left]]--;
                    left++;
                }
                right++;
            }
            return res.equals(s + " ") ? "" : res;
        }

        private boolean isContains(int[] sFreq, int[] tFreq) {
            for (int i = 0; i < 26; i++) {
                if (sFreq['a' + i] < tFreq['a' + i] || sFreq['A' + i] < tFreq['A' + i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}