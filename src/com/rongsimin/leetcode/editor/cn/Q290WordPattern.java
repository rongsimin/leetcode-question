//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", s = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", s = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", s = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
//
// Related Topics 哈希表 字符串 👍 591 👎 0


package com.rongsimin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 290.单词规律
 *
 * @author rsm
 * @date 2023-08-17 17:33:39
 */
public class Q290WordPattern {
    public static void main(String[] args) {
        Solution solution = new Q290WordPattern().new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] target = s.split(" ");
            if (pattern.length() != target.length) {
                return false;
            }
            Map<Character, String> charToStringMap = new HashMap<>();
            Map<String, Character> stringToCharMap = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                String oldStr = charToStringMap.put(pattern.charAt(i), target[i]);
                if (oldStr != null && !oldStr.equals(target[i])) {
                    return false;
                }
                Character oldChar = stringToCharMap.put(target[i], pattern.charAt(i));
                if (oldChar != null && !oldChar.equals(pattern.charAt(i))) {
                    return false;
                }
                /* if (!charToStringMap.containsKey(pattern.charAt(i)) && !stringToCharMap.containsKey(target[i])) {
                    charToStringMap.put(pattern.charAt(i), target[i]);
                    stringToCharMap.put(target[i], pattern.charAt(i));
                } else {
                    // 有一个是包含的，取出来看看
                    if (charToStringMap.containsKey(pattern.charAt(i))) {
                        if (!charToStringMap.get(pattern.charAt(i)).equals()) {
                            return false;
                        }
                    }
                } */
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}