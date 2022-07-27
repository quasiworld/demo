package org.ck.patterns.FactoryDemo.FileRead;

/**
 * @ClassName: IGBK
 * @description GBK读取对象
 * @Date 2020年05月07日 18:36:47
 */
public class IGBK extends AbstractTextRead {

    @Override
    public void read(String fileName) {
        System.out.println("GBK读取实现");
    }
}
