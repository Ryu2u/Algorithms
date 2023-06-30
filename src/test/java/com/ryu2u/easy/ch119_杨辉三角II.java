package com.ryu2u.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 *
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 *
 * 示例 3:
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 *
 * 提示:
 * 0 <= rowIndex <= 33
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/30 11:30
 */
public class ch119_杨辉三角II {
    /**
     *
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int[][] pb = new int[rowIndex+1][rowIndex+1];
        for (int i = 0; i < rowIndex +1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pb[i][j] = 1;
                }else{
                    pb[i][j] = pb[i-1][j-1] + pb[i-1][j];
                }
            }
        }
        for (int i = 0; i <= rowIndex; i++) {
            list.add(pb[rowIndex][i]);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

}
