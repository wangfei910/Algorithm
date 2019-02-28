package Algorithm.LeetCode.common;

/**
 * ListNode工具类，实现创建链表和删除链表
 *
 * @author wangfei
 */
public class ListNodeUtil {
    /**
     * 尾插法创建链表
     *
     * @param input
     * @return
     */
    public static ListNode buildListNode(int[] input) {
        if (input.length == 0)
            return null;
        ListNode head = new ListNode(input[0]);
        ListNode currentNode = head;
        for (int i = 1; i < input.length; i++) {
            currentNode.next = new ListNode(input[i]);
            currentNode = currentNode.next;
        }
        return head;
    }

    /**
     * 显示链表
     *
     * @param head
     */
    public static void showListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }
}
