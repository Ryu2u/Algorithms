package com.ryu2u.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 *
 * @author Ryu2u
 * @Description:
 * @date 2024/4/9 13:16
 */
public class ch541_反转字符串II {

    @Test
    public void test() {

    }


    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i += (2 * k)) {
            int end = Math.min(len - 1, i + k - 1);
            reverse(cs, i, end);
        }
        return new String(cs);
    }


    private void reverse(char[] cs, int i, int j) {
        while (i < j) {
            char c = cs[i];
            cs[i] = cs[j];
            cs[j] = c;
            i++;
            j--;
        }
    }


}
