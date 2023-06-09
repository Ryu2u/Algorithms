package com.ryu2u.easy;

import java.util.HashMap;

/**
 *罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 *
 * 示例 1:
 *
 * 输入: s = "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: s = "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: s = "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/9 15:38
 */
public class 罗马数字转整数 {
    private static final HashMap<Character,Integer> roman = new HashMap<Character,Integer>(){
        {
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }
    };

    /**
     * 自己写的
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(i < s.length() -1 && c == 'I' && (s.charAt(i+1) == 'V' ||
                    s.charAt(i + 1) == 'X')){
                Integer x = roman.get(s.charAt(i));
                Integer y = roman.get(s.charAt(i+1));
                num+= y - x;
                i++;
            }else if(i < s.length() -1 && c == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i + 1) == 'C')){
                Integer x = roman.get(s.charAt(i));
                Integer y = roman.get(s.charAt(i+1));
                num+= y - x;
                i++;
            }else if(i < s.length() -1 && c == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i + 1) == 'M')){
                Integer x = roman.get(s.charAt(i));
                Integer y = roman.get(s.charAt(i+1));
                num+= y - x;
                i++;
            }else{
                Integer x = roman.get(s.charAt(i));
                num += x;
            }
        }
        return num;
    }

    /**
     * 最优解
     * @param s
     * @return
     */
    public static int romanToInt2(String s){
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = roman.get(s.charAt(i));
            if(i< s.length() -1 && val < roman.get(s.charAt(i + 1)) ){
                num -= val;
            }else{
                num += val;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "LVIII";
//        String s = "MCMXCIV";
//        String s = "III";
        int i = romanToInt(s);
        System.out.println(i);
    }
}
