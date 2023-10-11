package com.ryu2u.exercise.month10;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-10 19:28:24
 */
public class Test_20231011 {
    @Test
    public void test() {
        // ch97
        // ch11

        // ch15
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (temp == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (temp > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return list;
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int x = height[l];
            int y = height[r];
            int area = Math.min(x, y) * (r - l);
            max = Math.max(area, max);
            if (x >= y) {
                r--;
            } else {
                l++;
            }
        }
        return max;


    }

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        if (c1.length + c2.length != c3.length) {
            return false;
        }
        boolean[][] dp = new boolean[c1.length + 1][c2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < c1.length + 1; i++) {
            dp[i][0] = dp[i - 1][0] && c1[i - 1] == c3[i - 1];
        }
        for (int i = 1; i < c2.length + 1; i++) {
            dp[0][i] = dp[0][i - 1] && c2[i - 1] == c3[i - 1];
        }
        for (int i = 1; i < c1.length + 1; i++) {
            for (int j = 1; j < c2.length + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && c1[i - 1] == c3[i + j - 1]) || (dp[i][j - 1] && c2[j - 1] == c3[i + j - 1]);
            }
        }
        return dp[c1.length][c2.length];

    }


}