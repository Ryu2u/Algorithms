package com.ryu2u.medium;

import org.junit.Test;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例 1：
 * <p>
 * 1 3 1
 * 1 5 1
 * 4 2 1
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/29 17:51
 */
public class ch64_最小路径和 {
    @Test
    public void test() {
        int[][] grid = {{1, 9, 9, 8}, {1, 5, 1, 5}, {1, 1, 1, 8}};
        System.out.println(minPathSum(grid));
    }

    /**
     * 1 9 9 8
     * 1 5 1 5
     * 1 1 1 8
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] pb = new int[m][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            pb[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            pb[i][0] = sum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pb[i][j] = Math.min(pb[i][j - 1], pb[i - 1][j]) + grid[i][j];
            }
        }
        return pb[m - 1][n - 1];
    }


}
