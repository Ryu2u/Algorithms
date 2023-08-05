package com.ryu2u.exercise.month8;

import org.junit.Test;

import java.math.BigDecimal;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-05 10:21:28
 */
public class Test_20230805 {
    @Test
    public void test() {
        // ch43
        // ch
        String s1 = "1231512312";
        String s2 = "45609879012";
        System.out.println(stringAdd(s1, s2));
        BigDecimal d1 = new BigDecimal(s1);
        BigDecimal d2 = new BigDecimal(s2);
        System.out.println(d1.add(d2));
        System.out.println(multiply(s1, s2));
        System.out.println(d1.multiply(d2));
        // ch11
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        //ch29

        // ch

    }


    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int half = Integer.MIN_VALUE >> 1;
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
            int c = -1;
            while (mod >= half && c >= half && mod >= dividend - mod) {
                mod <<= 1;
                c <<= 1;
            }
            dividend -= mod;
            ans += c;
        }
        return flag ? ans : -ans;
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int x = r - l;
            int y = Math.min(height[l], height[r]);
            int area = x * y;
            max = Math.max(area, max);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String str = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            int n2 = num2.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(j) - '0';
                int sum = n2 * n1 + carry;
                carry = 0;
                if (sum >= 10) {
                    carry = sum / 10;
                    sum %= 10;
                }
                sb.append(sum);
            }
            if (carry > 0) {
                sb.append(carry);
            }
            sb.reverse();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append("0");
            }
            str = stringAdd(str, sb.toString());
        }
        return str;
    }

    private String stringAdd(String s1, String s2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int l = s1.length() - 1;
        int r = s2.length() - 1;
        while (l >= 0 || r >= 0) {
            int n1 = l >= 0 ? s1.charAt(l) - '0' : 0;
            int n2 = r >= 0 ? s2.charAt(r) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum %= 10;
            }
            sb.append(sum);
            l--;
            r--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }


}