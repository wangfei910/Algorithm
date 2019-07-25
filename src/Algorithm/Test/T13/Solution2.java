package Algorithm.Test.T13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wangfei
 * @date: 2019/7/14 22:49
 */
public class Solution2 {

    /**
     * ReentrantLock + Condition
     * COUNT 虽然使用了 volatile，但是由于 COUNT++ 不是原子操作，因此要将锁放在外面
     * 1. 两个线程需要两个 Condition，使用 Condition 必须首先获得 Lock.lock()，并在 finally 中 Lock.unlock()
     * 2. 在线程 A 中，lock -> 打印 -> 唤醒线程 B -> 休眠线程 A -> finally{unlock}
     * 3. 在线程 B 中，lock -> 打印 -> 唤醒线程 A -> 休眠线程 B -> finally{unlock}
     */
    private static ReentrantLock LOCK = new ReentrantLock();
    private static Condition t1Condition = LOCK.newCondition();
    private static Condition t2Condition = LOCK.newCondition();
    static int COUNT = 0;
    static int MAX = 20;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            // 加锁
            LOCK.lock();
            try {
                while (COUNT++ < MAX) {
                    try {
                        // 打印
                        System.out.println("A  " + Thread.currentThread().getName());
                        // 线程 A 等待
                        t1Condition.await();
                        // 唤醒线程 B
                        t2Condition.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                LOCK.unlock();
            }
        });
        t1.setName("A");

        Thread t2 = new Thread(() -> {
            // 加锁
            LOCK.lock();
            try {
                while (COUNT++ < MAX) {
                    try {
                        System.out.println("B  " + Thread.currentThread().getName());
                        // 唤醒线程 A
                        t1Condition.signal();
                        // 线程 B 等待
                        t2Condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                LOCK.unlock();
            }
        });
        t2.setName("B");

        t1.start();
        t2.start();
    }
}
