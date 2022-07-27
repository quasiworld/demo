package org.ck.thread.proystatic;

/**
 * @className: StaticProxy
 * @description: 静态代理：代理类似面向切面编程，注解和这个很像，找到横切面
 * 真实对象与代理角色都要实现同一个接口
 * 代理对象可以帮助真实对象做琐事
 * 真实对象只专注自己的事
 * @createDate: 2021年06月28日 11:05:39
 * @author: ns
 */

public class StaticProxy {

    public static void main(String[] args) {
        //线程实现
        new Thread(()-> System.out.println("爱")).start();
        //结婚代理
        new WeddingCompany(new You()).HappyMarry();
  /*      //自己结婚
        You you = new You();
        //代理结婚
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();*/
    }

}

interface Marry {
    //久旱逢甘露
    //他乡遇故知
    //金榜题名时
    void HappyMarry();
}

//真实角色，你去结婚
class You implements Marry {

    @Override
    public void HappyMarry() {
        System.out.println("结婚");
    }
}

//代理角色，帮助你结婚
class WeddingCompany implements Marry {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("收尾款");
    }

    private void before() {
        System.out.println("布置现场");
    }
}