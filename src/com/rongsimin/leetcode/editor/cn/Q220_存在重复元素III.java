package com.rongsimin.leetcode.editor.cn;
//给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。 
//
// 找出满足下述条件的下标对 (i, j)： 
//
// 
// i != j, 
// abs(i - j) <= indexDiff 
// abs(nums[i] - nums[j]) <= valueDiff 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
//输出：true
//解释：可以找出 (i, j) = (0, 3) 。
//满足下述 3 个条件：
//i != j --> 0 != 3
//abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
//abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
//输出：false
//解释：尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 1 <= indexDiff <= nums.length 
// 0 <= valueDiff <= 10⁹ 
// 
//
// Related Topics数组 | 桶排序 | 有序集合 | 排序 | 滑动窗口 
//
// 👍 744, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.TreeSet;

public class Q220_存在重复元素III {
    public static void main(String[] args) {
        Solution solution = new Q220_存在重复元素III().new Solution();
        //int[] nums = {1, 5, 9, 1, 5, 9};
        //int indexDiff = 2;
        //int valueDiff = 3;
        //System.out.println(solution.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
        int[] nums = {1, 2, 3, 1};
        int indexDiff = 3;
        int valueDiff = 0;
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            // 满足窗口大小 <= indexDiff
            // 满足差值大小 <= valueDiff
            // 差值大小在 valueDiff 以内，其实就是 abs(nums[i] - nums[j]) <= valueDiff
            // 翻译成java代码就是 寻找 ceil(nums[j] - valueDiff),要求小于等于nums[j] + valueDiff，
            // 或者floor(nums[j] + valueDiff),要求大于等于nums[j] - valueDiff
            int left = 0;
            int right = 0; // [left, right]中寻找目标值，
            while (right < nums.length) {
                if (left < right && right - left > indexDiff) {
                    treeSet.remove(nums[left]);
                    left++;
                }
                // 寻找可能得值
                if (treeSet.floor(nums[right] + valueDiff) != null && treeSet.floor(nums[right] + valueDiff) >= nums[right] - valueDiff) {
                    return true;
                }
                treeSet.add(nums[right]);
                right++;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}