//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics字典树 | 字符串 
//
// 👍 2905, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

/**
 * 14.最长公共前缀
 *
 * @author rsm
 * @date 2023-09-06 20:24:43
 */
public class Q14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Q14LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix2(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }

            String firstStr = strs[0];
            int maxCommon = 0;
            int length = firstStr.length();
            while (maxCommon < length) {
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() <= maxCommon || (strs[i].charAt(maxCommon) != firstStr.charAt(maxCommon))) {
                        return firstStr.substring(0, maxCommon);
                    }
                }
                maxCommon++;
            }

            return firstStr.substring(0, maxCommon);
        }
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }
            String first = strs[0];
            int i = 0;
            while (i < first.length()){
                char ch = first.charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length() == i) {
                       return strs[j];
                    }
                    if (strs[j].charAt(i) != ch) {
                        return first.substring(0, i);
                    }
                }
                i++;
            }

            return first.substring(0, i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}