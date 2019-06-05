package Algorithm.common;

/**
 * @author: wangfei
 * @date: 2019/4/17 19:44
 */
public class Node {

    public int[] person;
    public Node next;

    public Node(int[] p) {
        person = p;
    }

    public static Node insert(Node node, int[] person) {
        Node newNode = new Node(person);
        int rank = person[1], height = person[0];
        if (rank == 0) {
            newNode.next = node;
            return newNode;
        }
        Node curr = node;
        while (rank > 1) {
            curr = curr.next;
            rank--;
        }
        Node next = curr.next;
        newNode.next = next;
        curr.next = newNode;
        return node;
    }
}
