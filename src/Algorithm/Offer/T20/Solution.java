package Algorithm.Offer.T20;

import java.util.Stack;

/**
 * @author: wangfei
 * @date: 2019/4/1 22:05
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /**
     * 1. 主栈顺序存储元素，辅助栈每次存储当前栈的最小元素
     * 2. 主栈 Push，辅助栈压入 min(peek, node)
     * 3. 主栈和辅助栈同时 pop
     * 4. 对于 min 方法，辅助栈 peek
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
        if (stack2.empty()) {
            stack2.push(node);
        } else {
            if (stack2.peek() > node) {
                stack2.push(node);
            } else {
                stack2.push(stack2.peek());
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();

        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
