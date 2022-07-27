package org.ck.patterns.FactoryDemo.FileRead;

/**
 * @ClassName: GBKFactory
 * @description GBK工厂
 * @Date 2020年05月07日 18:52:13
 */
public class GBKFactory extends AbstractFactory {
    //GBKFactory
    public IRead create(){
        return new IGBK();
    }
}
