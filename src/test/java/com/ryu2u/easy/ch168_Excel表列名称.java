package com.ryu2u.easy;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * <p>
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 * <p>
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 * <p>
 * 示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 * <p>
 * 示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * <p>
 * 提示：
 * 1 <= columnNumber <= 231 - 1
 *
 * @author Administrator
 * @Description:
 * @date 2023-06-30 13:28:51
 */
public class ch168_Excel表列名称 {
    public static String convertToTitle(int columnNumber) {
        int n = columnNumber;
        if (n <= 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0 ){
            n--;
            sb.append((char)( n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
        char c = 'A' + 24;
        System.out.println(c);
    }

}