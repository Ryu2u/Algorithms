package com.ryu2u.medium;

import org.junit.Test;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * @author Administrator
 * @Description:
 * @date 2023/9/2 13:49
 */
public class ch79_单词搜索 {
    @Test
    public void test() {

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backTracking(board, word, 0, used, i, j);
                }
            }
        }
        return flag;
    }

    boolean flag = false;

    private void backTracking(char[][] board, String word, int count, boolean[][] used, int i, int j) {
        if (flag) {
            return;
        }
        if (count == word.length()) {
            flag = true;
            return;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(count)) {
            return;
        }
        if (used[i][j]) {
            return;
        }
        used[i][j] = true;
        backTracking(board, word, count + 1, used, i - 1, j);
        backTracking(board, word, count + 1, used, i + 1, j);
        backTracking(board, word, count + 1, used, i, j - 1);
        backTracking(board, word, count + 1, used, i, j + 1);
        used[i][j] = false;
    }


}
