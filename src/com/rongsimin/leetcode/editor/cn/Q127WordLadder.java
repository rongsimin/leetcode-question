//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列
// beginWord -> s1 -> s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 
// 对于 1 <= i <= k 时，每个
// si 都在
// wordList 中。注意， beginWord 不需要在
// wordList 中。
// 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// Related Topics广度优先搜索 | 哈希表 | 字符串 
//
// 👍 1278, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.*;

/**
 * 127.单词接龙
 *
 * @author rsm
 * @date 2023-08-25 10:25:56
 */
public class Q127WordLadder {
    public static void main(String[] args) {
        Solution solution = new Q127WordLadder().new Solution();
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        String str = "abc";
        char[] chars = str.toCharArray();
        chars[0] = 'e';
        System.out.println(str);
        System.out.println(new String(chars));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return 0;
            }
            wordSet.remove(beginWord);
            // 自己也算是一步，所以起始值为1
            int step = 1;
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            while (!queue.isEmpty()) { // BFS标准写法
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    // 对队列里面的每一个字符串，进行扩散
                    String word = queue.poll();
                    char[] wordArray = word.toCharArray();
                    for (int j = 0; j < wordArray.length; j++) {
                        // 怎么扩散，枚举每一个j上面的字符，从a到z
                        char oldChar = wordArray[j];
                        for (char k = 'a'; k <= 'z'; k++) {
                            if (k == oldChar) {
                                continue;
                            }
                            wordArray[j] = k;
                            String newWord = new String(wordArray);
                            // 遍历到终点，返回step + 1
                            if (endWord.equals(newWord)) {
                                return step + 1;
                            }
                            if (!wordSet.contains(newWord)) {
                                continue;
                            }
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                        wordArray[j] = oldChar;
                    }
                }
                step++;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}