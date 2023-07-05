package com.ryu2u.easy;

import org.junit.Test;

import javax.swing.text.AttributeSet;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 *
 * 示例 2：
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 *
 * 示例 3：
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 *
 * 提示：
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/30 11:30
 */
public class ch125_验证回文串 {
    /**
     * 注意: 只需要验证是否是回文，不是最长回文
     * 所以只需要遍历一次就够了
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c)){
                char lc = Character.toLowerCase(c);
                sb.append(lc);
            }
        }
        s = sb.toString();
        len = s.length();
        if(len <= 0){
            return true;
        }
        int l = 0;
        int r = len-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    @Test
    public void test01(){
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s2 = "0P";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
    }

    @Test
    public void test02(){
        char c = '0';
        System.out.println(Character.toLowerCase(c));
    }

}