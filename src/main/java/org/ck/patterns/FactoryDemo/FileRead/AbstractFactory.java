package org.ck.patterns.FactoryDemo.FileRead;

/**
 * @ClassName: AbstractFactory
 * @description
 * @Date 2020年05月07日 18:51:30
 */
//让实体类实现接口
    //让工厂实现
public abstract class AbstractFactory {

    public abstract IRead create();

}
