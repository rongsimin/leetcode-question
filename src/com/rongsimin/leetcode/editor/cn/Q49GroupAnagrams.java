//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics数组 | 哈希表 | 字符串 | 排序 
//
// 👍 1571, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.*;

/**
 * 49.字母异位词分组
 *
 * @author rsm
 * @date 2023-08-19 10:20:45
 */
public class Q49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Q49GroupAnagrams().new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> resList = new ArrayList<>();
            Map<String, List<String>> stringListMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String origin = strs[i];
                char[] charArray = origin.toCharArray();
                Arrays.sort(charArray);
                if (stringListMap.containsKey(new String(charArray))) {
                    stringListMap.get(new String(charArray)).add(origin);
                } else {
                    List<String> stringList = new ArrayList<>();
                    stringList.add(origin);
                    stringListMap.put(new String(charArray), stringList);
                }
            }
            for (List<String> value : stringListMap.values()) {
                resList.add(value);
            }
            return resList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}