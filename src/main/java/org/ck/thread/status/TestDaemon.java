package org.ck.thread.status;

/**
 * @className: TestDaemon
 * @description: 测试守护线程
 * @createDate: 2021年07月07日 16:11:27
 * @author: ck
 */
public class TestDaemon {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认false为用户线程
        thread.start();//守护线程启动

        new Thread(you).start();//

    }

}

class God implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}

class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("=======hello,world");
    }
}
