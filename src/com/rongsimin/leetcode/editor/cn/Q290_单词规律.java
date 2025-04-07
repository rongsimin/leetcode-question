package com.rongsimin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 2025-04-01 16:35:00
 **/
public class Q290_单词规律 {
    public static void main(String[] args) {
        Solution solution = new Q290_单词规律().new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] strings = s.split(" ");
            if (strings.length != pattern.length()) {
                return false;
            }
            Map<Character, String> patternMap = new HashMap<>();
            Map<String, Character> patternMap2 = new HashMap<>();
            for (int i = 0; i < strings.length; i++) {
                if (!patternMap.containsKey(pattern.charAt(i))) {
                    patternMap.put(pattern.charAt(i), strings[i]);
                } else {
                    if (!patternMap.get(pattern.charAt(i)).equals(strings[i])) {
                        return false;
                    }
                }
                if (!patternMap2.containsKey(strings[i])) {
                    patternMap2.put(strings[i], pattern.charAt(i));
                } else {
                    if (!patternMap2.get(strings[i]).equals(pattern.charAt(i))) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}