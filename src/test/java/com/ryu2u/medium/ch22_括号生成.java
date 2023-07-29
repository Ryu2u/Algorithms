package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * 1 <= n <= 8
 *
 * @author Ryu2u
 * @Description:
 * @date 2023/7/29 20:55
 */
public class ch22_括号生成 {
    @Test
    public void test() {
        System.out.println(generateParenthesis(3));

    }


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTracking(list, "", n, n);
        return list;
    }

    private void backTracking(List<String> list, String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left == right) {
            backTracking(list, str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                backTracking(list, str + "(", left - 1, right);
            }
            backTracking(list, str + ")", left, right - 1);
        }


    }


}
