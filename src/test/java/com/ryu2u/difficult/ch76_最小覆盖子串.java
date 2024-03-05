package com.ryu2u.difficult;

import org.junit.Test;

import java.util.HashMap;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 提示：
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 *
 * @author Administrator
 * @Description:
 * @date 2024/3/5 19:08
 */
public class ch76_最小覆盖子串 {
    @Test
    public void test() {

    }


    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Integer num = map.getOrDefault(t.charAt(i), 0);
            num += 1;
            map.put(t.charAt(i), num);
        }
        int i = 0;
        int n = s.length();
        int count = t.length();
        String ans = "";
        int ans_len = s.length();
        for (int j = 0; j < n; j++) {
            if (!map.containsKey(s.charAt(j))) {
                continue;
            }
            Integer num = map.get(s.charAt(j));
            num -= 1;
            map.put(s.charAt(j), num);
            if (num >= 0) {
                count -= 1;
            }

            while (count == 0) {
                if (ans_len > j - i) {
                    ans = s.substring(i, j + 1);
                    ans_len = j - i;
                }

                if (map.containsKey(s.charAt(i))) {
                    num = map.get(s.charAt(i));
                    num += 1;
                    map.put(s.charAt(i), num);
                    if (num > 0) {
                        count += 1;
                    }
                }
                i += 1;
            }
        }

        return ans;

    }


}
