package com.ryu2u.exercise.month8;

import org.junit.Test;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-13 16:29:11
 */
public class Test_20230811 {
    @Test
    public void test() {
        // ch343
        System.out.println(integerBreak(58));
        System.out.println(integerBreak2(58));
        // ch8
        System.out.println(myAtoi("2147483646"));
        // ch36

    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[][] rows = new int[n][n];
        int[][] columns = new int[n][n];
        int[][][] boxes = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1';
                    rows[i][num]++;
                    columns[j][num]++;
                    boxes[i/3][j/3][num]++;
                    if (rows[i][num] > 1 || columns[j][num] > 1||boxes[i/3][j/3][num] > 1){
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public int myAtoi(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }
        char c = s.charAt(0);
        int flag;
        int n = 0;
        if (c == '-') {
            flag = -1;
        } else if (c == '+') {
            flag = 1;
        } else if (Character.isDigit(c)) {
            flag = 1;
            n = c - '0';
        } else {
            return 0;
        }
        for (int i = 1; i < s.length(); i++) {
            char cc = s.charAt(i);
            int num = cc - '0';
            if (Character.isDigit(cc)) {
                if (n > (Integer.MAX_VALUE - num) / 10) {
                    return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                n = n * 10 + num;
            } else {
                break;
            }
        }

        return n * flag;
    }

    public int integerBreak(int n) {
        int[] f = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            f[i] = Math.max(Math.max(2 * (i - 2), 2 * f[i - 2]), Math.max(3 * (i - 3), 3 * f[i - 3]));
        }
        return f[n];
    }

    public int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int mod = n % 3;
        if (mod == 2) {
            return (int) Math.pow(3, a) * 2;
        } else if (mod == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        } else {
            return (int) Math.pow(3, a);
        }
    }


}