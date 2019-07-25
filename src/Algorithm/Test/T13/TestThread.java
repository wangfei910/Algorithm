package Algorithm.Test.T13;

/**
 * @author: wangfei
 * @date: 2019/7/15 23:40
 */
public class TestThread implements Runnable {
    int i = 1;

    @Override
    public void run() {
        while (true) {
            /*指代的为TestThread,因为使用的是implements方式。若使用继承Thread类的方式，慎用this*/
            synchronized (this) {
                /*唤醒另外一个线程，注意是this的方法，而不是Thread*/
                notify();
                try {
                    /*使其休眠100毫秒，放大线程差异*/
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                        /*放弃资源，等待*/
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        /*只有一个TestThread对象*/
        TestThread t = new TestThread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
