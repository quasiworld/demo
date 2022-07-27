package org.ck.thread.syn;

/**
 * @className: DeadLock
 * @description: 死锁
 * @createDate: 2021年07月15日 10:03:12
 * @author: ck
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup girl = new Makeup(0,"灰姑凉");
        Makeup girl1 = new Makeup(1,"白雪公主");
        girl.start();
        girl1.start();
    }
}

class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择

    String girlName;

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //化妆
    }

    //化妆 互相持有对方的锁
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");
            }
        }else{
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");
                Thread.sleep(2000);
            }
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
            }
        }
    }
}
