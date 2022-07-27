package org.ck.patterns.FactoryDemo.FileRead;

/**
 * @ClassName: UncodeFactory
 * @description
 * @Date 2020年05月07日 19:00:06
 */
public class UncodeFactory extends AbstractFactory {
    @Override
    public IRead create() {
        return new IUncode();
    }
}
