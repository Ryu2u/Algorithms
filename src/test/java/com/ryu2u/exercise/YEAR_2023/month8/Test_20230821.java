package com.ryu2u.exercise.YEAR_2023.month8;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-21 08:49:00
 */
public class Test_20230821 {
    @Test
    public void test() {
        // ch169
        // ch43
        String n1 = "9651241";
        String n2 = "91245123";
        BigDecimal d1 = new BigDecimal(n1);
        BigDecimal d2 = new BigDecimal(n2);
        System.out.println(d1.add(d2));
        System.out.println(stringAdd(n1, n2));
        System.out.println(multiply(n1, n2));
        System.out.println(d1.multiply(d2));
        // ch110
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int x = num2.charAt(i) - '0';
            StringBuilder temp = new StringBuilder();
            int carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int y = num1.charAt(j) - '0';
                int sum = x * y + carry;
                carry = 0;
                if (sum >= 10) {
                    carry = sum / 10;
                    sum %= 10;
                }
                temp.append(sum);
            }
            if (carry != 0) {
                temp.append(carry);
            }
            temp.reverse();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            res = stringAdd(temp.toString(), res);
        }
        return res;
    }

    public String stringAdd(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            sb.append(sum);
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }


    public int majorityElement(int[] nums) {
        int key = nums[0];
        int time = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == key) {
                time++;
            } else {
                time--;
            }
            if (time < 0) {
                key = nums[i];
                time = 0;
            }
        }
        return key;
    }


}