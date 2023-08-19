//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 1493, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 16.最接近的三数之和
 *
 * @author rsm
 * @date 2023-08-18 21:37:15
 */
public class Q16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new Q16ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(solution.threeSumClosest(new int[]{0,0,0}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int k = i + 1;
                int r = nums.length - 1;
                while (k < r) {
                    int sum = nums[i] + nums[k] + nums[r];
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                    if (sum > target) {
                        while (k < r && nums[r - 1] == nums[r]) r--;
                        r--;
                    }else if (sum < target) {
                        while (k < r && nums[k + 1] == nums[k]) k++;
                        k++;
                    } else {
                        return result;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}