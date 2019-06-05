package Algorithm.Offer.T46;

import java.util.ArrayList;

/**
 * 圆圈中最后剩下的数(约瑟夫环)
 *
 * @author: wangfei
 * @date: 2019/5/11 16:20
 */
public class Solution {

    /**
     * 数组模拟环
     * 1、i 为每次可以报数的人的序号，当 i 走到尽头时 i 置为 0，i 遍历所有的数组
     * 2、count 为剩下未删除的人，每出去一个人 count 减 1
     * 3、step 为报数的人数，step 等于 m 时，标记删除（数组置为 -1）和重置
     *
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining(int n, int m) {
        if (n == 0 || m == 0)
            return -1;
        int[] arr = new int[n];
        int i = -1, count = n, step = 0;
        while (count > 0) {
            if (++i == n)
                i = 0;
            if (arr[i] == -1)
                continue;
            if (++step == m) {
                arr[i] = -1;
                step = 0;
                --count;
            }
        }
        return i;
    }


    /**
     * 链表模拟环
     * 1、count 从 0 开始计数，每间隔 m - 1 删除一个元素
     * 2、count = (count + m -1) % list.size() 模拟环，记录下一个 m - 1 元素在当前链表的位置
     *
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining2(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int count = 0;
        while (list.size() > 1) {
            count = (count + m - 1) % list.size();
            list.remove(count);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int m = 8, n = 6;
        System.out.println(LastRemaining2(n, m));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
