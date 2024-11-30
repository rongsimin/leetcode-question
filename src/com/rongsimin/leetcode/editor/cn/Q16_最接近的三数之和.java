package com.rongsimin.leetcode.editor.cn;
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
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
//解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。 
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
// 👍 1679, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;

public class Q16_最接近的三数之和{
    public static void main(String[] args) {
        Solution solution = new Q16_最接近的三数之和().new Solution();
        int[] nums = {1,1,1,1};
        int target = -100;
        System.out.println(solution.threeSumClosest(nums, target));
        //int[] nums = {-1,2,1,-4};
        //int target = 1;
        //System.out.println(solution.threeSumClosest(nums, target));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long total = Integer.MAX_VALUE;
        long minDiff = total - target;
        for (int i = 0; i < nums.length - 2;) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                long tempTotal = nums[i] + nums[left] + nums[right];
                long tempDiff = Math.abs(tempTotal - target);
                if (tempDiff < minDiff) {
                    minDiff = tempDiff;
                    total = tempTotal;
                }
                if (tempDiff == 0) {
                    return target;
                } else if (tempTotal > target) {
                    right--;
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                }
            }
            i++;
            while (i < nums.length - 2 && nums[i - 1] == nums[i]) {
                i++;
            }
        }
        return (int)total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}