package org.ck.patterns.FactoryDemo.AbstractFactory;

/**
 * @ClassName: IRead
 * @description
 * @Date 2020年05月13日 14:44:38
 */
public interface IRead<T> {
    T read(String ... in);
}
