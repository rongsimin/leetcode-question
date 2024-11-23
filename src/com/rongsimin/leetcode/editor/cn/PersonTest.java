package com.rongsimin.leetcode.editor.cn;

/**
 * @author rsm
 * @date 2023/12/4 21:57
 */
public class PersonTest {

    class Father {
        int a = 10;

        public void say() {
            System.out.println("100");
        }

    }

    class Son extends Father {
        int a = 20;

        public void say() {
            System.out.println("200");
        }
    }

    public static void main(String[] args) {
        Father father = new PersonTest().new Son();
        System.out.println(father.a);
        father.say();
    }
}
