package Algorithm.LeetCode.T141;

import Algorithm.common.ListNode;

/**
 * 判断链表是否有环
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
