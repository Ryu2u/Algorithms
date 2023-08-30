package com.ryu2u.easy;

import org.junit.Test;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * <p>
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * <p>
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * <p>
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：n = 4
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：n = 5
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * -231 <= n <= 231 - 1
 * 进阶：你能够不使用循环/递归解决此问题吗？
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/22 9:44
 */
public class ch231_2的幂 {
    @Test
    public void test() {

    }

    /**
     * 如果n是2的幂，那么他的二进制则为100000
     * 也就是说这个二进制为1后面都是零,如果有一个不为0那么他就不是2的幂
     * 而n-1则是将1变为了0，将1后面的0 变为了1
     * 这样，两个数 与运算(同为1才为1不同为0) 的结果若是0 则说明为2的幂
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        int c = 0;
        while (true) {
            double x = Math.pow(2, c++);
            if (x == n) {
                return true;
            } else if (x > n) {
                return false;
            }
        }

    }
}
