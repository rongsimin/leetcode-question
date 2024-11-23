package com.rongsimin.leetcode.editor.cn;

/**
 * @author rsm
 * @date 2023/12/4 21:39
 */
public class ThrowExceptionTest {
    public static void main(String[] args) throws Exception {
        System.out.println("hello" + get());
    }

    private static int get() throws Exception{
        for (int i = 0; i < 1; i++) {
            try {
                int a = 0;
                throw new Exception("haha");
            } catch (Exception ex) {
                throw ex;
            } finally {
                continue;
            }
        }
        return 1;
    }
}
