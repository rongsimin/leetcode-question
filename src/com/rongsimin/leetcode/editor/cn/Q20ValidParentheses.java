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
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
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
// 👍 4101, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20.有效的括号
 *
 * @author rsm
 * @date 2023-08-23 09:51:30
 */
public class Q20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Q20ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> deque = new LinkedList<>();
            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '[' || ch == '{') {
                    deque.addLast(ch);
                } else {
                    if (deque.isEmpty() || !isPair(deque.removeLast(), ch)) {
                        return false;
                    }
                }
            }
            return deque.isEmpty();
        }

        private boolean isPair(char left, char right) {
            return (left == '(' && right == ')')
                    || (left == '[' && right == ']')
                    || (left == '{' && right == '}');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}