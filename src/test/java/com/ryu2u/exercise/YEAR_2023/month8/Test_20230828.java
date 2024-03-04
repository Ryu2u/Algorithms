package com.ryu2u.exercise.YEAR_2023.month8;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-28 11:06:57
 */
public class Test_20230828 {
    @Test
    public void test() {
        // ch27
        int[] nums = {3, 3, 3, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
        int[] nums2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray(nums2);
        // ch53
        // ch104

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return maxDepth(root.right) + 1;
        } else if (root.right == null) {
            return maxDepth(root.left) + 1;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }


    }


    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(nums[i], f[i - 1] + nums[i]);
        }
        System.out.println(Arrays.toString(f));
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public int removeElement(int[] nums, int val) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[l] = nums[i];
                l++;
            }
        }
        return l;
    }


}