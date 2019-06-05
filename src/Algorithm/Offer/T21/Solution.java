package Algorithm.Offer.T21;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * @author: wangfei
 * @date: 2019/4/1 21:18
 */
public class Solution {

    /**
     * 思路：借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是
     * 出栈顺序的第一个元素，这里是4，很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，出栈一个
     * 元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，如果辅助栈还不为空，
     * 说明弹出序列不是该栈的弹出顺序。
     *
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        //标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                //出栈
                stack.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(pushA, popA));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
