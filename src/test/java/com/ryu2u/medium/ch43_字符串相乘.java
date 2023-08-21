package com.ryu2u.medium;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 提示：
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/4 11:15
 */
public class ch43_字符串相乘 {
    @Test
    public void test() {
        String n1 = "9124123";
        String n2 = "9123123";
        System.out.println(multiply(n1, n2));
        BigDecimal d1 = new BigDecimal(n1);
        BigDecimal d2 = new BigDecimal(n2);
        System.out.println(d1.multiply(d2));

    }


    public String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String sb = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int n2 = num2.charAt(i) - '0';
            StringBuilder temp = new StringBuilder();
            int carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(j) - '0';
                int sum = n1 * n2 + carry;
                carry = 0;
                if (sum >= 10) {
                    carry = sum / 10;
                    sum %= 10;
                }
                temp.append(sum);
            }
            if (carry > 0) {
                temp.append(carry);
            }
            temp.reverse();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            sb = stringAdd(sb, temp.toString());
        }
        return sb;

    }

    private String stringAdd(String n1, String n2) {
        int carry = 0;
        int l = n1.length() - 1;
        int r = n2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (l >= 0 || r >= 0) {
            int nl = l >= 0 ? n1.charAt(l) - '0' : 0;
            int nr = r >= 0 ? n2.charAt(r) - '0' : 0;
            int sum = nl + nr + carry;
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
            sb.append(1);
        }
        return sb.reverse().toString();
    }


}
