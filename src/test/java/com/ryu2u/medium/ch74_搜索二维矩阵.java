package com.ryu2u.medium;

import org.junit.Test;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非递减顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/30 16:24
 */
public class ch74_搜索二维矩阵 {

    @Test
    public void test() {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = matrix.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == matrix[mid][0] || target == matrix[mid][n - 1]) {
                return true;
            } else if (target > matrix[mid][0] && target < matrix[mid][n - 1]) {
                l = 0;
                r = n - 1;
                int i = mid;
                while (l <= r) {
                    mid = (l + r) / 2;
                    if (target == matrix[i][mid]) {
                        return true;
                    } else if (target > matrix[i][mid]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            } else if (target < matrix[mid][0]) {
                r = mid - 1;
            } else if (target > matrix[mid][n - 1]) {
                l = mid + 1;
            }
        }
        return false;

    }


}
