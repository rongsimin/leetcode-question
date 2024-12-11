package com.rongsimin.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()" 
// 
//
// 输出：true 
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}" 
// 
//
// 输出：true 
//
// 示例 3： 
//
// 
// 输入：s = "(]" 
// 
//
// 输出：false 
//
// 示例 4： 
//
// 
// 输入：s = "([])" 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics栈 | 字符串 
//
// 👍 4601, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Stack;

/**
 * 2024-12-08 22:30:54
 **/
public class Q20_有效的括号 {
    public static void main(String[] args) {
        Solution solution = new Q20_有效的括号().new Solution();
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("("));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (isLeft(s.charAt(i))) {
                    stack.push(s.charAt(i));
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!isValidChar(stack.pop(), s.charAt(i))) {
                        return false;
                    }
                }

            }
            return stack.isEmpty();
        }

        private boolean isValidChar(Character left, char right) {
            return (left == '(' && right == ')') || (left == '[' && right == ']') || (left == '{' && right == '}');
        }

        private boolean isLeft(char charAt) {
            return charAt == '(' || charAt == '[' || charAt == '{';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}