package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/26 17:48
 */
public class ch17_电话号码的字母组合 {

    @Test
    public void test() {

        System.out.println(letterCombinations("232"));
    }


    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() <= 0){
            return list;
        }
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTracking(list,digits,letters,0);
        return list;
    }

    StringBuilder sb = new StringBuilder();
    private void backTracking(List<String> list ,String digits,String[] letters,int count){
        if (count == digits.length()){
            list.add(sb.toString());
            return;
        }
        String str = letters[digits.charAt(count) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(list,digits,letters,count + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }




}
