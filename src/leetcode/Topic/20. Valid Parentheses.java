package ValidParentheses;

import java.util.HashMap;
import java.util.Stack;

/**
 * 判断是否为有效括号
 * @author wangfei
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		String s = "()";
		boolean res = isValid(s);
		System.out.println(res);
	}

	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		if(s == null)
			return false;
		for(int i=0; i<s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				stack.push(s.charAt(i));
			}else if(map.values().contains(s.charAt(i))) {
				if(!stack.empty() && map.get(stack.peek()) == s.charAt(i)) {
					stack.pop();
				}else {
					return false;
				}
			}
		}
		return stack.empty();
	}
}
