package Algorithm.Test.T9;

/**
 * 约瑟夫环
 *
 * @author: wangfei
 * @date: 2019/6/3 21:03
 */
public class Solution {

    /**
     * 对于这种带有循环结构的题，一般都可以建立循环链表然后队链表进行操作，这样不仅可以输出最后一个，还可以一次输出淘汰的编号
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaing(int n, int m) {
        if (n == 0 || m == 0)
            return -1;
        Node head = new Node();
        head.value = 0;
        head.next = head;
        Node nn = head;
        Node e = head;
        for (int i = 1; i <= n - 1; i++) {
            while (nn.next != head) {
                nn = nn.next;
            }
            Node node = new Node();
            node.value = i;
            nn.next = node;
            node.next = head;
        }
        for (int j = 1; j <= n - 1; j++) {
            for (int i = 1; i <= m - 2; i++) {
                e = e.next;
            }
            Node d = e.next;
            e.next = d.next;
            e = d.next;
        }
        return e.value;
    }
}

class Node{
    public int value;
    public Node next = null;
}