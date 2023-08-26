//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics数组 | 哈希表 | 分治 | 桶排序 | 计数 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 1658, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.*;

/**
 * 347.前 K 个高频元素
 *
 * @author rsm
 * @date 2023-08-25 15:58:40
 */
public class Q347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new Q347TopKFrequentElements().new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // key -> num
            // value -> count
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (pq.size() >= k) {
                    int[] peek = pq.peek();
                    if (entry.getValue() > peek[1]) {
                        pq.poll();
                        pq.offer(new int[]{entry.getKey(), entry.getValue()});
                    }
                } else {
                    pq.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }
            int[] res = new int[k];
            int i = 0;
            while (i < k) {
                int[] top = pq.poll();
                res[i] = top[0];
                i++;
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}