package com.ryu2u.easy;

import org.junit.Test;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * <p>
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @author Ryu2u
 * @Description:
 * @date 2023/7/30 13:33
 */
public class ch28_找出字符串中第一个匹配项的下标 {

    @Test
    public void test() {
        System.out.println(strStr("aaabbacaaabaaabbab", "aaabbab"));

    }


    /**
     * KMP算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        // PMT中的值是字符串的前缀集合与后缀集合的交集中最长元素的长度。
        // char:  a b a b a b c a
        // index: 0 1 2 3 4 5 6 7
        // value: 0 0 1 2 3 4 0 1
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = next[j - 1];
            }
            if (p[i] == p[j]) {
                j++;
            }
            next[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = next[j - 1];
            }
            if (s[i] == p[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;

    }

    /**
     * 使用动态规划
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[][] dp = new int[n][256];
        dp[0][p[0]] = 1;
        int x = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 256; j++) {
                dp[i][j] = dp[x][j];
            }
            dp[i][p[i]] = i + 1;
            x = dp[x][p[i]];
        }
        for (int i = 0, j = 0; i < m; i++) {
            j = dp[j][s[i]];
            if (j == n) {
                return i - n + 1;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int n = needle.length();
        for (int i = 0; i < haystack.length() - n + 1; i++) {
            String str = haystack.substring(i, i + n);
            if (needle.equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
