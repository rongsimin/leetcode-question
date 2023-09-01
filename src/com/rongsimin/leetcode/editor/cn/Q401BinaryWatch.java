//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
// 
//
// 
// 例如，下面的二进制手表读取 "4:51" 。 
// 
//
// 
//
// 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。 
//
// 小时不会以零开头： 
//
// 
// 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 
// 
//
// 分钟必须由两位数组成，可能会以零开头： 
//
// 
// 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：turnedOn = 1
//输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// 
//
// 示例 2： 
//
// 
//输入：turnedOn = 9
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= turnedOn <= 10 
// 
//
// Related Topics位运算 | 回溯 
//
// 👍 416, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.rongsimin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 401.二进制手表
 *
 * @author rsm
 * @date 2023-08-31 10:41:14
 */
public class Q401BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new Q401BinaryWatch().new Solution();
        System.out.println(solution.readBinaryWatch(1));
        System.out.println(solution.readBinaryWatch(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> resList = new ArrayList<>();
            if (turnedOn >= 9) {
                return resList;
            }
            if (turnedOn == 0) {
                resList.add("0:00");
                return resList;
            }
            int[] nums = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
            dfs(turnedOn, 0, 0, 0, nums, resList);
            return resList;
        }

        private void dfs(int turnedOn, int hour, int minute, int start, int[] nums, List<String> resList) {
            if (turnedOn == 0) {
                String value = calTime(hour, minute);
                resList.add(value);
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (i < 4) {
                    // 当前选择的是小时
                    if (hour + nums[i] >= 12) {
                        continue;
                    }
                    hour += nums[i];
                    turnedOn--;
                    dfs(turnedOn, hour, minute, i + 1, nums, resList);
                    hour -= nums[i];
                    turnedOn++;
                } else {
                    // 当前选择的是分钟
                    if (minute + nums[i] >= 60) {
                        continue;
                    }
                    minute += nums[i];
                    turnedOn--;
                    dfs(turnedOn, hour, minute, i + 1, nums, resList);
                    minute -= nums[i];
                    turnedOn++;
                }
            }
        }

        private String calTime(int hour, int minute) {
            return minute < 10 ? hour + ":0" + minute : hour + ":" + minute;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}