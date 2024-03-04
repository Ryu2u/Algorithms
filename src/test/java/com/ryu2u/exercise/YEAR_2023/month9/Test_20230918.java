package com.ryu2u.exercise.YEAR_2023.month9;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-19 19:47:04
 */
public class Test_20230918 {
    @Test
    public void test() {
        // ch724
        int[] arr = {2, 1, -1};
        System.out.println(pivotIndex(arr));
        //
        //

    }

    public int pivotIndex(int[] nums) {

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 == (total - nums[i])) {
                return i;
            } else {
                sum += nums[i];
            }
        }
        return -1;
    }

    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (flag) {
            return true;
        }
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            targetSum -= root.val;
            if (targetSum == 0) {
                flag = true;
            }
        } else if (root.right == null) {
            hasPathSum(root.left, targetSum - root.val);
        } else if (root.left == null) {
            hasPathSum(root.right, targetSum - root.val);
        } else {
            hasPathSum(root.left, targetSum - root.val);
            hasPathSum(root.right, targetSum - root.val);
        }
        return flag;
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            int j = list.size() - 1;
            if (l <= list.get(j)[1]) {
                list.get(j)[0] = Math.min(l, list.get(j)[0]);
                list.get(j)[1] = Math.max(r, list.get(j)[1]);
            } else {
                list.add(new int[]{l, r});
            }
        }
        int[][] arr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}