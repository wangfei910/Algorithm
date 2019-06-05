package Algorithm.LeetCode.T37;

import java.util.Arrays;

/**
 * 数独
 * 编写一个程序，通过填充空单元格来解决数独难题。
 * 数独解决方案必须满足以下所有规则:
 * 1.每个数字1-9必须在每一行中精确地出现一次。
 * 2.每个数字1-9必须在每一列中精确地出现一次。
 * 3.每个数字1-9必须在网格的9个3x3子框中精确地出现一次。
 *
 * @author wangfei
 */
public class Solution {

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';  //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            //check row
            if (board[i][col] != '.' && board[i][col] == c)
                return false;
            // check column
            if (board[row][i] != '.' && board[row][i] == c)
                return false;
            //check 3*3 block
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    //TODO
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','.','.','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
//        System.out.println(solveSudoku(board));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
