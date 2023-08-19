//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 947 👎 0


package com.rongsimin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 567.字符串的排列
 *
 * @author rsm
 * @date 2023-08-17 16:08:11
 */
public class Q567PermutationInString {
    public static void main(String[] args) {
        Solution solution = new Q567PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s2, String s1) {
            Map<Character, Integer> needsMap = new HashMap<>();
            for (int i = 0; i < s2.length(); i++) {
                needsMap.put(s2.charAt(i), needsMap.getOrDefault(s2.charAt(i), 0) + 1);
            }
            Map<Character, Integer> windowsMap = new HashMap<>();
            // [l, r] 为滑动窗口
            int l = 0;
            int r = -1;
            while (r + 1 < s1.length()) {
                r++;
                windowsMap.put(s1.charAt(r), windowsMap.getOrDefault(s1.charAt(r), 0) + 1);
                if (r - l + 1 == s2.length()) {
                    if (isContains(needsMap, windowsMap)) {
                        return true;
                    }
                    windowsMap.put(s1.charAt(l), windowsMap.get(s1.charAt(l))  - 1);
                    l++;
                }
            }
            return false;
        }

        private boolean isContains(Map<Character, Integer> needsMap, Map<Character, Integer> windowsMap) {
            for (Character ch : needsMap.keySet()) {
                if (!windowsMap.containsKey(ch)) {
                    return false;
                }
                if (!needsMap.get(ch) .equals(windowsMap.get(ch))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}