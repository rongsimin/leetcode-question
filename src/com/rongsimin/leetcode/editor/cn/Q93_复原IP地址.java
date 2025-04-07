package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-12-15 10:59:00
 **/
public class Q93_复原IP地址 {
    public static void main(String[] args) {
        Solution solution = new Q93_复原IP地址().new Solution();
        System.out.println(solution.restoreIpAddresses("0000"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> resList = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            if (s.length() > 12 || s.length() < 4) {
                return resList;
            }
            dfs(s, 0, "");
            return resList;
        }


        /**
         * @param s     待处理的数字字符串
         * @param index 处理到 index的位置
         * @param temp  保存 s[0, index - 1]处理后的结果
         */
        private void dfs(String s, int index, String temp) {
            if (index > s.length()) {
                return;
            }
            if (index == s.length()) {
                if (isValid(s, index, s.length() - 1)) {
                    temp = temp + "." + s.substring(index);
                    resList.add(temp);
                }
                return;
            }
            for (int i = index; i < index + 3; i++) {
                //String curStr = s.substring(index, i + 1);
                if (isValid(s, index, i)) {
                    temp = temp + "." + s.substring(index, i + 1);
                    dfs(s, i + 1, temp);
                }
            }
        }

        private boolean isValid(String s, int i, int j) {
            if (j - i > 3) {
                return false;
            }
            String sub = s.substring(i, Math.min(j + 1, s.length()));
            if (sub.equals("")) {
                return false;
            }
            int res = Integer.parseInt(sub);
            if (j - i == 3 && res < 100) {
                return false;
            }
            if (j - i == 3 && res > 255) {
                return false;
            }
            if (j - i == 2 && res < 10) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}