package org.ck.thread.status;

/**
 * @className: TestSleep
 * @description: 模拟网络延时
 * @createDate: 2021年07月07日 11:33:05
 * @author: ck
 */
public class TestSleep implements Runnable{

    private int ticketNums = 10;

    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep( 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "张");
        }
    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();
        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛党").start();

    }
}
