package org.ck.patterns.FactoryDemo.FileRead;

/**
 * @ClassName: UTF8Factory
 * @description
 * @Date 2020年05月07日 19:01:26
 */
public class UTF8Factory extends AbstractFactory {
    @Override
    public IRead create() {
        return new IUTF8();
    }
}
