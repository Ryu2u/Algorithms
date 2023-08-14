package com.ryu2u.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 *给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/14 17:26
 */
public class ch53_最大子数组和 {
    @Test
    public void test() {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));

    }

    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(nums[i], f[i - 1] + nums[i]);
        }
        int ans = f[0];
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }

}
