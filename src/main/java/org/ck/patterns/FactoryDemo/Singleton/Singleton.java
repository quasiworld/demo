package org.ck.patterns.FactoryDemo.Singleton;

/**
 * @ClassName: Singleton
 * @description 单例模式案例
 * @Date 2020年05月06日 14:35:35
 */
public class Singleton {

    //构造方法定位为外部的
    private Singleton(){}//构造方法私有化

    //因为设置为了静态的所以他在类加载的时候就只会创建一次实例
    //设为私有的防止外部调用这个实例
    private static final Singleton single=new Singleton();

    //提供入口，每次调用的都是唯一的实例
    public static Singleton getInstance(){
        return single;
    }
}
