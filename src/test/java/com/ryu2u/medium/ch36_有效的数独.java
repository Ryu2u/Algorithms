package com.ryu2u.medium;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * <p>
 * 示例 1：
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * <p>
 * <p>
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/1 14:53
 */
public class ch36_有效的数独 {
    @Test
    public void test() {

    }

    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        int[][] row = new int[len][len];
        int[][] column = new int[len][len];
        int[][][] boxs = new int[3][3][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char c = board[i][j];
                if (c != '.') {
                    // 不 - '0' 的原因是不能数组越界
                    int index = c - '1';
                    row[i][index]++;
                    column[j][index]++;
                    boxs[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || column[j][index] > 1 || boxs[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }


}
