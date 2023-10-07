package com.ryu2u.exercise.month10;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-07 10:06:51
 */
public class Test_20231007 {
    @Test
    public void test() {
        // ch78
        System.out.println(subsets(new int[]{1, 2, 3}));
        // ch31
        int[] nums = {2, 6, 3, 5, 4, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        // ch40
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        // ch89
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(head | list.get(j));
            }
            head <<= 1;
        }
        return list;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(list, candidates, 0, target);
        return list;
    }

    List<Integer> temp = new ArrayList<>();
    int sum = 0;

    private void backTracking(List<List<Integer>> list, int[] arr, int index, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            temp.add(arr[i]);
            sum += arr[i];
            backTracking(list, arr, i + 1, target);
            temp.remove(temp.size() - 1);
            sum -= arr[i];
        }


    }


    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int x = nums.length - 1;
        int y = x - 1;
        int k = x;
        while (y >= 0 && nums[y] >= nums[x]) {
            y--;
            x--;
        }
        if (y >= 0) {
            while (k >= 0 && nums[y] >= nums[k]) {
                k--;
            }
            int temp = nums[y];
            nums[y] = nums[k];
            nums[k] = temp;
        }
        int n = nums.length - 1;
        while (x < n) {
            int temp = nums[x];
            nums[x] = nums[n];
            nums[n] = temp;
            n--;
            x++;
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(list, nums, 0);
        return list;
    }


    private void backTracking(List<List<Integer>> list, int[] arr, int index) {
        list.add(new ArrayList<>(temp));
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            backTracking(list, arr, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


}