  //给你一个 二叉树 的根结点 root，该二叉树由恰好 3 个结点组成：根结点、左子结点和右子结点。 
//
// 如果根结点值等于两个子结点值之和，返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [10,4,6]
//输出：true
//解释：根结点、左子结点和右子结点的值分别是 10 、4 和 6 。
//由于 10 等于 4 + 6 ，因此返回 true 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,1]
//输出：false
//解释：根结点、左子结点和右子结点的值分别是 5 、3 和 1 。
//由于 5 不等于 3 + 1 ，因此返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 树只包含根结点、左子结点和右子结点 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 二叉树 
//
// 👍 51, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

  
  package com.rongsimin.leetcode.editor.cn;

  import javax.swing.tree.TreeNode;

  /**
    * 2236.判断根结点是否等于子结点之和
    *
    * @author rsm
    * @date 2023-08-20 10:33:25
    */
  public class Q2236RootEqualsSumOfChildren{
      public static void main(String[] args) {
           Solution solution = new Q2236RootEqualsSumOfChildren().new Solution();
      }
      
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkTree(TreeNode root) {
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }