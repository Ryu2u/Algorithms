package com.ryu2u.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/30 11:30
 */
public class ch118_杨辉三角 {

    /**
     * 自己写的
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] pb = new int[numRows + 1][numRows + 1];
        for (int i = 1; i <= numRows; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                // y == 1 表示第一列， x == y表示最后一列，他们都是1
                if (i == 1 || i == j) {
                    pb[i][j] = 1;
                } else {
                    pb[i][j] = pb[i - 1][j - 1] + pb[i - 1][j];
                }
                l.add(pb[i][j]);
            }
            list.add(l);
        }
        return list;
    }

    /**
     * 官方解答
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    l.add(1);
                } else {
                    l.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(l);
        }
        return list;
    }


    /**
     * @param numRows 表示生成哪一行的数据
     * @return 那一行数据的集合
     */
    public static List<Integer> rowList(int numRows) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            list.add(nums(numRows, i));
        }
        return list;
    }


    /**
     * @param x 表示遍历到哪一行了 那么 (x-1,y) 表示上一行的 y列的数据 (x-1,y-1) 表示上一行y-1列的数据
     * @param y
     * @return
     */
    public static int nums(int x, int y) {
        // y ==1 表示第一列， x==y表示最后一列，他们都是1
        if (y == 1 || x == y) {
            return 1;
        }
        return nums(x - 1, y - 1) + nums(x - 1, y);
    }

    public static void main(String[] args) {
//        List<List<Integer>> generate = generate(30);
//        for (List<Integer> integers : generate) {
//            System.out.println(integers);
//        }

    }

}
