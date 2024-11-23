package com.rongsimin.leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics数组 | 双指针 
//
// 👍 2496, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class Q283_移动零{
    public static void main(String[] args) {
        Solution solution = new Q283_移动零().new Solution();
        //int[] ints = {0, 1, 0, 3, 12};
        
        int[] ints = {1, 3, 12};
        solution.moveZeroes(ints);
        System.out.println(ints);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        // zeroIndex 为零元素
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if ( i != zeroIndex) {
                    swap(nums, zeroIndex++, i);
                } else {
                    zeroIndex++;
                }
            }
        }
    }

    /**
     * 没法通过全是非零元素的特殊场景，因为都是非零的时候，是需要 zeroIndex 也不断加1的
     * @param nums
     */
    public void moveZeroesWrong(int[] nums) {
        // zeroIndex 为零元素
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i != zeroIndex) {
                swap(nums, zeroIndex++, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void moveZeroes2(int[] nums) {
        // [0, notZeroIndex] 为非零元素
        int notZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                notZeroIndex++;
                nums[notZeroIndex] = nums[i];
            }
        }
        for (int i = notZeroIndex + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}