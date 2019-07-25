package Algorithm.Test.T14;

/**
 * @author: wangfei
 * @date: 2019/7/17 16:36
 */
public class Solution {

    public static boolean StartAndEndLinked(String[] str) {
        if (str.length <= 1)
            return true;
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                if (str[i].charAt(str[i].length() - 1) == str[j].charAt(0))
                    count++;
            }
        }
        if (count >= str.length - 1)
            return true;
        else
            return false;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String[] str = {"gj", "jl", "dg", "ad", "gg"};
        System.out.println(StartAndEndLinked(str));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
