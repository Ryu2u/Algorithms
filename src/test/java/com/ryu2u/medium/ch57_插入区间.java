package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * <p>
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * <p>
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * <p>
 * 提示：
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/20 10:54
 */
public class ch57_插入区间 {
    @Test
    public void test() {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        arr[arr.length-1][0] = newInterval[0];
        arr[arr.length-1][1] = newInterval[1];
        return merge(arr);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int len = intervals.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (list.size() >= 2 && l <= list.get(list.size() - 1)) {
                if (r > list.get(list.size() - 1)) {
                    list.set(list.size() - 1, r);
                }
            } else {
                list.add(l);
                list.add(r);
            }
        }
        int[][] arr = new int[list.size() / 2][2];
        int x = 0;
        int y = 1;
        for (int i = 0; i < list.size() / 2; i++) {
            arr[i][0] = list.get(x);
            arr[i][1] = list.get(y);
            x += 2;
            y += 2;
        }
        return arr;
    }

}
