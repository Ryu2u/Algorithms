package com.ryu2u.exercise.month8;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-15 17:24:04
 */
public class Test_20230815 {
    @Test
    public void test() {
        // ch53
        // ch49

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }else if (head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        head.next = swapPairs(head.next);
        return next;
    }

    public double myPow(double x, int n) {
        long N = n;
        return n > 0?quickMul(x,N):1/quickMul(x,N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;

    }

    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(nums[i], f[i - 1] + nums[i]);
        }
        int ans = f[0];
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }


}