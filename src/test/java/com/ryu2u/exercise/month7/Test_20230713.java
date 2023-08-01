package com.ryu2u.exercise.month7;

import org.junit.Test;

/**
 * @author Administrator
 * @Description:
 * @date 2023/7/13 10:04
 */
public class Test_20230713 {

    @Test
    public void test(){
        // ch70
        System.out.println(climbStairs(45));
        // ch136
        int[] nums = {1,1,2,2,3};
        System.out.println(singleNumber(nums));

        // ch
    }
    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static int climbStairs(int n) {
        int pre = 0;
        int cur = 0;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            pre = cur;
            cur = res;
            res = pre + cur;
        }
        return res;
    }



}
