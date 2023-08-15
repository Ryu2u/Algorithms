package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/15 17:46
 */
public class ch54_螺旋矩阵 {

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder2(matrix));
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
    public List<Integer> spiralOrder2(int[][] matrix) {
        LinkedList<Integer> result = new LinkedList<>();
        if(matrix==null||matrix.length==0) return result;
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int count = matrix.length * matrix[0].length;
        while (count >= 1) {
            for (int i = l; i <= r && count >= 1; i++) {
                result.add(matrix[t][i]);
                count--;
            }
            t++;
            for (int i = t; i <= b && count >= 1; i++) {
                result.add(matrix[i][r]);
                count--;
            }
            r--;
            for (int i = r; i >= l && count >= 1; i--) {
                result.add(matrix[b][i]);
                count--;
            }
            b--;
            for (int i = b; i >= t && count >= 1; i--) {
                result.add(matrix[i][l]);
                count--;
            }
            l++;
        }
        return result;
    }
}