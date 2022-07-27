package org.ck.thread.status;

/**
 * @className: TestJoin
 * @description: 测试join方法
 * @createDate: 2021年07月07日 15:26:59
 * @author: ck
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        for (int i = 0; i < 500; i++) {
            if (i == 10) {
                thread.join();//插队
            }
            System.out.println("main" + i);
        }


    }
}
