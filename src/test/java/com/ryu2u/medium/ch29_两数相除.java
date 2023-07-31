package com.ryu2u.medium;

import org.junit.Test;

/**
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
 * <p>
 * <p>
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 * <p>
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
 * <p>
 * <p>
 * 提示：
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/31 16:18
 */
public class ch29_两数相除 {

    @Test
    public void test() {
        System.out.println(divide(Integer.MIN_VALUE >> 1, -3));

    }


    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
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
            while (count >= Integer.MIN_VALUE >> 1 && mod >= Integer.MIN_VALUE >> 1 && mod >= dividend - mod) {
                System.out.println(mod);
                mod <<= 1;
                count <<= 1;
                System.out.println("====================");
            }
            dividend -= mod;
            ans += count;
            System.out.println(dividend);
            System.out.println("----------------------");
        }
        return flag ? ans : -ans;
    }


}
