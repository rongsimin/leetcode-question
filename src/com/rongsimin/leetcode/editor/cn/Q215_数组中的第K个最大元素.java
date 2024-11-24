package com.rongsimin.leetcode.editor.cn;
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
// Related Topics数组 | 分治 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 2591, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Q215_数组中的第K个最大元素{
    public static void main(String[] args) {
        Solution solution = new Q215_数组中的第K个最大元素().new Solution();
        //int[] nums = {3,2,1,5,6,4};
        //int k = 1;
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(solution.findKthLargest(nums, k));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k) {
            return 0;
        }
        // 第 1 大，返回 nums[n - 1];
        // 第 k 大 ，返回nums[n - k];
        return findKthLargestNew(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findKthLargestNew(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left];
        }
        int pivot = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, pivot);
        // [left + 1, lt - 1] < v
        int lt = left + 1; // [lt, gt - 1] == v
        // [gt, right] > v
        int gt = right + 1;
        for (int i = left + 1; i < gt;) {
            if (nums[i] < nums[left]) {
                lt++;
                i++;  // [left + 1, lt - 1] < v
            } else if (nums[i] > nums[left]){
                swap(nums, i, --gt);
            } else {
                i++; // [lt, i - 1]
            }
        }
        swap(nums, left, --gt);
        // 到这里后， [left, lt - 1] < v，[lt, gt - 1] == v，[gt, right] > v
        if (lt <= target && gt - 1 >= target) {
            return nums[gt - 1];
        } else if (gt - 1 < target) {
            return findKthLargest(nums, gt, right, target);
        } else {
            return findKthLargest(nums, left, lt - 1, target);
        }
    }

    /**
     * 单路快排，超时
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    private int findKthLargest(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left];
        }
        int pivot = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, pivot);
        // [left + 1, lt] < v
        //int lt = left;
        // [gt, right] >= v
        int gt = right + 1;
        for (int i = left + 1; i < gt;) {
            if (nums[i] < nums[left]) {
                i++;
                //lt++;
            } else {
                swap(nums, i, --gt);
            }
        }
        swap(nums, left, --gt);
        if (gt == target) {
            return nums[gt];
        } else if (gt < target) {
            return findKthLargest(nums, gt + 1, right, target);
        } else {
            return findKthLargest(nums, left, gt - 1, target);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k) {
            return 0;
        }
        // 第 1 大，返回 nums[n - 1];
        // 第 k 大 ，返回nums[n - k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return queue.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}