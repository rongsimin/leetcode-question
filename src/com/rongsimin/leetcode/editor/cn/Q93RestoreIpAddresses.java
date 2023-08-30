//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics字符串 | 回溯 
//
// 👍 1294, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 93.复原 IP 地址
 *
 * @author rsm
 * @date 2023-08-30 15:58:32
 */
public class Q93RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new Q93RestoreIpAddresses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            if (s.length() < 4 || s.length() > 12) {
                return new ArrayList<>();
            }
            // 分成四段，最后会是四个元素，
            // 每一个需要知道start，以及它的末尾，start + i,其中start + i - start <= 3 ,所以i取值范围是1到3
            Deque<String> deque = new LinkedList<>();
            List<String> resList = new ArrayList<>();
            dfs(s, 0, resList, deque);
            return resList;
        }

        private void dfs(String s, int start, List<String> resList, Deque<String> deque) {
            if (start == s.length()) {
                if (deque.size() == 4) {
                    resList.add(String.join(".", deque));
                }
                return;
            }
            for (int i = 1; i <= 3; i++) {
                // 此时取的是substr(start, start+i)的元素
                if (start + i > s.length()) {
                    break;
                }
                String curStr = s.substring(start, start + i);
                if (isValid(curStr)) {
                    deque.addLast(curStr);
                    dfs(s, start + i, resList, deque);
                    deque.removeLast();
                }
            }
        }

        private boolean isValid(String curStr) {
            int val = Integer.parseInt(curStr);
            if (val > 255) {
                return false;
            }
            if (curStr.length() == 3 && val < 100) {
                return false;
            }
            if (curStr.length() == 2 && val < 10) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}