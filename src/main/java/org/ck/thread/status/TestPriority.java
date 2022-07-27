package org.ck.thread.status;

/**
 * @className: TestPriority
 * @description:
 * @createDate: 2021年07月07日 16:02:41
 * @author: ck
 */
public class TestPriority {

    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        //设置优先级启动
        t1.start();
        t2.setPriority(1);
        t2.start();
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();
    }

}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
