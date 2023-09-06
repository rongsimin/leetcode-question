//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2667, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.*;

/**
 * 46.全排列
 *
 * @author rsm
 * @date 2023-08-30 17:41:41
 */
public class Q46Permutations {
    public static void main(String[] args) {
        Solution solution = new Q46Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> resList = new ArrayList<>();
            if (nums.length == 1) {
                resList.add(Collections.singletonList(nums[0]));
                return resList;
            }
            LinkedList<Integer> list = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            dfs(nums, list, resList, set);
            return resList;
        }

        private void dfs(int[] nums, LinkedList<Integer> list, List<List<Integer>> resList, Set<Integer> set) {
            if (list.size() == nums.length) {
                resList.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(i)) {
                    continue;
                }
                list.add(nums[i]);
                set.add(i);
                dfs(nums, list, resList, set);
                list.removeLast();
                set.remove(i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}