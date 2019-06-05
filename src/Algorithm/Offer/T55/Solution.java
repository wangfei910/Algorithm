package Algorithm.Offer.T55;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 链表中环的入口结点
 * <p>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author: wangfei
 * @date: 2019/5/12 21:25
 */
public class Solution {

    /**
     * 1、fast 指针一次 2 个节点，slow 指针一次 1 个节点
     * 2、链表环前面部分为 x， fast 与 slow 相遇在 z，x 与 z 之间的是 y
     * 3、由于 fast 是 slow 的两倍，则 fast 走过一圈半，slow 走不到一圈相遇
     * 4、fast 走过：x+y+z+y；slow 走过的 x+y
     * 5、x+y+z+y = 2(x+y) => x=z
     * 6、相遇后，slow 接着走，fast 从头开始走，两者在环入口处再次相遇
     *
     * @param pHead
     * @return
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        // 先判断是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                fast = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                if (slow == fast) {
                    return slow;
                }
            }
        }
        return null;
    }
}
