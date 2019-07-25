package Algorithm.Test.ThreadTest;

/**
 * @author: wangfei
 * @date: 2019/5/17 15:48
 */
public class ThreadTest02 implements Runnable {

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        new Thread(new ThreadTest02(), "Thread02").start();
    }
}
