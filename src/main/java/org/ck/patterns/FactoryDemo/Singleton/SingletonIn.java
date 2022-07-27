package org.ck.patterns.FactoryDemo.Singleton;

/**
 * @ClassName: SingletonIn
 * @description 静态内部类实现单例模式
 * @Date 2020年05月06日 15:14:19
 */
//因为本身不是静态类，不会在创建时就加载，实现了延迟加载
//在调用时，再调用一次静态内部类创建唯一不可改变的实例，实现了线程的安全
//写的真好
public class SingletonIn {

    private static class Singleton{
        private static final SingletonIn single=new SingletonIn();
    }
    private SingletonIn(){
        System.out.println("This is new instance!");
    }
    public static final SingletonIn getInstance(){
        return Singleton.single;
    }
}
