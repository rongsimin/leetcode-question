package com.rongsimin.leetcode.editor.cn;

/**
 * @author rsm
 * @date 2023/11/16 21:11
 */
public class FinallyReturnTest {
    public static void main(String[] args) {
        System.out.println(f(null));
    }

    public static Person f(Person value) {
        Person person = new Person();
        try {
            return person;
        } finally {
            if (value == null) {
                //Person person1 = new Person();
                person.setName("hello");
            }
        }
    }

    static class Person {
        String name;
        int age;
        public Person() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
