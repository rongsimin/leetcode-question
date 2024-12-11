package com.rongsimin.leetcode.editor.cn;
//给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化
//，使之能够遍历这个列表中的所有整数。 
//
// 实现扁平迭代器类 NestedIterator ： 
//
// 
// NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。 
// int next() 返回嵌套列表的下一个整数。 
// boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。 
// 
//
// 你的代码将会用下述伪代码检测： 
//
// 
//initialize iterator with nestedList
//res = []
//while iterator.hasNext()
//    append iterator.next() to the end of res
//return res 
//
// 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。 
//
// 
//
// 示例 1： 
//
// 
//输入：nestedList = [[1,1],2,[1,1]]
//输出：[1,1,2,1,1]
//解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2： 
//
// 
//输入：nestedList = [1,[4,[6]]]
//输出：[1,4,6]
//解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nestedList.length <= 500 
// 嵌套列表中的整数值在范围 [-10⁶, 10⁶] 内 
// 
//
// Related Topics栈 | 树 | 深度优先搜索 | 设计 | 队列 | 迭代器 
//
// 👍 558, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 2024-12-09 22:37:45
 **/
public class Q341_扁平化嵌套列表迭代器 {
    public static void main(String[] args) {
        //NestedIterator nestedIterator = new NestedIterator(Arrays.asList(new MyNestedInteger(Arrays.asList(new MyNestedInteger(1), new MyNestedInteger(1))), new MyNestedInteger(2), new MyNestedInteger(Arrays.asList(new MyNestedInteger(1), new MyNestedInteger(1)))));
        //List<Integer> resList = new ArrayList<>();
        //while (nestedIterator.hasNext()) {
        //    resList.add(nestedIterator.next());
        //}
        //System.out.println(resList);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public class NestedIterator implements Iterator<Integer> {
        private List<Integer> list = new ArrayList<>();

        private int index;

        public NestedIterator(List<NestedInteger> nestedList) {
            if (nestedList == null || nestedList.isEmpty()) {
                return;
            }
            //buildList(nestedList, 0);
            buildList2(nestedList);
        }

        /**
         * 对 nestedList 从 0 开始遍历，对每个元素进行处理
         * 如果这个元素是Integer，那么直接放到list，否则对它里面的元素进行递归
         *
         * @param nestedList
         * @param index
         */
        private void buildList(List<NestedInteger> nestedList, int index) {
            if (nestedList.size() <= index) {
                return;
            }
            NestedInteger nestedInteger = nestedList.get(index);
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
                buildList(nestedList, index + 1);
            } else {
                buildList(nestedInteger.getList(), 0);
            }
        }

        private void buildList2(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    buildList2(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            int next = list.get(index);
            index++;
            return next;
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }
    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */
//leetcode submit region end(Prohibit modification and deletion)
    interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    class MyNestedInteger implements NestedInteger {
        private Integer val;
        private List<NestedInteger> valList;

        public MyNestedInteger(Integer val) {
            this.val = val;
        }

        public MyNestedInteger(List<NestedInteger> valList) {
            this.valList = valList;
        }

        @Override
        public boolean isInteger() {
            return val != null;
        }

        @Override
        public Integer getInteger() {
            return val;
        }

        @Override
        public List<NestedInteger> getList() {
            return valList;
        }
    }

}