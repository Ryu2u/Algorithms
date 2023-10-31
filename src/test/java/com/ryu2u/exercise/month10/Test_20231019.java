package com.ryu2u.exercise.month10;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-19 10:29:54
 */
public class Test_20231019 {
    @Test
    public void test() {
        //  ch93
        //  ch28
        String str1 = "abababdaaaaaaaaabeaedeaabc";
        String str2 = "aaabbbaaabbbdddeee";
        System.out.println(strStr(str1, str2));
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();

        int[][] dp = new int[n][256];
        dp[0][b[0]] = 1;
        int x = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 256; j++) {
                dp[i][j] = dp[x][j];
            }
            dp[i][b[i]] = i + 1;
            x = dp[x][b[i]];
        }

        for (int i = 0, j = 0; i < m; i++) {
            j = dp[j][a[i]];
            if (j == n) {
                return i - n + 1;
            }
        }
        return -1;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return list;
        }
        backTracking(list, s, 0, 0);
        return list;
    }

    List<String> temp = new ArrayList<>();

    private void backTracking(List<String> list, String ip, int count, int i) {
        if (count == 4) {
            if (i != ip.length()) {
                return;
            }
            list.add(String.join(".", temp));
        }

        if (ip.length() - i < 4 - count || ip.length() - i > 3 * (4 - count)) {
            return;
        }
        for (int j = 0; j < 3; j++) {
            if (j + i > ip.length() - 1) {
                break;
            }
            String ipString = getIpString(ip, i, i + j);
            if ("".equals(ipString)) {
                continue;
            }
            temp.add(ipString);
            backTracking(list, ip, count + 1, i + j + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private String getIpString(String ip, int l, int r) {
        String str = ip.substring(l, r + 1);
        if (str.length() > 1 && str.startsWith("0")) {
            return "";
        }
        int num = Integer.parseInt(str);
        if (num < 0 || num > 255) {
            return "";
        }
        return str;
    }

}