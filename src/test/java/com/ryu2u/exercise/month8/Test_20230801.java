package com.ryu2u.exercise.month8;

import com.ryu2u.entity.ListNode;
import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;
import org.junit.Test;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-01 11:06:27
 */
public class Test_20230801 {
    @Test
    public void test() {
        // ch29
        // ch24
        // ch12
        System.out.println(intToRoman(1994));

    }

    public String intToRoman(int num) {
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] letters = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (int i = values.length-1; i >= 0; i--) {
                if (num >= values[i]) {
                    num -= values[i];
                    sb.append(letters[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        head.next = swapPairs(head.next);
        return next;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int limit = Integer.MIN_VALUE >> 1;
        boolean flag = ((dividend >>> 31) ^ (divisor >>> 31)) == 1;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int ans = 0;
        while (dividend <= divisor) {
            int mod = divisor;
            int count = -1;
            while (mod >= limit && count >= limit && mod >= dividend - mod) {
                mod <<= 1;
                count <<= 1;
            }
            dividend -= mod;
            ans += count;
        }
        return flag ? ans : -ans;
    }


}