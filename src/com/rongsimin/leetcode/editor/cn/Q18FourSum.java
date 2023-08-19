//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1723 👎 0


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18.四数之和
 *
 * @author rsm
 * @date 2023-08-18 11:36:28
 */
public class Q18FourSum {
    public static void main(String[] args) {
        Solution solution = new Q18FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(solution.fourSum(new int[]{2,2,2,2,2}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> resList = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3;) {
                for (int j = i + 1; j < nums.length - 2;) {
                    long t = (long)target - nums[i] - nums[j];
                    int k = j + 1;
                    int r = nums.length - 1;
                    if (k >= r) {
                        break;
                    }
                    while (k < r) {
                        if ((long)nums[k] + (long)nums[r] - t > 0) {
                            r = preIndex(nums, r);
                        } else if ((long)nums[k] + (long)nums[r] - t < 0) {
                            k = nextIndex(nums, k);
                        } else {
                            resList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[r]));
                            r = preIndex(nums, r);
                            k = nextIndex(nums, k);
                        }
                    }
                    j = nextIndex(nums, j);
                }
                i = nextIndex(nums, i);
            }
            return resList;
        }

        private int preIndex(int[] nums, int curIndex) {
            int temp = nums[curIndex];
            for (int j = curIndex - 1; j >= 0; j--) {
                if (temp != nums[j]) {
                    return j;
                }
            }
            return -1;
        }

        private int nextIndex(int[] nums, int curIndex) {
            int temp = nums[curIndex];
            for (int i = curIndex + 1; i < nums.length; i++) {
                if (temp != nums[i]) {
                    return i;
                }
            }
            return nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}