package com.ryu2u.easy;

import org.junit.Test;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * <p>
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * <p>
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * <p>
 * <p>
 * 进阶：
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 *
 * @author Administrator
 * @Description:
 * @date 2024/3/5 10:38
 */
public class ch844_比较含退格的字符串 {

    @Test
    public void test() {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompare(s, t));
    }

    public boolean backspaceCompare(String s, String t) {
        s = getRes(s);
        t = getRes(t);
        return s.equals(t);
    }

    public String getRes(String s) {
        int l = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '#') {
                if (l > 0){
                    l--;
                }
            } else {
                cs[l] = c;
                l++;
            }
        }
        String str = "";
        for (int i = 0; i < l; i++) {
            str += cs[i];
        }
        System.out.println(str);
        return str;
    }

}
