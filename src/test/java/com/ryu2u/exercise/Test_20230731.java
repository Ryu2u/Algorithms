package com.ryu2u.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-31 15:31:51
 */
public class Test_20230731 {
    @Test
    public void test() {
        //ch28

        // ch18

        // ch22
        List<String> strings = generateParenthesis(8);
        System.out.println(strings.size());
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTracking(list,"",n,n);
        return list;
    }

    private void backTracking(List<String> list, String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left == right) {
            backTracking(list, str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                backTracking(list, str + "(", left - 1, right);
            }
            backTracking(list, str + ")", left, right - 1);
        }

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

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = next[j - 1];
            }
            if (p[i] == p[j]) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = next[j - 1];
            }
            if (s[i] == p[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;

    }


}