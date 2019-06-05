package Algorithm.Offer.T34;

import java.util.BitSet;

/**
 * 第一个只出现一次的字符
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * @author: wangfei
 * @date: 2019/5/6 22:25
 */
public class Solution {

    /**
     * 最直观的解法是使用 HashMap 对出现次数进行统计，但是考虑到要统计的字符范围有限，
     * 因此可以使用整型数组代替 HashMap，从而将空间复杂度由 O(N) 降低为 O(1)。
     *
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        int[] counts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 以上实现的空间复杂度还不是最优的。考虑到只需要找到只出现一次的字符，
     * 那么需要统计的次数信息只有 0,1,更大，使用两个比特位就能存储这些信息。
     *
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar1(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                // 0 0 -> 0 1
                bs1.set(c);
            }else if (bs1.get(c) && !bs2.get(c)) {
                // 0 1 -> 1 1
                bs2.set(c);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 0 1
            if (bs1.get(c) && !bs2.get(c))
                return i;
        }
        return -1;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String str = "ababcddef";
        System.out.println(FirstNotRepeatingChar(str));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
