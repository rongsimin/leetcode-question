package com.rongsimin.leetcode.editor.cn;


import java.util.*;

/**
 * 2025-04-01 18:27:04
 **/
public class Q49_字母异位词分组 {
    public static void main(String[] args) {
        Solution solution = new Q49_字母异位词分组().new Solution();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
        strs = new String[]{""};
        System.out.println(solution.groupAnagrams(strs));
        strs = new String[]{"a"};
        System.out.println(solution.groupAnagrams(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> groupMap = new HashMap<>();
            List<List<String>> resList = new ArrayList<>();

            for (int i = 0; i < strs.length; i++) {
                char[] newCharArray = strs[i].toCharArray();
                Arrays.sort(newCharArray);
                String newStr = new String(newCharArray);
                groupMap.putIfAbsent(newStr, new ArrayList<>());
                groupMap.get(newStr).add(strs[i]);
            }
            resList.addAll(groupMap.values());
            return resList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}