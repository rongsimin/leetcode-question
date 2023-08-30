//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics哈希表 | 字符串 | 回溯 
//
// 👍 2598, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17.电话号码的字母组合
 *
 * @author rsm
 * @date 2023-08-30 11:39:27
 */
public class Q17LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Solution solution = new Q17LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Map<Character, String> charToStrMap = new HashMap<>();

        {
            charToStrMap.put('2',"abc");
            charToStrMap.put('3',"def");
            charToStrMap.put('4',"ghi");
            charToStrMap.put('5',"jkl");
            charToStrMap.put('6',"mno");
            charToStrMap.put('7',"pqrs");
            charToStrMap.put('8',"tuv");
            charToStrMap.put('9',"wxyz");
        }
        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return new ArrayList<>();
            }
            List<String> resList = new ArrayList<>();
            combination(resList, digits, 0, "");
            return resList;
        }

        private void combination(List<String> resList, String digits, int level, String temp) {
            if (level == digits.length()) {
                resList.add(temp);
                return;
            }
            char curChar = digits.charAt(level);
            String curStr = charToStrMap.get(curChar);
            char[] array = curStr.toCharArray();
            for (int i = 0; i < array.length; i++) {
                combination(resList, digits, level + 1, temp + array[i]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}