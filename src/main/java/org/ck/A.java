package org.ck;

/**
 * @className: A
 * @description:
 * @createDate: 2021年12月22日 12:05:01
 * @author: ck
 */
public class A extends B{

    static {
        System.out.println("子类静态代码块");
    }

    public A(){
        System.out.println("子类构造方法");
    }

}
