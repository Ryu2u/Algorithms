package com.ryu2u.exercise.YEAR_2023.month10;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.entity.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-31 14:45:22
 */
public class Test_20231031 {
    @Test
    public void test() {
        // ch36
        // ch206
        // ch70
        System.out.println(climbStairs(45));
        // ch98
        // ch28
        System.out.println(strStr("hello", "ll"));
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        char[] p = haystack.toCharArray();
        char[] s = needle.toCharArray();
        int[] next = new int[n + 1];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s[i] != s[j]) {
                j = next[j - 1];
            }
            if (s[i] == s[j]) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 0, j = 0; i < m; i++) {
            while (j > 0 && p[i] != s[j]) {
                j = next[j - 1];
            }
            if (p[i] == s[j]) {
                j++;
            }
            if (j == n) {
                return i - n + 1;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        char[] p = haystack.toCharArray();
        char[] s = needle.toCharArray();

        int[][] dp = new int[n][256];
        dp[0][s[0]] = 1;
        int x = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 256; j++) {
                dp[i][j] = dp[x][j];
            }
            dp[i][s[i]] = i + 1;
            x = dp[x][s[i]];
        }

        for (int i = 0, j = 0; i < m; i++) {
            j = dp[j][p[i]];
            if (j == n) {
                return i - n + 1;
            }
        }
        return -1;
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        long pre = Long.MIN_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] lines = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '1';
                lines[i][index]++;
                columns[j][index]++;
                boxes[i / 3][j / 3][index]++;
                if (lines[i][index] >= 2 || columns[j][index] >= 2 || boxes[i / 3][j / 3][index] >= 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public int climbStairs(int n) {
        int first = 0;
        int second = 0;
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            second = first;
            first = cur;
            cur = first + second;
        }
        return cur;
    }


}