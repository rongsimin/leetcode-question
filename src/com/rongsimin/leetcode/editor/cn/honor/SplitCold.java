package com.rongsimin.leetcode.editor.cn.honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 标题：分金条的最小花费
 *
 * @author rsm
 * @date 2023/11/24 16:58
 */
public class SplitCold {
    public static void main(String[] args) throws IOException {
        //System.out.println(lessMoney(new int[]{3, 9, 5, 2, 4, 4}));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = bf.readLine()) != null) {
            String[] input = str.split(" ");
            int[] nums = convertToInt(input);
            System.out.println(lessMoney(nums));
        }
    }

    private static int[] convertToInt(String[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }
        int[] res = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            res[i] = Integer.parseInt(input[i]);
        }
        return res;
    }

    private static long lessMoney(int[] nums) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add((long)nums[i]);
        }
        long sum = 0;
        while (pq.size() > 1) {
            long temp = pq.poll() + pq.poll();
            sum += temp;
            pq.add(temp);
        }
        return sum;
    }

    public static int lessMoney2(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pq.size() > 1){
            cur = pq.poll() + pq.poll();
            sum += cur;
            pq.add(cur);
        }
        return sum;
    }
}
