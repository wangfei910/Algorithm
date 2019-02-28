package Algorithm.LeetCode.T20;

import java.util.HashMap;
import java.util.Stack;

/**
 * 判断是否为有效括号
 *
 * @author wangfei
 */
public class Solution {

    /**
     * 1.将配对的括号存在map中并用stack判断字符串括号是否有效
     * 2.遍历字符串，判断左右括号，若为左括号，则将其压入栈中，否则返回false
     * 3.若为右括号且栈不为空，栈顶元素是相对应的左括号，则将栈顶元素弹出，否则返回false
     * 4.最后返回栈是否为空
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        if (s == null)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (map.values().contains(s.charAt(i))) {
                if (!stack.empty() && map.get(stack.peek()) == s.charAt(i)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()[  ";
        boolean res = isValid(s);
        System.out.print(res);
    }
}
