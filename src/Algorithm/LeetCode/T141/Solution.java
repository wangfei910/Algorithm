package Algorithm.LeetCode.T141;

import Algorithm.LeetCode.common.ListNode;

/**
 * 判断链表是否有环
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 利用快慢指针判断是否有环
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
