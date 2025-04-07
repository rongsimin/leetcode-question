package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-15 10:35:44
 **/
public class Q17_电话号码的字母组合 {
    public static void main(String[] args) {
        Solution solution = new Q17_电话号码的字母组合().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String[] digitArray = {
                " ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        private List<String> resList = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return resList;
            }
            findCombinations(digits, 0, "");
            return resList;
        }

        /**
         * 对一个数字字符串进行递归解析，得到对应的字母字符串的组合结果
         *
         * @param digits 需要处理的数字字符串
         * @param index  当前处理到数字字符串的索引位置
         * @param temp   用来保存 digits[0, index - 1] 对应的字母字符串
         */
        private void findCombinations(String digits, int index, String temp) {
            System.out.println("index = " + index + ", temp = " + temp);
            if (index == digits.length()) {
                resList.add(temp);
                System.out.println("get " + temp + ", return");
                return;
            }
            // 当前处理的数字字符串的索引位置
            char c = digits.charAt(index);
            String str = digitArray[c - '0'];
            for (int i = 0; i < str.length(); i++) {
                System.out.println("digits[" + index + "]=" + c + ", use " + str.charAt(i));
                findCombinations(digits, index + 1, temp + str.charAt(i));
            }

            System.out.println("digits[" + index + "]=" + c + ", Completed return");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}