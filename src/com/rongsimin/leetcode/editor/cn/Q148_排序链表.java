package com.rongsimin.leetcode.editor.cn;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics链表 | 双指针 | 分治 | 排序 | 归并排序 
//
// 👍 2409, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Random;

public class Q148_排序链表 {
    public static void main(String[] args) {
        Solution solution = new Q148_排序链表().new Solution();
        System.out.println(solution.sortList(new ListNode(new int[]{4, 2, 1, 3})));
        System.out.println(solution.sortList(new ListNode(new int[]{-1, 5, 3, 4, 0})));
        //int n = 10000;
        //int[] nums = getArrays(n);
        //sort(nums);
        //for (int i = 0; i < n - 1; i++) {
        //    if (nums[i] > nums[i + 1]) {
        //        System.out.println(nums[i] + "," + nums[i + 1]);
        //        throw new RuntimeException("排序错误");
        //    }
        //}
        //System.out.println("排序正确");
    }

    private static int[] getArrays(int n) {
        int[] nums = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(n);
        }
        return nums;
    }

    public static void sort(int[] nums) {
        sort2(nums);
    }

    /**
     * 自底向上
     *
     * @param nums
     */
    private static void sort2(int[] nums) {
        int sz = 1; // 合并的区间长度
        while (sz < nums.length) {
            for (int i = 0; i < nums.length - sz; i += 2 * sz) {
                // i 和 i + sz的元素进行比较
                // left=i,right = i + 2 * sz - 1
                // (i + 2 * sz - 1 - i + 1) / 2
                merge(nums, i, i + sz - 1, Math.min(i + 2 * sz - 1, nums.length - 1));
            }
            sz *= 2;
        }
    }

    private static void swap1(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int l = left; l <= right; l++) {
            nums[l] = temp[l - left];
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode sortList3(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummyNode = new ListNode(Integer.MIN_VALUE, head);
            ListNode sortedNode = head;
            ListNode cur = head.next;
            while (cur != null) {
                if (cur.val >= sortedNode.val) {
                    sortedNode.next = cur;
                    sortedNode = cur;
                    cur = cur.next;
                } else {
                    ListNode preNode = dummyNode;
                    while (cur.val >= preNode.next.val) {
                        preNode = preNode.next;
                    }
                    sortedNode.next = cur.next;
                    cur.next = preNode.next;
                    preNode.next = cur;
                    cur = sortedNode.next;
                }
            }
            return dummyNode.next;
        }

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // slow 走到一半
            // fast 走完了
            ListNode head2 = slow.next;
            slow.next = null;
            ListNode node1 = sortList(head);
            ListNode node2 = sortList(head2);
            ListNode dummyNode = new ListNode(-1);
            ListNode preNode = dummyNode;
            mergeTwo(preNode, node1, node2);
            return dummyNode.next;
        }

        private void mergeTwo(ListNode pre, ListNode node1, ListNode node2) {
            ListNode head1 = node1;
            ListNode head2 = node2;
            ListNode preNode = pre;
            while (head1 != null && head2 != null) {
                if (head1.val <= head2.val) {
                    preNode.next = head1;
                    preNode = preNode.next;
                    head1 = head1.next;
                } else {
                    preNode.next = head2;
                    preNode = preNode.next;
                    head2 = head2.next;
                }
            }
            if (head1 != null) {
                preNode.next = head1;
            }
            if (head2 != null) {
                preNode.next = head2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}