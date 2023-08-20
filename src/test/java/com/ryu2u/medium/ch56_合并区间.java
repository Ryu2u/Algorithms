package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/20 9:46
 */
public class ch56_合并区间 {
    @Test
    public void test() {
        int[][] arr = {{1, 2, 3}, {2, 1, 4}};
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

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
