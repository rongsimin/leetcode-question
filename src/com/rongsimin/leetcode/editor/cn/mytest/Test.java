package com.rongsimin.leetcode.editor.cn.mytest;

/**
 * @author rsm
 * @date 2024/12/1 22:14
 */
class Parent {
    static void show() {
        System.out.println("Parent show()");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child show()");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent.show();  // 输出 "Parent show()"
        Child.show();   // 输出 "Child show()"

        Parent p = new Child();
        p.show();  // 输出 "Parent show()" - 注意！调用的是 Parent 的 show()，不是 Child 的 show()
    }
}

