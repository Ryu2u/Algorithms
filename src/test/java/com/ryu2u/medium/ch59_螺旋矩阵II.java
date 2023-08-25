package com.ryu2u.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 20
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/22 9:26
 */
public class ch59_螺旋矩阵II {
    @Test
    public void test() {
        int[][] ints = generateMatrix(20);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }

    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        int count = 1;
        while (count <= n * n) {
            for (int i = l; i <= r && count <= n * n; i++) {
                matrix[t][i] = count;
                count++;
            }
            t++;
            for (int i = t; i <= b && count <= n * n; i++) {
                matrix[i][r] = count;
                count++;
            }
            r--;
            for (int i = r; i >= l && count <= n * n; i--) {
                matrix[b][i] = count;
                count++;
            }
            b--;
            for (int i = b; i >= t && count <= n * n; i--) {
                matrix[i][l] = count;
                count++;
            }
            l++;
        }
        return matrix;

    }


}
