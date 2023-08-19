package com.ryu2u.exercise.month8;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-19 08:47:57
 */
public class Test_20230817 {
    @Test
    public void test() {
        // ch55
        // ch108
        // ch40

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking40(list, candidates, target, 0);
        return list;
    }

    List<Integer> temp = new ArrayList<>();
    int sum = 0;

    public void backTracking40(List<List<Integer>> list, int[] arr, int target, int index) {
        if (sum > target){
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
            backTracking40(list, arr, target, i + 1);
            temp.remove(temp.size() - 1);
            sum -= arr[i];
        }

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode node = new TreeNode();
        int mid = (l + r) / 2;
        node.val = nums[mid];
        node.left = helper(nums, l, mid - 1);
        node.right = helper(nums, mid + 1, r);
        return node;
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int i = 0;
        while (true) {
            int n = nums[i];
            if (i + n >= nums.length - 1) {
                return true;
            }
            int max = 0;
            int k = i;
            for (int j = i + 1; j <= i + n; j++) {
                if (max <= j + nums[j]) {
                    max = j + nums[j];
                    k = j;
                }
            }
            if (nums[k] == 0) {
                return false;
            }
            i = k;
        }

    }


}