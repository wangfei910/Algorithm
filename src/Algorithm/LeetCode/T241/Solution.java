package Algorithm.LeetCode.T241;

import java.util.ArrayList;
import java.util.List;

/**
 * 给表达式加括号
 * <p>
 * 给定一串数字和运算符，将计算所有不同方法的所有可能结果返回给数字和运算符组。有效的操作符是+、-和*。
 *
 * @author: wangfei
 * @date: 2019/4/30 9:46
 */
public class Solution {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
