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
// Related Topics 数组 双指针 👍 2116 👎 0

  
  package com.rongsimin.leetcode.editor.cn;

  import java.util.Arrays;

  /**
    * 283.移动零
    *
    * @author rsm
    * @date 2023-08-14 11:48:15
    */
  public class Q283MoveZeroes {
      public static void main(String[] args) {
          Solution solution = new Q283MoveZeroes().new Solution();
          int[] nums = new int[]{1, 0, 3, 0, 12};
          solution.moveZeroes(nums);
          System.out.println(Arrays.toString(nums));
      }

      /**
       * 283.移动零
       *
       * @author rsm
       * @date 2023-08-14 11:48:15
       */
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public void moveZeroes(int[] nums) {
              int notZeroIndex = 0;
              for (int i = 0; i < nums.length; i++) {
                  if (nums[i] != 0) {
                      nums[notZeroIndex] = nums[i];
                      notZeroIndex++;
                  }
              }
              for (int i = notZeroIndex; i < nums.length; i++) {
                  nums[i] = 0;
              }
          }

          public void moveZeroes2(int[] nums) {
              // 循环不变量在[0...i]中，[0,k)表示非0的元素，[k,i]表示等于0的元素
              int k = 0;
              for (int i = 0; i < nums.length; i++) {
                  if (nums[i] != 0) {
                      swap(i, k, nums);
                      k++;
                  }
              }
          }

          private void swap(int i, int j, int[] nums) {
              int temp = nums[i];
              nums[i] = nums[j];
              nums[j] = temp;
          }

      }

  }