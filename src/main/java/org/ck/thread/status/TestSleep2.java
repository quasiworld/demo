package org.ck.thread.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @className: TestSleep2
 * @description:
 * @createDate: 2021年07月07日 14:51:31
 * @author: ck
 */
public class TestSleep2 {

    public static void main(String[] args) {
        //打印当前系统时间
        while (true) {
            try {
                //每个对象都有一个锁,sleep不会释放锁
                Thread.sleep(1000);
                System.out.println(new Date());
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0) {
                break;
            }
        }
    }
}
