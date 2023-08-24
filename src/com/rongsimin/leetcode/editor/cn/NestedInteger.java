package com.rongsimin.leetcode.editor.cn;

import java.util.List;

/**
 * 1、NestedInteger可以存放一个整数，也可以存放一个嵌套数组
 * 2、判断存放的是整数还是数据，调用isInteger()方法
 * 3、如果存放的是整数，那么调用getInteger()方法可以拿到这个整数
 * 4、如果存放的是嵌套数组，那么调用getList()方法可以获取到嵌套数组的值
 * @author rsm
 * @date 2023/8/23 15:22
 */
public class NestedInteger {
    /**
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    public boolean isInteger() {
        return true;
    }

    /**
     * @return the single integer that this NestedInteger holds, if it holds a single integer.
     *      Return null if this NestedInteger holds a nested list
     */
    public Integer getInteger() {
        return 1;
    }

    /**
     * @return the nested list that this NestedInteger holds, if it holds a nested list
     *      Return empty list if this NestedInteger holds a single integer
     */
    public List<NestedInteger> getList() {
        return null;
    }
}
