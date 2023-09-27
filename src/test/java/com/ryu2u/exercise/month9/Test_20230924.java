package com.ryu2u.exercise.month9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-25 08:50:07
 */
public class Test_20230924 {
    @Test
    public void test() {
        // ch16
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
        // ch17
        // ch63
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] pb = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                pb[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                pb[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    pb[i][j] = pb[i - 1][j] + pb[i][j - 1];
                }
            }
        }
        return pb[m - 1][n - 1];
    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        backTracking(list, letters, digits, 0);
        return list;
    }

    StringBuilder sb = new StringBuilder();

    private void backTracking(List<String> list, String[] letters, String digits, int count) {
        if (count == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = letters[digits.charAt(count) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(list, letters, digits, count + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (target == sum) {
                    return target;
                } else if (target < sum) {
                    r--;
                } else {
                    l++;
                }
                if (Math.abs(target - min) > Math.abs(target - sum)) {
                    min = sum;
                }
            }
        }
        return min;
    }

}