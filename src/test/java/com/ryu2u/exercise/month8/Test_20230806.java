package com.ryu2u.exercise.month8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-06 12:38:59
 */
public class Test_20230806 {
    @Test
    public void test() {
        // ch45
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jump(nums));
        // ch18
        // ch5
        System.out.println(longestPalindrome("bb"));

    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = true;
            }
        }
        int begin = 0;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                int l = i - j + 1;
                if (l > s.length()) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[j][i] = false;
                } else if (l <= 3) {
                    dp[j][i] = true;
                } else {
                    dp[j][i] = dp[j + 1][i - 1];
                }
                if (dp[j][i] && l > max) {
                    max = l;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + max);

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }
                int l = j + 1;
                int r = len - 1;
                while (l < r) {
                    long sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }

        }
        return list;
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int ans = 0;
        int max = 0;
        for (int i = 0, j = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == j) {
                j = max;
                ans++;
            }
        }
        return ans;

    }

}