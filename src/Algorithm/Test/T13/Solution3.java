package Algorithm.Test.T13;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: wangfei
 * @date: 2019/7/14 23:14
 */
public class Solution3 {

    /**
     * volatile + JUC
     * flag 是 volatile，保证修饰可见，count 是 JUC 通过 ACS 实现线程安全，减少线程上下文切换
     */
    private static int MAX = 20;
    private static volatile boolean flag = true;
    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (count.get() < MAX) {
                if (!flag) {
                    System.out.println(count.getAndIncrement());
                    flag = true;
                }
            }
        });
        t1.setName("A");
        Thread t2 = new Thread(() -> {
            while (count.get() < MAX) {
                if (flag) {
                    System.out.println(count.getAndIncrement());
                    flag = false;
                }
            }
        });
        t2.setName("B");
        //启动线程
        t1.start();
        t2.start();
    }
}
