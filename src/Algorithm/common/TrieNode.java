package Algorithm.common;

/**
 * @author: wangfei
 * @date: 2019/3/27 21:52
 */
public class TrieNode {

    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
