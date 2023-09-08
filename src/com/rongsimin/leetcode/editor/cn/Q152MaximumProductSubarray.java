//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 2091, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 152.乘积最大子数组
 *
 * @author rsm
 * @date 2023-09-07 19:09:31
 */
public class Q152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new Q152MaximumProductSubarray().new Solution();
        System.out.println(solution.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println("-----");
        System.out.println(solution.maxProduct(new int[]{-2,0,-1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            // dp[i] 为 以 i 结尾的，连续子数组乘积最大的值
            // dp2[i] 为以 i 结尾的连续子数组乘积最小的值
            // dp[i] = max(nums[i], dp[i-1] * nums[i], dp2[i - 1]*nums[i])
            int[] dpMax = new int[nums.length];
            int[] dpMin = new int[nums.length];
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dpMin[i] = min3(nums[i], nums[i] * dpMin[i - 1], dpMax[i - 1] * nums[i]);
                dpMax[i] = max3(nums[i], dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]);
                max = Math.max(max,dpMax[i]);
            }
            System.out.println(Arrays.toString(dpMax));
            System.out.println(Arrays.toString(dpMin));
            return max;
        }

        private int min3(int i, int j, int k) {
            return Math.min(i, Math.min(j, k));
        }

        private int max3(int i, int j, int k) {
            return Math.max(i, Math.max(j, k));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}