package Algorithm.Offer.T27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 字符串的排列
 * <p>
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author: wangfei
 * @date: 2019/5/4 22:52
 */
public class Solution {

    public static ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str.length() == 0)
            return (ArrayList<String>) res;
        function(str.toCharArray(), res, 0);
        Collections.sort(res);
        return (ArrayList<String>) res;
    }

    private static void function(char[] chars, List<String> res, int i) {
        //这是递归的终止条件，就是i下标已经移到char数组的末尾的时候，考虑添加这一组字符串进入结果集中
        if (i == chars.length - 1) {
            //判断是否重复
            if (!res.contains(new String(chars))) {
                res.add(new String(chars));
                return;
            }
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                function(chars, res, i + 1);
                swap(chars, i, j);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        if (i != j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String str = "abc";
        System.out.println(Permutation(str));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
