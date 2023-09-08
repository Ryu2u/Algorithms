package com.ryu2u.exercise.month9;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-07 13:25:03
 */
public class Test_20230907 {
    @Test
    public void test() {
        // ch190
        // ch94
        // ch12

    }


    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] letters = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        while (num > 0) {
            for (int i = values.length - 1; i >= 0; i--) {
                if (num >= values[i]) {
                    num -= values[i];
                    sb.append(letters[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) ^ (n & 1);
            n >>>= 1;
        }
        return ans;
    }


}