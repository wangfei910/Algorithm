package Algorithm.Offer.T3;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表值
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 利用栈先进后出原则进行倒序打印
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 利用动态数组的性质将链表元素从头到尾依次添加到动态数组索引为0的位置，这样最后添加进
     * 来的元素放在首位，第一个添加进来的元素则放在末尾，也就实现了倒序
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        list.add(0, listNode.val);
        ListNode temp = listNode.next;
        while (temp != null) {
            list.add(0, temp.val);
            temp = temp.next;
        }
        return list;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = listNodeUtil.buildListNode(arr);
        System.out.println(printListFromTailToHead(listNode));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
