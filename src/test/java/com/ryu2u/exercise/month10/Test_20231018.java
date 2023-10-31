package com.ryu2u.exercise.month10;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.entity.ListNode;

import java.math.BigDecimal;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-19 10:29:49
 */
public class Test_20231018 {
    @Test
    public void test() {
        // ch26
        // ch43
        String s1 = "123";
        String s2 = "456";
        BigDecimal bd1 = new BigDecimal(s1);
        BigDecimal bd2 = new BigDecimal(s2);
        System.out.println(bd1.multiply(bd2));
        System.out.println(multiply(s1, s2));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int num = num2.charAt(i) - '0';
            StringBuilder str = stringMultiply(num1, num);
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                str.append(0);
            }
            sb = stringAdd(sb.toString(), str.toString());
        }
        return sb.toString();
    }

    private StringBuilder stringMultiply(String str, int num) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int n = str.charAt(i) - '0';
            int multiply = n * num + carry;
            carry = 0;
            if (multiply > 9) {
                carry = multiply / 10;
                multiply %= 10;
            }
            sb.append(multiply);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse();
    }

    private StringBuilder stringAdd(String s1, String s2) {
        int carry = 0;
        int l = s1.length() - 1;
        int r = s2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (l >= 0 || r >= 0) {
            int nl = l >= 0 ? s1.charAt(l) - '0' : 0;
            int nr = r >= 0 ? s2.charAt(r) - '0' : 0;
            int sum = nl + nr + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
                sum %= 10;
            }
            sb.append(sum);
            if (l >= 0) {
                l--;
            }
            if (r >= 0) {
                r--;
            }
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse();
    }


    public int removeDuplicates(int[] nums) {
        int i = 1;
        int pre = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != pre) {
                nums[i] = nums[j];
                pre = nums[j];
                i++;
            }
        }
        return i;
    }


}