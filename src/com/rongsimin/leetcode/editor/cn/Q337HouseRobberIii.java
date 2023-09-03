//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics树 | 深度优先搜索 | 动态规划 | 二叉树 
//
// 👍 1778, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 337.打家劫舍 III
 *
 * @author rsm
 * @date 2023-09-02 17:47:23
 */
public class Q337HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new Q337HouseRobberIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        private Map<TreeNode, Integer> countMap = new HashMap<>();
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 偷取root节点，和不偷取root节点，比较谁大
            // f(root) = Math.max(f(root), f(root.left) + f(root.right))
            if (countMap.containsKey(root)) {
                return countMap.get(root);
            }
            boolean leftExist = root.left != null;
            boolean rightExist = root.right != null;
            int value1 = root.val + (leftExist ? rob(root.left.left) + rob(root.left.right): 0) + (rightExist ? rob(root.right.left) + rob(root.right.right): 0);
            int value2 = rob(root.left) + rob(root.right);
            countMap.put(root, Math.max(value1, value2));
            return Math.max(value1, value2);
        }
        public int rob2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 偷取root节点，和不偷取root节点，比较谁大
            // f(root) = Math.max(f(root), f(root.left) + f(root.right))
            boolean leftExist = root.left != null;
            boolean rightExist = root.right != null;
            int value1 = root.val + (leftExist ? rob(root.left.left) + rob(root.left.right): 0) + (rightExist ? rob(root.right.left) + rob(root.right.right): 0);
            int value2 = rob(root.left) + rob(root.right);
            return Math.max(value1, value2);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}