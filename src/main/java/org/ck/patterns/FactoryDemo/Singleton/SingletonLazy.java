package org.ck.patterns.FactoryDemo.Singleton;

/**
 * @ClassName: SingletonLazy
 * @description 延迟加载同步单例模式
 * @Date 2020年05月06日 14:42:45
 */
public class SingletonLazy {

    private static volatile SingletonLazy singletonLazy;

    public SingletonLazy() {
    }

    public SingletonLazy getSingleton() {
        if (singletonLazy != null) {//查询处理
            return singletonLazy;
        }
        //加载处理
        synchronized (SingletonLazy.class) {
            if (singletonLazy == null) {
                singletonLazy = new SingletonLazy();
            }
        }
        return SingletonLazy.singletonLazy;
    }
}
