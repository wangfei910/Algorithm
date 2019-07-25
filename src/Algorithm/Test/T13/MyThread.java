package Algorithm.Test.T13;

/**
 * @author: wangfei
 * @date: 2019/7/16 0:10
 */
public class MyThread extends Thread {
    private static final Object LOCK_INFO = new Object();
    private static volatile int i = 1;
    private static volatile int last = i;
    private static final int minSize = 50;
    private static final int maxSize = 100;
    private final int size;

    public MyThread(int size) {
        this.size = size;
    }

    @Override
    public void run() {
        for (int j = 0; j < size; j++) {
            synchronized (LOCK_INFO) {
                if (last == i) {
                    System.out.println(this.getName() + ", i:" + i++);
                    if (j > minSize - 1) {
                        last = i;
                    }
                } else {
                    System.out.println(this.getName() + ", i:" + last);
                    last = i;
                }
                try {
                    LOCK_INFO.notify();
                    if (j < minSize - 1) {
                        LOCK_INFO.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread a = new MyThread(minSize);
        Thread b = new MyThread(maxSize);
        a.start();
        b.start();
    }
}
