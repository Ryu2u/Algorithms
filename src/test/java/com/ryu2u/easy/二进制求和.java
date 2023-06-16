package com.ryu2u.easy;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 * <p>
 * 示例 2：
 * 输入：a = "1011", b = "1011"
 * 输出："10100"
 * <p>
 * 提示：
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/16 16:02
 */
public class 二进制求和 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            carry += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sb.insert(0,(char)(carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0){
            sb.insert(0,'1');
        }
        return sb.toString();

    }

    public static void main(String[] args) {
//        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("0", "0"));


    }

}
