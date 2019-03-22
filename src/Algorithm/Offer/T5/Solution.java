package Algorithm.Offer.T5;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @author wangfei
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 入队列
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 出队列
     *
     * @return
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
