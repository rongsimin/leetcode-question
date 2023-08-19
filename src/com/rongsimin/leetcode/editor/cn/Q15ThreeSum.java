//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6253 👎 0


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 *
 * @author rsm
 * @date 2023-08-18 09:46:10
 */
public class Q15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Q15ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{0,0,0,0,0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length - 2;) {
                if (nums[i] > 0) {
                    break;
                }
                int j = i + 1;
                int r = nums.length - 1;
                while (j < r) {
                    int sum = nums[i] + nums[j] + nums[r];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[r]));
                        j = nextIndex(nums, j);
                        r = preIndex(nums, r);
                    } else if (sum < 0) {
                        j = nextIndex(nums, j);
                    } else {
                        r = preIndex(nums, r);
                    }
                }
                i = nextIndex(nums, i);
            }
            return res;

        }

        private int nextIndex(int[] nums, int index) {
            int temp = nums[index];
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] > temp) {
                    return i;
                }
            }
            return nums.length;
        }
        private int preIndex(int[] nums, int index) {
            int temp = nums[index];
            for (int i = index - 1; i > 0; i--) {
                if (nums[i] < temp) {
                    return i;
                }
            }
            return -1;
        }
        public List<List<Integer>> threeSum2(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                // 固定住i,让j 和 r 双指针进行移动
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1;
                int r = nums.length - 1;
                while (j < r) {
                    if (j != 1 && nums[j] == nums[j - 1]) {
                        j++;
                        continue;
                    }
                    //if (r != nums.length - 1 && nums[r] == nums[r + 1]) {
                    //    r--;
                    //    continue;
                    //}
                    int sum = nums[i] + nums[j] + nums[r];
                    if (sum == 0) {
                        // 添加到集合
                        res.add(Arrays.asList(nums[i], nums[j], nums[r]));
                        j++;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        r--;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}