package com.ryu2u.exercise.month8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-16 16:47:49
 */
public class Test_20230816 {
    @Test
    public void test() {
        // ch54
        // ch36
        // ch50
    }

    public double myPow(double x, int n) {
        long N = n;
        return n > 0 ? quickMul(x, N) : 1 / quickMul(x, N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;

    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[][] rows = new int[n][n];
        int[][] cols = new int[n][n];
        int[][][] boxes = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int x = c - '1';
                    rows[i][x]++;
                    cols[j][x]++;
                    boxes[i / 3][j / 3][x]++;
                    if (boxes[i / 3][j / 3][x] > 1 || rows[i][x] > 1 || cols[j][x] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length <= 0) {
            return list;
        }
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int count = matrix.length * matrix[0].length;
        while (count >= 1) {
            for (int i = l; i <= r && count >= 1; i++) {
                list.add(matrix[t][i]);
                count--;
            }
            t++;
            for (int i = t; i <= b && count >= 1; i++) {
                list.add(matrix[i][r]);
                count--;
            }
            r--;
            for (int i = r; i >= l && count >= 1; i--) {
                list.add(matrix[b][i]);
                count--;
            }
            b--;
            for (int i = b; i >= t && count >= 1; i--) {
                list.add(matrix[i][l]);
                count--;
            }
            l++;
        }
        return list;

    }


}