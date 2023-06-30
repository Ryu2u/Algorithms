package com.ryu2u.easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * @author Ryu2u
 * @Description:
 * @date 2023/6/11 17:23
 */
public class ch20_有效的括号 {

    public static boolean isValid(String s) {
        if (s == null || "".equals(s) || s.length() <= 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i) || '[' == s.charAt(i) || '{' == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                // 说明是右括号，和栈顶的匹配
                if (stack.isEmpty()){
                    return false;
                }
                Character l = stack.pop();
                Character r = s.charAt(i);
                switch (l) {
                    case '(': {
                        if (r != ')') {
                            return false;
                        }
                        break;
                    }
                    case '[': {
                        if (r != ']') {
                            return false;
                        }
                        break;
                    }
                    case '{': {
                        if (r != '}') {
                            return false;
                        }
                        break;
                    }
                    default: {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));

    }


}
