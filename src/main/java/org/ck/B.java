package org.ck;

/**
 * @className: B
 * @description:
 * @createDate: 2021年12月22日 12:05:07
 * @author: ck
 */
public class B {
    static {
        System.out.println("父类静态代码块");
    }

    public B() {
        int i = 0;
        System.out.println("父类构造方法");
    }
}
