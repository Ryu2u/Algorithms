package com.ryu2u.medium;

import org.junit.Test;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * <p>
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 提示：
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n 是一个整数
 * 要么 x 不为零，要么 n > 0 。
 * -104 <= xn <= 104*
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/14 16:33
 */
public class ch50_Pow_x_n {
    @Test
    public void test() {
        double x = 2.1;
        int n = 3;
        System.out.println(myPow(x, n));
        System.out.println(Math.pow(x, n));
    }


    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ?quickMul(x,N) : 1/quickMul(x,-N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1;
        }
        double v = quickMul(x, N / 2);
        return N % 2 == 0 ? v * v : v * v * x;
    }

}
