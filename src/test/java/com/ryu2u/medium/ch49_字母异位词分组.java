package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * <p>
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * @author Ryu2u
 * @Description:
 * @date 2023/8/13 17:54
 */
public class ch49_字母异位词分组 {
    @Test
    public void test() {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(s, temp);
            } else {
                map.get(s).add(str);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (String s : map.keySet()) {
            List<String> strings = map.get(s);
            list.add(strings);
        }
        return list;
    }


}
