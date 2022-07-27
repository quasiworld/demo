package org.ck.thread;

/**
 * @className: ThreadTest3
 * @description:
 * @createDate: 2021年06月25日 14:30:08
 * @author: ns
 */
public class ThreadTest3 implements Runnable{

    public static void main(String[] args) {

        ThreadTest3 threadTest1 = new ThreadTest3();
        //代理
        new Thread(threadTest1).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("看代码" + i);
        }
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("学习多线程代码" + i);
        }
    }

}
