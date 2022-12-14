package org.ck.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @className: TestLock
 * @description:
 * @createDate: 2021年07月16日 18:12:23
 * @author: ck
 */
public class TestLock {

    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {

    int ticketNums = 10;

    //定义lock锁
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                } else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }

        }
    }
}
