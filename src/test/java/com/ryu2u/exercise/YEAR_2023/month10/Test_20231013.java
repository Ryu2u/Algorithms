package com.ryu2u.exercise.YEAR_2023.month10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-13 15:08:32
 */
public class Test_20231013 {
    @Test
    public void test() {
        // ch48
        // ch77
        System.out.println(combine(5, 2));
        // ch6
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (int j = 0; j < s.length(); j++) {
            list.get(i).append(s.charAt(j));
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            sb.append(stringBuilder);
        }
        return sb.toString();

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, n, k, 1);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int n, int k, int index) {
        if (temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            backTracking(list, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    /**
     * (1,0) -> (0,1) -> (1,3)
     * <p>
     * (1,1) -> (1,,2)
     * (2,3) -> (3,1)
     * (i,j) -> (j,n -1 -i)
     * (n -1 -j,i) -> (i,j)
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }


}