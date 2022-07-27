package org.ck.thread;

/**
 * @className: Race
 * @description: 龟兔赛跑
 * @createDate: 2021年06月25日 14:55:43
 * @author: ck
 */
public class Race implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            //模拟兔子休息
            /*if (Thread.currentThread().getName().equals("兔子")) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
            boolean flag = checkGameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-》跑了" + i + "步");
        }
    }

    private boolean checkGameOver(int steps) {
        if (winner != null) {
            return true;
        }
        if (steps == 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner" + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();

    }
}
