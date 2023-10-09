package com.ryu2u.medium;

import org.junit.Test;


/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * 示例 1：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * <p>
 * 提示：
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * <p>
 * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?*
 *
 * @author Administrator
 * @Description:
 * @date 2023/10/9 13:42
 */
public class ch97_交错字符串 {
    @Test
    public void test() {

        String s1 = "db";
        String s2 = "b";
        String s3 = "cbb";
        System.out.println(isInterleave(s1, s2, s3));

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        char[] cs3 = s3.toCharArray();
        boolean[][] dp = new boolean[cs1.length + 1][cs2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= cs1.length; i++) {
            dp[i][0] = (dp[i - 1][0] && cs1[i - 1] == cs3[i - 1]);
        }
        for (int i = 1; i <= cs2.length; i++) {
            dp[0][i] = (dp[0][i - 1] && cs2[i - 1] == cs3[i - 1]);
        }
        for (int i = 1; i <= cs1.length; i++) {
            for (int j = 1; j <= cs2.length; j++) {
                dp[i][j] = (dp[i][j - 1] && cs2[j - 1] == cs3[i + j - 1]) || (dp[i - 1][j] && cs1[i - 1] == cs3[i + j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
