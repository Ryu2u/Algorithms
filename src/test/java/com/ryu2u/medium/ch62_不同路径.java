package com.ryu2u.medium;

import org.junit.Test;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/25 17:35
 */
public class ch62_不同路径 {
    @Test
    public void test() {
        System.out.println(uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        int[][] pb = new int[m][n];
        for (int i = 0; i < m; i++) {
            pb[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            pb[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pb[i][j] = pb[i][j - 1] + pb[i - 1][j];
            }
        }
        return pb[m - 1][n - 1];
    }

}
