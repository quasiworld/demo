package org.ck.patterns.FactoryDemo.FileRead;

/**
 * @ClassName: IUncode
 * @description UNCODE读取
 * @Date 2020年05月07日 18:38:59
 */
public class IUncode extends AbstractTextRead {
    @Override
    public void read(String fileName) {
        System.out.println("Uncode读取实现");
    }
}
