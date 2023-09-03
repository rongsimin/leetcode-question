//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 2713, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 198.打家劫舍
 *
 * @author rsm
 * @date 2023-09-02 12:10:24
 */
public class Q198HouseRobber {
    public static void main(String[] args) {
        Solution solution = new Q198HouseRobber().new Solution();
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] memo;

        public int rob(int[] nums) {
            // f(i) 是 [i,n-1]可偷取的最大值， max(nums[i] + f(i + 2), nums[i+1] + f(i + 3),...)
            // f(0)就是所求
            // base case f(n-1) = nums[n-1]
            if (nums.length == 1) {
                return nums[0];
            }
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[n - 1];
        }
        public int rob2(int[] nums) {
            memo = new int[nums.length];
            Arrays.fill(memo, -1);
            return tryRob(nums, 0);
        }

        /**
         * 从index开始一直到数组末尾，可以偷的最大值
         * @param nums
         * @param index
         * @return
         */
        private int tryRob(int[] nums, int index) {
            if (index >= nums.length) {
                return 0;
            }
            if (memo[index] != -1) {
                return memo[index];
            }
            int res = 0;
            for (int i = index; i < nums.length; i++) {
                res = Math.max(res, nums[i] + tryRob(nums, i + 2));
            }
            memo[index] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}