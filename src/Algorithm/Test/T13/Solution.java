package Algorithm.Test.T13;

/**
 * 两个线程交叉打印
 *
 * @author: wangfei
 * @date: 2019/7/14 22:31
 */
public class Solution {

    /**
     * wait + notify + synchronized
     * 加锁，效率低，线程上下文切换
     * syn 锁的粒度要小点，直接锁在对象 OBJECT 上
     * COUNT 虽然使用了 volatile，但是由于 COUNT++ 不是原子操作，因此要将锁放在外边
     */
    private static final Object OBJECT = new Object();
    private volatile static int COUNT = 0;
    private static int MAX = 20;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            //同步
            synchronized (OBJECT) {
                while (COUNT++ < MAX) {
                    System.out.println("A" + COUNT);
                    //唤醒线程 B
                    OBJECT.notify();
                    //线程 A 释放锁，阻塞等待
                    try {
                        OBJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.setName("A");
        Thread t2 = new Thread(() -> {
            //同步
            synchronized (OBJECT) {
                while (COUNT++ < MAX) {
                    System.out.println("B" + COUNT);
                    //唤醒线程 A
                    OBJECT.notify();
                    //线程 B 释放锁，阻塞等待
                    try {
                        OBJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.setName("B");
        //启动线程
        t1.start();
        t2.start();
    }
}
