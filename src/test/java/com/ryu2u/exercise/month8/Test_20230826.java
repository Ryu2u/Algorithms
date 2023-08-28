package com.ryu2u.exercise.month8;

import org.junit.Test;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-27 13:26:40
 */
public class Test_20230826 {
    @Test
    public void test() {
        // ch69
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 0;
        int r = x;
        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((double) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }


}