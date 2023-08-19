//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 16660 👎 0


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 1.两数之和
 *
 * @author rsm
 * @date 2023-03-26 12:00:20
 */
public class Q1TwoSum {
    public static void main(String[] args) {
        Solution solution = new Q1TwoSum().new Solution();
        int[] twoSum = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        //System.out.println(Arrays.toString(twoSum));
        twoSum = solution.twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(twoSum));
    }

    /**
     * 1.两数之和
     *
     * @author rsm
     * @date 2023-03-26 12:00:20
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            //Arrays.sort(nums);
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    do {
                        right--;
                    } while (left < right && nums[right + 1] == nums[right]);
                }else if (sum < target) {
                    do {
                        left++;
                    } while (left < right && nums[left - 1] == nums[left]);
                } else {
                    return new int[]{left, right};
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}