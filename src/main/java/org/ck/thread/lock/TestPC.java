package org.ck.thread.lock;

/**
 * @className: TestPC
 * @description: 测试:生产者消费者模型-》利用缓冲区解决
 * @createDate: 2021年07月16日 18:39:26
 * @author: ck
 */

public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();

    }
}

//生产者
class Productor extends Thread {

    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了" + i + "");
            container.push(new Chicken(i));
        }
    }

}

//消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    //消费
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+container.pop().id);
        }
    }
}

//产品
class Chicken {

    int id;

    public Chicken(int i){
        this.id = i;
    }

}

//缓冲区
class SynContainer {
    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];

    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken) {
        //如果容器满了，就需要等待消费者消费
        if (count == chickens.length) {
            //如果没有满需要丢入产品
        }
        chickens[count] = chicken;
        count++;
        //通知消费
    }

    public synchronized Chicken pop() {
        if (count == 0) {
            //等待生产者生产
        }
        count--;
        Chicken chicken = chickens[count];
        return chicken;
    }
    //消费者消费产品
}