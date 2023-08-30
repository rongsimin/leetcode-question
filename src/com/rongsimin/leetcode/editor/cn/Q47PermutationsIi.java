//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1442, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
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
 * 47.全排列 II
 *
 * @author rsm
 * @date 2023-08-30 18:10:23
 */
public class Q47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new Q47PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean[] isUsed;
        private List<List<Integer>> resList = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            isUsed = new boolean[nums.length];
            dfs(nums, new LinkedList<>());
            return resList;
        }

        private void dfs(int[] nums, LinkedList<Integer> list) {
            if (list.size() == nums.length) {
                resList.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (isUsed[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && isUsed[i - 1]) {
                    break;
                }
                isUsed[i] = true;
                list.add(nums[i]);
                dfs(nums, list);
                isUsed[i] = false;
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}