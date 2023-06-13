package com.ryu2u.medium;


/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * @author Ryu2u
 * @Description:
 * @date 2023/6/11 17:55
 */
public class 最长回文子串 {
    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean [][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        for (int r = 2;r <= len ; r++){
            for (int i = 0; i < len; i++) {
                // j-i+1 = r
                int j = r + i -1;
                // 当前字符串长度
                int l = j - i + 1;
                if (j > len-1){
                    //越界
                    break;
                }
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else if(l <= 3){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i + 1][j-1];
                }
                if(dp[i][j] && l > maxLen){
                    maxLen = l;
                    begin = i;
                }

            }
        }
        return s.substring(begin,begin + maxLen);

    }

    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
