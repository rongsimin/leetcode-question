//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2249 👎 0


package com.rongsimin.leetcode.editor.cn;

import java.util.Random;

/**
 * 215.数组中的第K个最大元素
 *
 * @author rsm
 * @date 2023-08-15 10:46:27
 */
public class Q215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new Q215KthLargestElementInAnArray().new Solution();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k));
    }

    /**
     * 215.数组中的第K个最大元素
     *
     * @author rsm
     * @date 2023-08-15 10:46:27
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 如第1大，就是排序后的最后一个元素nums[n - 1]
            // 第k大，也就是nums[n - k]
            return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
        }

        private int findKthLargest(int[] nums, int l, int r, int k) {
            if (l >= r) {
                return nums[l];
            }
            int partition = partition(l, r, nums);
            if (partition == k) {
                return nums[partition];
            } else if (partition < k) {
                return findKthLargest(nums, partition + 1, r, k);
            } else {
                return findKthLargest(nums, l, partition - 1, k);
            }
        }

        private int partition(int l, int r, int[] nums) {
            int p = new Random().nextInt(r - l + 1) + l;
            int pivot = nums[p];
            swap(p, l, nums);
            int i = l + 1;
            int j = r;
            while (true) {
                while(i <= j && nums[i] < pivot) {
                    i++;
                }
                while(i <= j && nums[j] > pivot) {
                    j--;
                }
                if (i > j) break;
                swap(i, j, nums);
                i++;
                j--;
            }
            swap(l, i - 1, nums);
            return i - 1;
        }

        private void swap(int i, int j, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}