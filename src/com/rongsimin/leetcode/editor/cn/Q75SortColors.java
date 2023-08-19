  //给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1637 👎 0

  
  package com.rongsimin.leetcode.editor.cn;

  import java.util.Arrays;

  /**
    * 75.颜色分类
    *
    * @author rsm
    * @date 2023-08-15 09:45:12
    */
  public class Q75SortColors{
      public static void main(String[] args) {
           Solution solution = new Q75SortColors().new Solution();
          int[] nums = {2, 0, 2, 1, 1, 0};
          solution.sortColors(nums);
          System.out.println(Arrays.toString(nums));

      }
      /**
    * 75.颜色分类
    *
    * @author rsm
    * @date 2023-08-15 09:45:12
    */
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int zero = -1; // [0, zero] 是等于0
        int two = nums.length; // [two, n - 1] 是等于2

        for (int i = 0; i < two;) {
            if (nums[i] == 0) {
                zero++;
                swap(zero, i, nums);
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(two, i, nums);
            } else {
                i++;
            }
        }


    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }