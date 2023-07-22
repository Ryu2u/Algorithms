package com.ryu2u.medium;

import org.junit.Test;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * <p>
 * 提示：
 * -231 <= x <= 231 - 1
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/22 14:26
 */
public class ch7_整数反转 {
    @Test
    public void test() {
        System.out.println(reverse(-1230));
    }


    public int reverse(int x) {
        int num = 0;
        while (x != 0) {
            int n = x % 10;
            System.out.println(n);
            if (num > Integer.MAX_VALUE/10 || num < Integer.MIN_VALUE/10){
                return 0;
            }
            num = num * 10 + n;
            x /= 10;
        }
        return num;
    }

}
