package com.ryu2u.easy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * <p>
 * 提示：
 * 1 <= n <= 231 - 1
 *
 * @author Administrator
 * @Description:
 * @date 2023-06-30 13:28:51
 */
public class ch202_快乐数 {

    @Test
    public void test() {
        System.out.println(isHappy(7));

    }

    /**
     * 当n大于三位数的话每计算一步都会减少一位，所以不会存在无穷大的情况
     * 所以一个数要么是快乐数，要么会无限在某个循环中一个循环
     * 使用hash表保存已经计算过的值，如果当前值已经存在过，那么当前数则在循环中，就不是快乐数
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
            System.out.print("next: ");
            System.out.println(n);
        }
        return n == 1;
    }

    /**
     * 计算下一位数
     * @param n
     * @return
     */
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int mod = n % 10;
            sum += mod * mod;
            n /= 10;
        }
        return sum;
    }

}