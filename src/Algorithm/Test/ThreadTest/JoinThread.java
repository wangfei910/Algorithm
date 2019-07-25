package Algorithm.Test.ThreadTest;

/**
 * @author: wangfei
 * @date: 2019/5/23 19:03
 */
public class JoinThread extends Thread {

    public JoinThread(String name) {
        //提供一个有参数的构造器，用于设置该线程的名字
        super(name);
    }

    //重写run()方法，定义线程执行体
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws Exception {
        //启动子线程
        JoinThread jt1 = new JoinThread("新线程");
        jt1.start();
        for (int i = 0; i < 40; i++) {
            if (i == 20) {
                JoinThread jt = new JoinThread("被Join的线程");
                jt.start();
                //main线程调用了jt线程的join()方法，main线程必须等jt执行结束才会向下执行
                jt.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
