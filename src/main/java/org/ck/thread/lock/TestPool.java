package org.ck.thread.lock;

import javax.sound.midi.Soundbank;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className: TestPool
 * @description: 测试线程池
 * @createDate: 2021年07月16日 18:52:54
 * @author: ck
 */
public class TestPool {

    public static void main(String[] args) {
        //创建服务
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        //关闭连接
        service.shutdown();
    }
}

class MyThread implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

}
