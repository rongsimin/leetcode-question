//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 1609, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.*;

/**
 * 131.分割回文串
 *
 * @author rsm
 * @date 2023-08-30 16:43:33
 */
public class Q131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new Q131PalindromePartitioning().new Solution();
        System.out.println(solution.partition("bb"));
        //System.out.println(solution.partition("iiiiiiiiiiiii"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> resList = new ArrayList<>();
            if (s.length() == 1) {
                resList.add(Arrays.asList(s));
                return resList;
            }
            Deque<String> deque = new LinkedList<>();
            dfs(s, 0, resList, deque, 0);
            return resList;
        }

        private void dfs(String s, int start, List<List<String>> resList, Deque<String> deque, int level) {
            System.out.print(buildStr(level));
            System.out.println("start:" + start);
            if (start >= s.length()) {
                resList.add(new ArrayList<>(deque));
                System.out.print(buildStr(level));
                System.out.println("return, resList:" + resList);
                return;
            }
            // 取start,start + i的字符串，判断是回文串，则加入
            for (int i = 1; i <= s.length(); i++) {
                if (start + i > s.length()) {
                    break;
                }
                String curStr = s.substring(start, start + i);
                System.out.print(buildStr(level));
                System.out.printf("curStr[%d,%d]:%s",start, start + i, curStr);
                System.out.println();
                if (isValid(curStr)) {
                    deque.addLast(curStr);
                    System.out.print(buildStr(level));
                    System.out.println("deque:" + deque);
                    dfs(s, start + i, resList, deque, level + 1);
                    deque.removeLast();
                }
            }
            System.out.print(buildStr(level));
            System.out.println("completed return");
        }

        private String buildStr(int level) {
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            for (int i = 0; i < level; i++) {
                sb.append("--");
            }
            return sb.toString();
        }

        private boolean isValid(String str) {
            int i = 0;
            int j = str.length() -1;
            while (i < j) {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}