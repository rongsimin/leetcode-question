//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 1141, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90.子集 II
 *
 * @author rsm
 * @date 2023-08-31 10:25:38
 */
public class Q90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new Q90SubsetsIi().new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> resList = new ArrayList<>();
            Arrays.sort(nums);
            dfs(nums, 0, new LinkedList<>(), resList);
            return resList;
        }

        private void dfs(int[] nums, int start, LinkedList<Integer> list, List<List<Integer>> resList) {
            resList.add(new ArrayList<>(list));

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                list.addLast(nums[i]);
                dfs(nums, i + 1, list, resList);
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}