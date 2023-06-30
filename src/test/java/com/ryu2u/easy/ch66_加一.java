package com.ryu2u.easy;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/16 10:40
 */
public class ch66_加一 {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len-1;
        while (i >= 0){
            int num = digits[i];
            if(num == 9){
                digits[i] = 0;
                i--;
            }else{
                digits[i] = num + 1;
                return digits;
            }
        }
        int[] arr = new int[len + 1];
        arr[0] = 1;
        return arr;
    }

    public static void main(String[] args) {
        int[] digits = {4,8,8,9};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));

    }
}
