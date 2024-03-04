package com.ryu2u.exercise.YEAR_2023.month10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-13 15:08:24
 */
public class Test_20231012 {
    @Test
    public void test() {
        // ch97

        // ch131

        // ch56
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        list.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (l <= list.get(list.size() - 1)[1]) {
                list.get(list.size() - 1)[0] = Math.min(l, list.get(list.size() - 1)[0]);
                list.get(list.size() - 1)[1] = Math.max(r, list.get(list.size() - 1)[1]);
            } else {
                list.add(new int[]{l, r});
            }
        }

        int[][] arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;

    }

    public int cuttingBamboo(int bamboo_len) {
        if (bamboo_len <= 3) {
            return bamboo_len - 1;
        }
        int a = bamboo_len / 3;
        int m = bamboo_len % 3;
        if (m == 2) {
            return (int) Math.pow(3, a) * 2;
        } else if (m == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        } else {
            return (int) Math.pow(3, a);
        }


    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        char[] cs3 = s3.toCharArray();
        boolean[][] dp = new boolean[cs1.length + 1][cs2.length + 1];
        dp[0][0] = true;

        for (int i = 1; i < cs1.length + 1; i++) {
            dp[i][0] = dp[i - 1][0] && cs1[i - 1] == cs3[i - 1];
        }

        for (int i = 1; i < cs2.length + 1; i++) {
            dp[0][i] = dp[0][i - 1] && cs2[i - 1] == cs3[i - 1];
        }

        for (int i = 1; i < cs1.length + 1; i++) {
            for (int j = 1; j < cs2.length + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && cs1[i - 1] == cs3[i + j - 1]) || (dp[i][j - 1] && cs2[j - 1] == cs3[i + j - 1]);
            }
        }

        return dp[cs1.length][cs2.length];
    }


}
