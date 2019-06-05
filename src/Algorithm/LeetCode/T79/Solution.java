package Algorithm.LeetCode.T79;

/**
 * 单词搜索
 * <p>
 * 给定一个2D板和一个单词，找出这个单词是否存在于网格中。
 * 单词可以由顺序相邻的单元格组成，其中“相邻”单元格是水平或垂直相邻的单元格。同一单元格不可使用超过一次。
 *
 * @author: wangfei
 * @date: 2019/6/1 11:12
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int i, int j) {
        if (index == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length)
            return false;
        if ((board[i][j] - word.charAt(index)) != 0)
            return false;
        char record = board[i][j];
        board[i][j] = '1';
        //从上方开始顺时针寻找
        boolean res = searchWord(board, word, index + 1, i - 1, j)
                || searchWord(board, word, index + 1, i, j - 1)
                || searchWord(board, word, index + 1, i, j + 1)
                || searchWord(board, word, index + 1, i + 1, j);
        board[i][j] = record;
        return res;
    }

    private boolean dfs(char[][] board, char[] w, int start, int i, int j, boolean[][] visited, int m, int n) {
        if (visited[i][j])
            return false;
        if (board[i][j] != w[start])
            return false;
        if (start == w.length - 1)
            return true;
        visited[i][j] = true;
        if (i + 1 < m) {
            if (dfs(board, w, start + 1, i + 1, j, visited, m, n))
                return true;
        }
        if (i - 1 >= 0) {
            if (dfs(board, w, start + 1, i - 1, j, visited, m, n))
                return true;
        }
        if (j - 1 >= 0) {
            if (dfs(board, w, start + 1, i, j - 1, visited, m, n))
                return true;
        }
        if (j + 1 < n) {
            if (dfs(board, w, start + 1, i, j + 1, visited, m, n))
                return true;
        }
        visited[i][j] = false;
        return false;
    }

    public boolean exist2(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;
        if (word == null)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] w = word.toCharArray();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] != w[0])
                    continue;
                if (dfs(board, w, 0, i, j, visited, m, n))
                    return true;
            }
        }
        return false;
    }
}
