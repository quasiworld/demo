package org.ck.thread.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: UnSafeList
 * @description: 线程不安全的集合
 * @createDate: 2021年07月08日 18:44:00
 * @author: ck
 */
public class UnSafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                //两个线程操作了同一个位置，导致有数据被覆盖了
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
