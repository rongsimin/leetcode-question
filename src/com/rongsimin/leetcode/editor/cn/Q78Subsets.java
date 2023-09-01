//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 2127, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78.子集
 *
 * @author rsm
 * @date 2023-08-31 09:25:12
 */
public class Q78Subsets {
    public static void main(String[] args) {
        Solution solution = new Q78Subsets().new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
        System.out.println(solution.subsets(new int[]{0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> resList = new ArrayList<>();
            dfs(nums, 0, new LinkedList<>(), resList);
            return resList;
        }

        private void dfs(int[] nums, int start, LinkedList<Integer> list, List<List<Integer>> resList) {
            resList.add(new ArrayList<>(list));
            for (int i = start; i < nums.length; i++) {
                list.addLast(nums[i]);
                dfs(nums, i + 1, list, resList);
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}