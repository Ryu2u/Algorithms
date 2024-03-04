package com.ryu2u.exercise.YEAR_2023.month8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-08 16:55:52
 */
public class Test_20230808 {
    @Test
    public void test() {
        // ch46
        // ch47
        // ch300

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracking(list, nums, used);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int[] arr, boolean[] used) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                temp.add(arr[i]);
                used[i] = true;
                backTracking(list, arr, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking2(list,nums,used);
        return list;
    }

    List<Integer> temp2 = new ArrayList<>();

    private void backTracking2(List<List<Integer>> list, int[] arr, boolean[] used) {
        if (temp2.size() == arr.length) {
            list.add(new ArrayList<>(temp2));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                temp2.add(arr[i]);
                used[i] = true;
                backTracking2(list, arr, used);
                used[i] = false;
                temp2.remove(temp2.size() - 1);
            }
        }
    }

    public int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    f[i] = Math.max(f[i],f[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }

}