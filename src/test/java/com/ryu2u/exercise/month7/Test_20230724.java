package com.ryu2u.exercise.month7;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-24 10:30:00
 */
public class Test_20230724 {
    @Test
    public void test() {
        // ch3
        String str = "b";
        System.out.println(lengthOfLongestSubstring(str));
        // ch7
        // ch8
        System.out.println(myAtoi("2147483646"));
        System.out.println(reverse(123));
    }

    public int reverse(int x) {
        int sum = 0;
        while(x != 0){
            int mod = x % 10;
            if (sum > Integer.MAX_VALUE/10 || sum < Integer.MIN_VALUE/10){
                return 0;
            }
            sum = sum * 10 + mod;
            x /= 10;
        }
        return sum;
    }

    public int myAtoi(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }
        char c = s.charAt(0);
        int sum = 0;
        int sign = 1;
        if ('-' == c) {
            sign = -1;
        } else if ('+' == c) {
            sign = 1;
        }else if (Character.isDigit(c)) {
            sum = Integer.parseInt(String.valueOf(c));
        }else{
            return 0;
        }
        for (int i = 1; i < s.length(); i++) {
            char cc = s.charAt(i);
            if (Character.isDigit(cc)){
                int num = Integer.parseInt(String.valueOf(cc));
                if (sum > (Integer.MAX_VALUE - num)/10){
                    if (sign==-1){
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }
                }
                sum = sum * 10 + num;
            }else{
                break;
            }
        }
        return sum * sign;

    }


    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            int len = i - left + 1;
            max = Math.max(len, max);
            map.put(c, i);
        }
        return max;
    }


}