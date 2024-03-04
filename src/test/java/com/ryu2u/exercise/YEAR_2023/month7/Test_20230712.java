package com.ryu2u.exercise.YEAR_2023.month7;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Administrator
 * @Description:
 * @date 2023/7/13 10:04
 */
public class Test_20230712 {


    @Test
    public void test() {
        // ch724
        System.out.println(pivotIndex(new int[]{2, -1, 1}));
        // ch26
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        // ch14
        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"a","b"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        int n = 0;
        String str = strs[0];
        while (n < str.length()) {
            char c = str.charAt(n);
            for (int i = 0; i < len; i++) {
                String s = strs[i];
                if (s.length() <= n) {
                    return s;
                } else if (s.charAt(n) != c) {
                    return s.substring(0, n);
                }
            }
            n++;
        }
        return str;
    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            right = sum - (left + nums[i]);
            if (left == right) {
                return i;
            } else {
                left += nums[i];
            }
        }
        return -1;
    }


}
