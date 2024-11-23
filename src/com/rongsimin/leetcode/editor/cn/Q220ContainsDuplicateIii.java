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
// 👍 704, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 220.存在重复元素 III
 *
 * @author rsm
 * @date 2023-08-19 16:46:39
 */
public class Q220ContainsDuplicateIii {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        System.out.println(set.floor(0));
        System.out.println(set.floor(1));
        System.out.println(set.floor(5));
        System.out.println(set.floor(6));
        System.out.println(set.ceiling(6));
        System.out.println(set.ceiling(2));
        Solution solution = new Q220ContainsDuplicateIii().new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            int left = 0;
            int right = 0;
            TreeMap<Integer, Integer> countMap = new TreeMap<>();
            while (right < nums.length) {
                //if () {
                //    return true;
                //}
                //countMap.put(nums[right], right);
                //if (countMap.size() > indexDiff) {
                //    countMap.remove();
                //}
            }

            return false;
        }
        public boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                if ((treeSet.floor(nums[i]) != null && nums[i] - treeSet.floor(nums[i]) <= valueDiff)
                    || (treeSet.ceiling(nums[i]) != null && treeSet.ceiling(nums[i]) - nums[i] <= valueDiff)
                ) {
                    // abs(x - nums[i]) <= valueDiff
                    return true;
                }
                treeSet.add(nums[i]);
                if (treeSet.size() > indexDiff) {
                    treeSet.remove(nums[i - indexDiff]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}