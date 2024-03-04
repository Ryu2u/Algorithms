package com.ryu2u.exercise.YEAR_2023.month10;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;

import java.util.*;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-16 15:00:45
 */
public class Test_20231016 {
    @Test
    public void test() {
        // ch219
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        // ch121
        // ch40
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
            sum -= arr[i];
            temp.remove(temp.size() - 1);
        }
    }


    public int maxProfit(int[] prices) {
        int[] f = new int[prices.length];
        int min = prices[0];
        f[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            f[i] = Math.max(f[i - 1], prices[i] - min);
        }
        return f[prices.length - 1];
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int j = 0; j < nums.length; j++) {
            if (j > k) {
                set.remove(nums[j - k - 1]);
            }
            if (set.contains(nums[j])) {
                return true;
            } else {
                set.add(nums[j]);
            }
        }
        return false;
    }


}