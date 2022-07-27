package org.ck.thread.status;

/**
 * @className: TestStop
 * @description: 测试stop 线程正常停止，不建议死循环
 * 建议使用标志位-->设置一个标志位
 * 不要使用stop或者destroy等过时或JDK不建议的方法
 * @createDate: 2021年07月07日 11:19:45
 * @author: ck
 */
public class TestStop implements Runnable {

    //1.设置标志
    boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run...Thread" + i++);
        }
    }

    //2.设置公开方法停止线程
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i== 900) {
                testStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }
}
