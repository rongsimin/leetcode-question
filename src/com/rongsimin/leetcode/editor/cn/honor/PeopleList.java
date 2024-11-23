package com.rongsimin.leetcode.editor.cn.honor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rsm
 * @date 2023/11/25 15:35
 */
public class PeopleList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            List<String> list = new ArrayList<>();
            int num = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < num; i++) {
                String str = scanner.nextLine();
                if (str.contains(",") || str.contains(" ")) {
                    str = "\"" + str + "\"";
                }
                list.add(str);
            }
            System.out.println(String.join(", ", list));
        }
    }


}
