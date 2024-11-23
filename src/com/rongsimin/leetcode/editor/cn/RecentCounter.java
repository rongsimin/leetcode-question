package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rsm
 * @date 2023/12/4 21:24
 */
public class RecentCounter {
    private List<Integer> tList = new ArrayList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        tList.add(t);
        return tList.size() - 1 - findFloor(t - 3000, 0, tList.size() - 1);
    }

    private int findFloor(int target, int left, int right) {
        if (target < 0) {
            return -1;
        }
        while (left < right) {
            int mid = (right - left) / 2 + left + 1;
            int temp = tList.get(mid);
            if (temp < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return tList.get(left) < target ? left : left - 1;
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(2196));
        System.out.println(recentCounter.ping(3938));
        System.out.println(recentCounter.ping(4723));
        System.out.println(recentCounter.ping(4775));
        System.out.println(recentCounter.ping(5952));
    }
}
