package com.ryu2u.exercise.month9;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-25 08:52:00
 */
public class Test_20230925 {
    @Test
    public void test() {
        // ch40
        int[] arr = {10, 1, 2, 1, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(arr, target));
        // ch46
        // ch48

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }


    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(list, nums, used);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTrack(List<List<Integer>> list, int[] arr, boolean[] used) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                temp.add(arr[i]);
                used[i] = true;
                backTrack(list, arr, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, candidates, target, 0);
        return list;
    }

    int sum = 0;

    private void backTracking(List<List<Integer>> list, int[] arr, int target, int index) {
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
            backTracking(list, arr, target, i + 1);
            sum -= arr[i];
            temp.remove(temp.size() - 1);
        }
    }


}