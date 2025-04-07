package com.rongsimin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2025-04-01 17:15:43
 **/
public class Q451_根据字符出现频率排序 {
    public static void main(String[] args) {
        Solution solution = new Q451_根据字符出现频率排序().new Solution();
        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.frequencySort("cccaaa"));
        System.out.println(solution.frequencySort("Aabb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            Map<Character, Integer> countMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                int[] poll = pq.poll();
                for (int i = 0; i < poll[1]; i++) {
                    sb.append((char) poll[0]);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}