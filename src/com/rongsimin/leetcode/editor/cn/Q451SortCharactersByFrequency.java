//给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
//
// 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "tree"
//输出: "eert"
//解释: 'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入: s = "cccaaa"
//输出: "cccaaa"
//解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入: s = "Aabb"
//输出: "bbAa"
//解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁵ 
// s 由大小写英文字母和数字组成 
// 
//
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 492 👎 0


package com.rongsimin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451.根据字符出现频率排序
 *
 * @author rsm
 * @date 2023-08-17 21:11:48
 */
public class Q451SortCharactersByFrequency {
    public static void main(String[] args) {

        Solution solution = new Q451SortCharactersByFrequency().new Solution();
        System.out.println(solution.frequencySort("cccaaabb"));
        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.frequencySort("Aabb"));
        System.out.println((char)97);
        System.out.println((char)98);
        System.out.println((char)100);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
            }
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                    (o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0]
            );
            for (Character ch : countMap.keySet()) {
                priorityQueue.add(new int[]{ch, countMap.get(ch)});
            }
            StringBuilder sb = new StringBuilder();
            while (!priorityQueue.isEmpty()) {
                int[] poll = priorityQueue.poll();
                int val = poll[1];
                for (int i = 0; i < val; i++) {
                    sb.append((char)poll[0]);
                }
            }
            return sb.toString();
        }
    }

    class MyNode implements Comparable<MyNode> {
        public char key;
        public int val;

        public MyNode(char key, int val) {
            this.key = key;
            this.val = val;
        }


        @Override
        public int compareTo(MyNode node) {
            return this.val != node.val ? node.val - this.val: (this.key - node.key);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}