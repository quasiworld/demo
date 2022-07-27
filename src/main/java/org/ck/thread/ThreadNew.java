package org.ck.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @className: ThreadNew
 * @description: 回顾线程的创建
 * @createDate: 2021年07月19日 11:26:59
 * @author: ck
 */
public class ThreadNew {
    public static void main(String[] args) {
        new MyThread1().start();

        new Thread(new MyThread2()).start();

        FutureTask<Integer> futureTask =  new FutureTask<Integer>(new MyThread3());
        new Thread(futureTask).start();
        Integer integer = null;
        try {
            integer = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
    }
}
//1.继承Thread类
class MyThread1 extends Thread{

    public void run(){
        System.out.println("MyThread1");
    }
}
//2.实现Runnable接口
class MyThread2 implements Runnable{

    public void run(){
        System.out.println("MyThread2");
    }
}

//实现CallAble
class MyThread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread3");
        return  100;
    }
}