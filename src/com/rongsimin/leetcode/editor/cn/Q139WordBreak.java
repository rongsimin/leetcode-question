//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics字典树 | 记忆化搜索 | 数组 | 哈希表 | 字符串 | 动态规划 
//
// 👍 2274, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139.单词拆分
 *
 * @author rsm
 * @date 2023-09-05 15:39:57
 */
public class Q139WordBreak {
    public static void main(String[] args) {
        Solution solution = new Q139WordBreak().new Solution();
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] isOk;
        public boolean wordBreak(String s, List<String> wordDict) {
            // 把s切成两段 s[0,j] 和s[j,n],如果前者在字典里面，那么就继续看s[j,n]还能否继续切割
            isOk = new int[s.length() + 1];
            Arrays.fill(isOk, -1);
            return dfs2(s, 0, new HashSet<>(wordDict));
        }

        private boolean dfs2(String s, int start, HashSet<String> set) {
            if (start == s.length()) {
                return true;
            }
            if (isOk[start] != -1) {
                return isOk[start] == 1;
            }
            for (int i = start + 1; i <= s.length(); i++) {
                // 切成两部分 s[start,i] 和s[i,s.length()]
                String prefix = s.substring(start, i);
                if (set.contains(prefix) && dfs2(s, i, set)) {
                    isOk[start] = 1;
                    return true;
                }
            }
            isOk[start] = 0;
            return false;
        }

        public boolean wordBreak2(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            // dp[i] 表示 s[0,i-1] 是否可以由List组成
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    // j 把 i切成两段 dp[j] 和s[j,i-1]
                    if (dp[i] = (dp[j] && wordSet.contains(s.substring(j, i)))) {
                        break;
                    }
                }
            }
            return dp[s.length()];
        }

        private boolean dfs(String s, List<String> wordDict, String temp) {
            if (temp.length() >= s.length()) {
                if (s.equals(temp)) {
                    return true;
                } else {
                    return false;
                }
            }
            boolean result = false;
            for (int i = 0; i < wordDict.size(); i++) {
                result = dfs(s, wordDict, temp + wordDict.get(i));
                if (result) {
                    break;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}