package Algorithm.LeetCode.T212;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangfei
 * @date: 2019/4/2 16:35
 */
public class Solution1 {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isEnd;
        String word;
    }

    TrieNode root = new TrieNode();
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            addToTrie(word);
        }
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = board[i][j];
                visited[i][j] = true;
                search(board, i, j, root.next[c - 'a'], visited);
                visited[i][j] = false;
            }
        }
        return res;
    }

    public void search(char[][] board, int i, int j, TrieNode node, boolean[][] visited) {
        if (node == null) return;
        if (node.isEnd && !res.contains(node.word)) {
            res.add(node.word);
        }
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
                    || node.next[board[x][y] - 'a'] == null || visited[x][y])
                continue;
            visited[x][y] = true;
            search(board, x, y, node.next[board[x][y] - 'a'], visited);
            visited[x][y] = false;
        }
    }

    public void addToTrie(String word) {
        TrieNode dummy = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (dummy.next[c - 'a'] == null)
                dummy.next[c - 'a'] = new TrieNode();
            dummy = dummy.next[c - 'a'];
        }
        dummy.word = word;
        dummy.isEnd = true;
    }
}
