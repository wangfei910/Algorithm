package Algorithm.LeetCode.T2;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 添加两个数字
 * <p>
 * 给定两个非空链表，表示两个非负整数。这些数字以相反的顺序存储，它们的每个节点都包含一个数字。
 * 将这两个数字相加并以链表的形式返回。
 * 您可以假设这两个数字不包含任何前导零，除了数字0本身。
 * 例子:
 * 输入:(2 -> 4 -> 3)+ (5 -> 6 -> 4)
 * 输出:7 -> 0 -> 8
 * 说明:342 + 465 = 807。
 *
 * @author: wangfei
 * @date: 2019/5/23 22:31
 */
public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr1 = {5};
        int[] arr2 = {5};
        listNodeUtil.showListNode(addTwoNumbers(listNodeUtil.buildListNode(arr1), listNodeUtil.buildListNode(arr2)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
