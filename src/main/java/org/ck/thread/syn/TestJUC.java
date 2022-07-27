package org.ck.thread.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @className: TestJUC
 * @description: 测试JUC安全类型的集合
 * @createDate: 2021年07月15日 09:46:53
 * @author: ck
 */
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        for (int i = 0; i < 10000; i++) {
            new Thread(()-> list.add(Thread.currentThread().getName())).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
