package com.ryu2u.easy;

import java.util.Arrays;

/**
 *给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 *
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * @author Administrator
 * @Description:
 * @date 2023/6/9 15:17
 */
public class 回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome2(921129));
    }

    /**
     * 自己写的
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() -1; i >= 0 ; i--) {
            sb.append(str.charAt(i));
        }
        if(str.equals(sb.toString())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 时间复杂度O(log n)
     * 空间复杂度O(log n)
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        // 小于0 或者为10 的整数倍则一定不为回文数
        if(x < 0 || (x != 0 && x %10 == 0)){
            return false;
        }
        int y = 0;
        while (x > y){
            int temp = x % 10;
            y = y * 10 + temp;
            x /= 10;
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
        // 当长度为奇数时, 需要除以10 去除处于中位的数字
        return x == y || x == y / 10;
    }


}
