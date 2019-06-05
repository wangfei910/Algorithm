package Algorithm.LeetCode.T344;

/**
 * 翻转字符串
 * <p>
 * 编写一个反转字符串的函数。输入字符串作为字符数组char[]给出。
 * 不要为另一个数组分配额外的空间，您必须使用O(1)额外内存修改输入数组。
 * 您可以假设所有字符都由可打印的ascii字符组成。
 *
 * @author: wangfei
 * @date: 2019/5/19 16:57
 */
public class Solution {

    public static char[] reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l <= r) {
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            l++;
            r--;
        }
        return s;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(reverseString(s));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
