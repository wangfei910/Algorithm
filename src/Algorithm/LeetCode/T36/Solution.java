package Algorithm.LeetCode.T36;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断是否为合格数独
 *
 * @author: wangfei
 * @date: 2019/3/26 16:04
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Set set = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    String s = "(" + board[i][j] + ")";
                    if (!set.add(s + i) || !set.add(j + s) || !set.add(i / 3 + s + j / 3))
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        Set set = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!set.add(number + " in row " + i) || !set.add(number + " in column " + j) || !set.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

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
