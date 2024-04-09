package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * <p>
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * <p>
 * <p>
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 *
 * @author Ryu2u
 * @Description:
 * @date 2024/4/9 14:54
 */
public class ch151_反转字符串中的单词 {

    @Test
    public void test() {

        System.out.println(reverseWords("a good   example"));

    }

    public String reverseWords(String s) {
        List<String> list = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
                if (i == s.length() - 1) {
                    list.add(temp.toString());
                }
            } else {
                if (temp.length() > 0) {
                    list.add(temp.toString());
                    temp = new StringBuilder();
                }
            }
        }

        temp = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            temp.append(list.get(i)).append(" ");
        }
        temp.deleteCharAt(temp.length() - 1);
        return temp.toString();
    }


}
