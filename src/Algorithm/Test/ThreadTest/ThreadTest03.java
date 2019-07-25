package Algorithm.Test.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author: wangfei
 * @date: 2019/5/17 15:48
 */
public class ThreadTest03 implements Callable<String> {

    @Override
    public String call() throws Exception{
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        ThreadTest03 threadTest03 = new ThreadTest03();
        FutureTask<String> futureTask = new FutureTask<String>(threadTest03);
        new Thread(futureTask, "Thread03").start();
    }
}
