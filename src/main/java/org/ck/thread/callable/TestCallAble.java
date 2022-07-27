package org.ck.thread.callable;

import org.ck.thread.WebDownLoader;

import java.util.concurrent.*;

/**
 * @className: TestCallAble
 * @description: 实现callable 接口
 * @createDate: 2021年06月25日 17:39:45
 * @author: ns
 */
public class TestCallAble implements Callable<Boolean> {

    private String url;

    private String name;

    public TestCallAble(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public static void main(String[] args) {
        TestCallAble threadTest1 = new TestCallAble("https://img-blog.csdnimg.cn/2021061516385914.png#pic_center", "图1.png");
        TestCallAble threadTest2 = new TestCallAble("https://img-blog.csdnimg.cn/20210615175631519.png#pic_center", "图2.png");
        TestCallAble threadTest3 = new TestCallAble("https://img-blog.csdnimg.cn/20210616110215957.png#pic_center", "图3.png");
        ExecutorService ser = Executors.newFixedThreadPool(3);

        Future<Boolean> r1 = ser.submit(threadTest1);
        Future<Boolean> r2 = ser.submit(threadTest2);
        Future<Boolean> r3 = ser.submit(threadTest3);
        try {
            System.out.println(r1.get());
            System.out.println(r2.get());
            System.out.println(r3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ser.shutdown();
    }

    @Override
    public Boolean call() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downLoader(url, name);
        System.out.println("下载了文件名为" + name);
        return true;
    }
}
