package com.ryu2u.exercise.YEAR_2023.month8;

import org.junit.Test;

import javax.lang.model.type.IntersectionType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-03 13:19:19
 */
public class Test_20230803 {
    @Test
    public void test() {
        // ch39
        // ch38
        System.out.println(countAndSay(4));
        // ch31
        int[] nums = {1, 4, 3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void nextPermutation(int[] nums) {

        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        int j = nums.length - 1;
        int k = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        if (i >= 0) {
            while (k > 0 && nums[k] <= nums[i]) {
                k--;
            }
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
        }
        k = nums.length - 1;
        while (j < k) {
            int temp = nums[k];
            nums[k] = nums[j];
            nums[j] = temp;
            j++;
            k--;
        }

    }

    public String countAndSay(int n) {
        String pre = "1";
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pre.length(); j++) {
                char c = pre.charAt(j);
                while (j < pre.length() - 1 && pre.charAt(j + 1) == c) {
                    j++;
                    count++;
                }
                sb.append(count).append(c);
                count = 1;
            }
            pre = sb.toString();
        }
        return pre;
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, candidates, target, 0);
        return list;
    }

    List<Integer> temp = new ArrayList<>();
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
            temp.add(arr[i]);
            sum += arr[i];
            backTracking(list, arr, target, i);
            sum -= arr[i];
            temp.remove(temp.size() - 1);
        }

    }


}