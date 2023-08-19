//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 810 👎 0


package com.rongsimin.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349.两个数组的交集
 *
 * @author rsm
 * @date 2023-08-17 16:53:12
 */
public class Q349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new Q349IntersectionOfTwoArrays().new Solution();
        System.out.println(Arrays.toString(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> nums1Set = new HashSet<>();
            for (int num : nums1) {
                nums1Set.add(num);
            }
            Set<Integer> resultSet = new HashSet<>();
            for (int num : nums2) {
                if (nums1Set.contains(num)) {
                    resultSet.add(num);
                }
            }
            int[] res = new int[resultSet.size()];
            int i = 0;
            for (Integer e : resultSet) {
                res[i++] = e;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}