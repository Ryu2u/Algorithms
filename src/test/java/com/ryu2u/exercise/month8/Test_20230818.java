package com.ryu2u.exercise.month8;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-19 08:48:02
 */
public class Test_20230818 {
    @Test
    public void test() {
        // ch46
        // ch47
        // ch39

    }

    List<Integer> temp = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking39(list,candidates,target,0);
        return list;
    }

    private void backTracking39(List<List<Integer>> list, int[] arr, int target,int index) {
        if (sum > target){
            return;
        }
        if (sum == target){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            sum += arr[i];
            backTracking39(list, arr, target, i);
            temp.remove(temp.size()-1);
            sum -= arr[i];
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking47(list, nums, used);
        return list;
    }

    private void backTracking47(List<List<Integer>> list, int[] arr, boolean[] used) {
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
                backTracking47(list, arr, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking46(list, nums, used);
        return list;
    }

    private void backTracking46(List<List<Integer>> list, int[] arr, boolean[] used) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                temp.add(arr[i]);
                used[i] = true;
                backTracking46(list, arr, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }

    }


}