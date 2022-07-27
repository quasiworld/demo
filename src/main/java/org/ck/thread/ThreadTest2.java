package org.ck.thread;

/**
 * @className: ThreadTest2
 * @description:
 * @createDate: 2021年06月25日 14:08:56
 * @author: ns
 */
public class ThreadTest2 extends Thread {

    private String url;

    private String name;

    public ThreadTest2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downLoader(url, name);
        System.out.println("下载了文件名为" + name);
    }

    public static void main(String[] args) {
        ThreadTest2 threadTest1 = new ThreadTest2("https://img-blog.csdnimg.cn/2021061516385914.png#pic_center", "图1.png");
        ThreadTest2 threadTest2 = new ThreadTest2("https://img-blog.csdnimg.cn/20210615175631519.png#pic_center", "图2.png");
        ThreadTest2 threadTest3 = new ThreadTest2("https://img-blog.csdnimg.cn/20210616110215957.png#pic_center", "图3.png");
        threadTest1.start();
        threadTest2.start();
        threadTest3.start();
    }

}


