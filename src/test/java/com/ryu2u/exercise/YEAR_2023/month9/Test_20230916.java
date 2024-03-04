package com.ryu2u.exercise.YEAR_2023.month9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-15 13:16:30
 */
public class Test_20230916 {
    @Test
    public void test() {
        // ch46

        // ch300
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
        // ch22

    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTracking(list, "", n, n);
        return list;
    }

    private void backTracking(List<String> list, String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left == right) {
            backTracking(list, str + "(", left - 1, right);
        } else {
            if (left > 0) {
                backTracking(list, str + "(", left - 1, right);
            }
            backTracking(list, str + ")", left, right - 1);
        }
    }

    public int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        Arrays.fill(f, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(f));
        int res = 0;
        for (int i = 0; i < f.length; i++) {
            res = Math.max(res, f[i]);
        }
        return res;
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(list, nums, used);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                backTracking(list, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }


}