package com.ryu2u.exercise.YEAR_2023.month8;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-29 13:24:02
 */
public class Test_20230829 {
    @Test
    public void test() {
        // ch100
        // ch66
        // ch20
        System.out.println(isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                Character p = stack.pop();
                if (p == '(' && c != ')') {
                    return false;
                } else if (p == '[' && c != ']') {
                    return false;
                } else if (p == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        while (n >= 0) {
            int num = digits[n];
            if (num < 9) {
                digits[n]++;
                return digits;
            } else {
                digits[n] = 0;
                n--;
            }
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }


}