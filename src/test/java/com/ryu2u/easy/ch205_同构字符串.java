package com.ryu2u.easy;

import org.junit.Test;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 *
 * @author Ryu2u
 * @Description:
 * @date 2023/7/16 12:24
 */
public class ch205_同构字符串 {

    @Test
    public void test() {
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }


    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if ((map1.containsKey(cs) && map1.get(cs) != ct) || (map2.containsKey(ct) && map2.get(ct) != cs)) {
                return false;
            } else {
                map1.put(cs, ct);
                map2.put(ct, cs);
            }
        }
        return true;
    }


}
