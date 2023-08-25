package com.ryu2u.exercise.month8;

import org.junit.Test;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-25 08:52:36
 */
public class Test_20230825 {
    @Test
    public void test() {
        // ch67
        System.out.println(addBinary("111", "11"));
        // ch344
        // ch219

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                int y = nums[j];
                if (x == y) {
                    return true;
                }
            }
        }
        return false;
    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public String addBinary(String a, String b) {
        int l = a.length() - 1;
        int r = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l >= 0 || r >= 0) {
            int nl = l >= 0 ? a.charAt(l) - '0' : 0;
            int nr = r >= 0 ? b.charAt(r) - '0' : 0;
            int sum = nl + nr + carry;
            System.out.println(sum);
            carry = sum / 2;
            sum %= 2;
            System.out.println(sum);
            sb.append(sum);
            l--;
            r--;
        }
        if (carry > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }


}