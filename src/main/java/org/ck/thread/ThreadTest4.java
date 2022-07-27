package org.ck.thread;

/**
 * @className: ThreadTest4
 * @description:
 * @createDate: 2021年06月25日 14:42:41
 * @author: ck
 */
public class ThreadTest4 implements Runnable {

    private int ticketNums = 10;

    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "张");
        }
    }

    public static void main(String[] args) {
        ThreadTest4 ticket = new ThreadTest4();

        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛党").start();

    }
}
