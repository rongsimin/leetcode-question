package com.rongsimin.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 2025-04-01 16:21:45
 **/
public class Q202_快乐数 {
    public static void main(String[] args) {
        Solution solution = new Q202_快乐数().new Solution();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(2));
        System.out.println(solution.isHappy(100));
        System.out.println(solution.isHappy(100200));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            Set<Long> set = new HashSet<>();
            long num = n;
            while (num != 1) {
                if (set.contains(num)) {
                    return false;
                }
                set.add(num);
                int total = 0;
                while (num != 0) {
                    total += (num % 10) * (num % 10);
                    num /= 10;
                }
                num = total;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}