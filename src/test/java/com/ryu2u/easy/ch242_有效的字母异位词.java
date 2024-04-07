package com.ryu2u.easy;


import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 * <p>
 * <p>
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author Ryu2u
 * @Description:
 * @date 2024/4/7 13:02
 */
public class ch242_有效的字母异位词 {


    @Test
    public void test() {

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if (i != 0){
                return false;
            }
        }
        return true;

    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> maps = new HashMap<>(16);
        HashMap<Character, Integer> mapt = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            maps.put(cs, maps.getOrDefault(cs, 0) + 1);
            char ct = t.charAt(i);
            mapt.put(ct, mapt.getOrDefault(ct, 0) + 1);
        }

        for (Character k : maps.keySet()) {
            Integer si = maps.get(k);
            Integer ti = mapt.get(k);
            if (!Objects.equals(si, ti)) {
                return false;
            }
        }
        return true;
    }


}
