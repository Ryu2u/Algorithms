package com.ryu2u.exercise.month8;

import org.junit.Test;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-10 16:43:42
 */
public class Test_20230810 {
    @Test
    public void test() {
        // ch300
        // ch12
        System.out.println(intToRoman(1994));

    }

    public String intToRoman(int num) {
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] letters = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            for (int i = values.length - 1; i >= 0; i--) {
                if (num >= values[i]) {
                    num -= values[i];
                    sb.append(letters[i]);
                    break;
                }
            }
        }
        return sb.toString();

    }

    public int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, f[i]);
        }
        return ans;

    }


}