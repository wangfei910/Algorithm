package Algorithm.LeetCode.T212;

import Algorithm.LeetCode.T208.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词查找
 *
 * @author: wangfei
 * @date: 2019/4/2 16:07
 */
public class Solution {

    Set<String> res = new HashSet<String>();

    /**
     * Trie + DFS
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<String>(res);
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;
        if (visited[x][y])
            return;
        str += board[x][y];
        if (!trie.startsWith(str))
            return;
        if (trie.search(str)) {
            res.add(str);
        }
        visited[x][y] = true;
        dfs(board, visited, str, x - 1, y, trie);
        dfs(board, visited, str, x + 1, y, trie);
        dfs(board, visited, str, x, y - 1, trie);
        dfs(board, visited, str, x, y + 1, trie);
        visited[x][y] = false;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();

        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
