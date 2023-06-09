package com.ryu2u.easy;

/**
 *编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/9 16:03
 */
public class 最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        int n = strs.length;
        if (n <= 0){
            return "";
        }
        while (true){
            if (strs[0].length() -1 < index){
                return strs[0].substring(0,index);
            }
            char c = strs[0].charAt(index);
            for (int i = 1; i < n; i++) {
                int len = strs[i].length();
                if (len -1 < index || strs[i].charAt(index) != c){
                    return strs[0].substring(0,index);
                }
            }
            index++;
        }
    }

    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"",""};
        String[] strs = {"ab","a"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

}
