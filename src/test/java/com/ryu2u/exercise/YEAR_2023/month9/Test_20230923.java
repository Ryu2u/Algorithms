package com.ryu2u.exercise.YEAR_2023.month9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-25 08:49:29
 */
public class Test_20230923 {
    @Test
    public void test() {
        // ch121
        // ch77
        System.out.println(combine(4, 2));
        // ch78
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, nums, 0);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int[] nums, int index) {
        list.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backTracking(list, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();

        backTracking(list, n, k, 1);

        return list;
    }


    private void backTracking(List<List<Integer>> list, int n, int k, int index) {
        if (temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            backTracking(list, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public int maxProfit(int[] prices) {
        int[] pb = new int[prices.length];
        pb[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            pb[i] = Math.max(pb[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return pb[prices.length - 1];
    }


}