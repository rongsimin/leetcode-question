package com.rongsimin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 2025-04-01 17:05:40
 **/
public class Q205_同构字符串 {
    public static void main(String[] args) {
        Solution solution = new Q205_同构字符串().new Solution();
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
        System.out.println(solution.isIsomorphic("badc", "baba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> characterMap = new HashMap<>();
            Map<Character, Character> characterMap2 = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Character oldChar = characterMap.put(s.charAt(i), t.charAt(i));
                if (oldChar != null && t.charAt(i) != oldChar) {
                    return false;
                }
                Character oldChar2 = characterMap2.put(t.charAt(i), s.charAt(i));
                if (oldChar2 != null && s.charAt(i) != oldChar2) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}